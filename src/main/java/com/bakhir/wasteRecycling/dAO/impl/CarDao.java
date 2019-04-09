package com.bakhir.wasteRecycling.dAO.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.bakhir.wasteRecycling.dAO.ICarDao;
import com.bakhir.wasteRecycling.models.Car;

public class CarDao extends AbstractJDBC implements ICarDao {
	private static final Logger log = LogManager.getLogger(CarDao.class);
	private final static String SET_CAR=("INSERT INTO  car (manufacturer, model, date_of_manufacture, capacity, utility_company_id, waste_recycling_factory_id, incineration_factory_id  ) VALUES (?,?,?,?,?,?,?)");
	private final static String UPDATE_CAR=("UPDATE car SET manufacturer=?, model=?, date_of_manufacture=?, capacity=?, utility_company_id=?, waste_recycling_factory_id=?, incineration_factory_id=?  WHERE id=?");
	private final static String GET_CAR=("SELECT * FROM car  where id = ?");
	private final static String DELETE_CAR=("DELETE FROM car WHERE id=?");	
	@Override
	public void insert(Car car)  {
		Connection connection =POOL.getConnection();
		try (PreparedStatement ps= connection.prepareStatement(SET_CAR)){						
			ps.setString(1, car.getManufacturer());
			ps.setString(2, car.getModel());
			ps.setString(3, car.getDateOfManufacture());
			ps.setInt(4, car.getCapacity());
			ps.setInt(5, car.getUtilityCompanyId());
			ps.setInt(6, car.getWasteRecyclingFactoryId());
			ps.setInt(7, car.getIncinerationFactoryId());
			ps.executeUpdate();
		} catch (SQLException e) {
			log.error(e);
		} finally {
			POOL.releaseConnection(connection);			
		}
	}
	@Override
	public void update(Car car) {
		
		Connection connection =POOL.getConnection();
		try (PreparedStatement ps= connection.prepareStatement(UPDATE_CAR)){
			ps.setString(1, car.getManufacturer());
			ps.setString(2, car.getModel());
			ps.setString(3, car.getDateOfManufacture());
			ps.setInt(4, car.getCapacity());
			ps.setInt(5, car.getUtilityCompanyId());
			ps.setInt(6, car.getWasteRecyclingFactoryId());
			ps.setInt(7, car.getIncinerationFactoryId());		
			ps.setLong(8, car.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			log.error(e);
		} finally {
			POOL.releaseConnection(connection);			
		}
	}
	
	@Override
	public Car getById(long id)  {
		Connection connection =POOL.getConnection();		
		ResultSet rs = null;
		Car car = new Car();
		try (PreparedStatement ps= connection.prepareStatement(GET_CAR)){
			ps.setLong(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				buildCar(rs, car);
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
		return car;
	}
	
	@Override
	public void delete(Car car)  {
		Connection connection =POOL.getConnection();		
		try (PreparedStatement ps= connection.prepareStatement(DELETE_CAR)){
			ps.setLong(1, car.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			log.error(e);
		} finally {
			POOL.releaseConnection(connection);			
		}
	}

	private void buildCar(ResultSet rs, Car car) throws SQLException {
	
		car.setManufacturer(rs.getString("manufacturer"));
		car.setModel(rs.getString("model"));
		car.setDateOfManufacture(rs.getString("date_of_manufacture"));
		car.setCapacity(rs.getInt("capacity"));
		car.setUtilityCompanyId(rs.getInt("utility_company_id"));
		car.setWasteRecyclingFactoryId(rs.getInt("waste_recycling_factory_id"));
		car.setIncinerationFactoryId(rs.getInt("incineration_factory_id"));		
		car.setId(rs.getInt("id"));
	}
}
