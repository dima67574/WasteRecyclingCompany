package com.bakhir.wasteRecycling.dAO.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import com.bakhir.wasteRecycling.dAO.IUtilityCompanyDao;
import com.bakhir.wasteRecycling.models.UtilityCompany;

public class UtilityCompanyDao extends AbstractJDBC implements IUtilityCompanyDao {
	private static final Logger log = LogManager.getLogger(UtilityCompanyDao.class);
	private final static String SET_UTILITY_COMPANY=("INSERT INTO  utility_company (name, number_employees, adress_id) VALUES (?,?,?)");
	private final static String UPDATE_UTILITY_COMPANY=("UPDATE utility_company SET name=?, number_employees=?, adress_id=?  WHERE id=?");
	private final static String GET_UTILITY_COMPANY=("SELECT * FROM utility_company  where id = ?");
	private final static String DELETE_UTILITY_COMPANY=("DELETE FROM utility_company WHERE id=?");
	
	@Override
	public void insert(UtilityCompany utilityCompany)  {
		Connection connection =POOL.getConnection();
		try (PreparedStatement ps= connection.prepareStatement(SET_UTILITY_COMPANY, Statement.RETURN_GENERATED_KEYS)){
			ps.setString(1, utilityCompany.getName());
			ps.setInt(2, utilityCompany.getNumberEmployees());
			ps.setInt(3, utilityCompany.getAdressId());
			ps.executeUpdate();
			 try (ResultSet generatedKeys = ps.getGeneratedKeys()) {	
				 if (generatedKeys.next()) {
				 utilityCompany.setId(generatedKeys.getLong(1));
				 }
	            	}
		} catch (SQLException e) {
			log.error(e);
		}  finally {
			POOL.releaseConnection(connection);
		}
	}
	@Override
	public void update(UtilityCompany utilityCompany) {
		Connection connection =POOL.getConnection();
		try (PreparedStatement ps= connection.prepareStatement(UPDATE_UTILITY_COMPANY)){
			ps.setString(1, utilityCompany.getName());	
			ps.setInt(2, utilityCompany.getNumberEmployees());
			ps.setInt(3, utilityCompany.getAdressId());
			ps.setLong(4, utilityCompany.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			log.error(e);
		}  finally {
			POOL.releaseConnection(connection);
		}
	}
	
	@Override
	public UtilityCompany getById(long id)  {
		Connection connection =POOL.getConnection();
		ResultSet rs = null;
		UtilityCompany utilityCompany = new UtilityCompany();
		try (PreparedStatement ps= connection.prepareStatement(GET_UTILITY_COMPANY)){
			ps.setLong(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				buildUtilityCompany(rs, utilityCompany);
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
		return utilityCompany;
	}
	
	@Override
	public void delete(UtilityCompany utilityCompany)  {
		Connection connection =POOL.getConnection();
		try (PreparedStatement ps= connection.prepareStatement(DELETE_UTILITY_COMPANY)){
			ps.setLong(1, utilityCompany.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			log.error(e);
		} finally {
			POOL.releaseConnection(connection);
		}
	}

	private void buildUtilityCompany(ResultSet rs, UtilityCompany utilityCompany) throws SQLException {
		utilityCompany.setName(rs.getString("name"));
		utilityCompany.setNumberEmployees(rs.getInt("number_employees"));
		utilityCompany.setAdressId(rs.getInt("adress_id"));
		utilityCompany.setId(rs.getInt("id"));
	}
}
