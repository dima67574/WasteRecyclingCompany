package com.bakhir.wasteRecycling.dAO.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.bakhir.wasteRecycling.dAO.IAdressDao;
import com.bakhir.wasteRecycling.models.Adress;


public class AdressDao extends AbstractJDBC implements IAdressDao {
	private static final Logger log = LogManager.getLogger(Adress.class);
	private final static String SET_ADRESS=("INSERT INTO  adress (coutry, region, city, street, number, zip_code) VALUES (?,?,?,?,?,?)");
	
	private final static String UPDATE_ADRESS=("UPDATE adress SET coutry=?, region=?, city=?, street=?, number=?, zip_code=?  WHERE id=?");
	private final static String GET_ADRESS=("SELECT * FROM adress  where id = ?");
	private final static String DELETE_ADRESS=("DELETE FROM adress WHERE id=?");
	@Override
	public void insert(Adress address)  {
		Connection connection =POOL.getConnection();	
		try (PreparedStatement ps= connection.prepareStatement(SET_ADRESS )){	
			connection.setAutoCommit(false);
			ps.setString(1, address.getCountry());
			ps.setString(2, address.getRegion());
			ps.setString(3, address.getCity());
			ps.setString(4, address.getStreet());
			ps.setString(5, address.getNumber());
			ps.setInt(6, address.getZipCode());
			ps.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				log.error(e1);
			}
			log.error(e);
		} finally {
			POOL.releaseConnection(connection);			
		}
	}
	@Override
	public void update(Adress address) {
		
		Connection connection =POOL.getConnection();
		try (PreparedStatement ps= connection.prepareStatement(UPDATE_ADRESS )){		
			ps.setString(1, address.getCountry());
			ps.setString(2, address.getRegion());
			ps.setString(3, address.getCity());
			ps.setString(4, address.getStreet());
			ps.setString(5, address.getNumber());
			ps.setInt(6, address.getZipCode());			
			ps.setLong(7, address.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			log.error(e);
		} finally {
			POOL.releaseConnection(connection);
		}
	}
	
	@Override
	public Adress getById(long id)  {
		Connection connection =POOL.getConnection();		
		ResultSet rs = null;
		Adress address = new Adress();
		try (PreparedStatement ps= connection.prepareStatement(GET_ADRESS)){				
			ps.setLong(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				buildAdress(rs, address);
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
		return address;
	}
	
	@Override
	public void delete(Adress adress)  {
		Connection connection =POOL.getConnection();
		try (PreparedStatement ps= connection.prepareStatement(DELETE_ADRESS)){	
			ps.setLong(1, adress.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			log.error(e);
		} finally {
			POOL.releaseConnection(connection);		
		}
	}

	private void buildAdress(ResultSet rs, Adress address) throws SQLException {
		address.setCountry(rs.getString("coutry"));
		address.setRegion(rs.getString("region"));
		address.setCity(rs.getString("city"));
		address.setStreet(rs.getString("street"));
		address.setNumber(rs.getString("number"));
		address.setZipCode(rs.getInt("zip_code"));
		address.setId(rs.getInt("id"));		
	}
}
