package com.bakhir.wasteRecycling.dAO.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import com.bakhir.wasteRecycling.dAO.IIncinerationFactoryDao;
import com.bakhir.wasteRecycling.models.IncinerationFactory;
public class IncinerationFactoryDao extends AbstractJDBC implements IIncinerationFactoryDao {
	private static final Logger log = LogManager.getLogger(IncinerationFactory.class);
	private final static String SET_INCINERATION_FACTORY=("INSERT INTO  incineration_factory (name, number_employees, adress_id) VALUES (?,?,?)");
	private final static String UPDATE_INCINERATION_FACTORY=("UPDATE incineration_factory SET name=?, number_employees=?, adress_id=?,  WHERE id=?");
	private final static String GET_INCINERATION_FACTORY=("SELECT * FROM incineration_factory  where id = ?");
	private final static String DELETE_INCINERATION_FACTORY=("DELETE FROM incineration_factory WHERE id=?");
	
	@Override
	public void insert(IncinerationFactory incinerationFactory)  {
		Connection connection =POOL.getConnection();
		try (PreparedStatement ps= connection.prepareStatement(SET_INCINERATION_FACTORY)){	
			ps.setString(1, incinerationFactory.getName());
			ps.setInt(2, incinerationFactory.getNumberEmployees());
			ps.setInt(3, incinerationFactory.getAdressId());
			ps.executeUpdate();
		} catch (SQLException e) {
			log.error(e);
		} finally {
			POOL.releaseConnection(connection);
		}
	}
	@Override
	public void update(IncinerationFactory incinerationFactory) {		
		Connection connection =POOL.getConnection();
		try (PreparedStatement ps= connection.prepareStatement(UPDATE_INCINERATION_FACTORY)){
			ps.setString(1, incinerationFactory.getName());	
			ps.setInt(2, incinerationFactory.getNumberEmployees());
			ps.setLong(3, incinerationFactory.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			log.error(e);
		} finally {
			POOL.releaseConnection(connection);			
		}
	}
	
	@Override
	public IncinerationFactory getById(long id)  {
		Connection connection =POOL.getConnection();
		ResultSet rs = null;
		IncinerationFactory incinerationFactory = new IncinerationFactory();
		try (PreparedStatement ps= connection.prepareStatement(GET_INCINERATION_FACTORY)){	
			ps.setLong(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				buildIncinerationFactory(rs, incinerationFactory);
			}
		} catch (SQLException e) {
			log.error(e);
		} finally {
			POOL.releaseConnection(connection);
			try {
				rs.close();
			} catch (SQLException e) {
				log.error(e);
			}
			
		}
		return incinerationFactory;
	}
	
	@Override
	public void delete(IncinerationFactory incinerationFactory)  {
		Connection connection =POOL.getConnection();		
		try (PreparedStatement ps= connection.prepareStatement(DELETE_INCINERATION_FACTORY)){	
			ps.setLong(1, incinerationFactory.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			log.error(e);
		} finally {
			POOL.releaseConnection(connection);
		}
	}

	private void buildIncinerationFactory(ResultSet rs, IncinerationFactory incinerationFactory) throws SQLException {
		incinerationFactory.setName(rs.getString("name"));
		incinerationFactory.setNumberEmployees(rs.getInt("number_employees"));
		incinerationFactory.setAdressId(rs.getInt("adress_id"));
		incinerationFactory.setId(rs.getInt("id"));
	}
}
