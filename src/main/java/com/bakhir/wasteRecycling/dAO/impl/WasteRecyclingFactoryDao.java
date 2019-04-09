package com.bakhir.wasteRecycling.dAO.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import com.bakhir.wasteRecycling.dAO.IWasteRecyclingFactoryDao;
import com.bakhir.wasteRecycling.models.WasteRecyclingFactory;

public class WasteRecyclingFactoryDao extends AbstractJDBC implements IWasteRecyclingFactoryDao {
	private static final Logger log = LogManager.getLogger(UtilityCompanyDao.class);
	private final static String SET_WASTE_RECYCLING_FACTORY=("INSERT INTO  waste_recycling_factory (name, number_employees, adress_id) VALUES (?,?,?)");
	private final static String UPDATE_WASTE_RECYCLING_FACTORY=("UPDATE waste_recycling_factory SET name=?, number_employees=?, adress_id=?,  WHERE id=?");
	private final static String GET_WASTE_RECYCLING_FACTORY=("SELECT * FROM waste_recycling_factory  where id = ?");
	private final static String DELETE_WASTE_RECYCLING_FACTORY=("DELETE FROM waste_recycling_factory WHERE id=?");
	
	@Override
	public void insert(WasteRecyclingFactory wasteRecyclingFactory)  {
		Connection connection =POOL.getConnection();
		try (PreparedStatement ps= connection.prepareStatement(SET_WASTE_RECYCLING_FACTORY)){
			ps.setString(1, wasteRecyclingFactory.getName());
			ps.setInt(2, wasteRecyclingFactory.getNumberEmployees());
			ps.setInt(3, wasteRecyclingFactory.getAdressId());
			ps.executeUpdate();
		} catch (SQLException e) {
			log.error(e);
		}  finally {
			POOL.releaseConnection(connection);			
		}
	}
	@Override
	public void update(WasteRecyclingFactory wasteRecyclingFactory) {
		Connection connection =POOL.getConnection();
		try (PreparedStatement ps= connection.prepareStatement(UPDATE_WASTE_RECYCLING_FACTORY)){
			ps.setString(1, wasteRecyclingFactory.getName());	
			ps.setInt(2, wasteRecyclingFactory.getNumberEmployees());
			ps.setLong(3, wasteRecyclingFactory.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			log.error(e);
		}finally {
			POOL.releaseConnection(connection);
		}
	}
	
	@Override
	public WasteRecyclingFactory getById(long id)  {
		Connection connection =POOL.getConnection();
		ResultSet rs = null;
		WasteRecyclingFactory wasteRecyclingFactory = new WasteRecyclingFactory();
		try (PreparedStatement ps= connection.prepareStatement(GET_WASTE_RECYCLING_FACTORY)){
			ps.setLong(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				buildWasteRecyclingFactory(rs, wasteRecyclingFactory);
			}
		} catch (SQLException e) {
			log.error(e);
		}  finally {
			POOL.releaseConnection(connection);
			try {
				rs.close();
			} catch (SQLException e) {
				log.error(e);
			}			
		}
		return wasteRecyclingFactory;
	}
	
	@Override
	public void delete(WasteRecyclingFactory wasteRecyclingFactory)  {
		Connection connection =POOL.getConnection();
		try (PreparedStatement ps= connection.prepareStatement(DELETE_WASTE_RECYCLING_FACTORY)){
			ps.setLong(1, wasteRecyclingFactory.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			log.error(e);
		} finally {
			POOL.releaseConnection(connection);
		}
	}

	private void buildWasteRecyclingFactory(ResultSet rs, WasteRecyclingFactory wasteRecyclingFactory) throws SQLException {
		wasteRecyclingFactory.setName(rs.getString("name"));
		wasteRecyclingFactory.setNumberEmployees(rs.getInt("number_employees"));
		wasteRecyclingFactory.setAdressId(rs.getInt("adress_id"));
		wasteRecyclingFactory.setId(rs.getInt("id"));
	}
}
