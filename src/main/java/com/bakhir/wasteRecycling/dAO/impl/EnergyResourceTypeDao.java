package com.bakhir.wasteRecycling.dAO.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import com.bakhir.wasteRecycling.dAO.IEnergyResourceTypeDao;
import com.bakhir.wasteRecycling.models.EnergyResourceType;

public class EnergyResourceTypeDao extends AbstractJDBC implements IEnergyResourceTypeDao {
	private static final Logger log = LogManager.getLogger(EnergyResourceTypeDao.class);
	private final static String SET_ENERGO_RESOURCE_TYPE=("INSERT INTO  energy_resource_type (name,generated_energy) VALUES (?,?)");
	private final static String UPDATE_ENERGO_RESOURCE_TYPE=("UPDATE energy_resource_type SET name=?, generated_energy=? WHERE id=?");
	private final static String GET_ENERGO_RESOURCE_TYPE=("SELECT * FROM energy_resource_type  where id = ?");
	private final static String DELETE_ENERGO_RESOURCE_TYPE=("DELETE FROM energy_resource_type WHERE id=?");
	@Override
	public void insert(EnergyResourceType energyResourceType)  {
		Connection connection =POOL.getConnection();
		try (PreparedStatement ps= connection.prepareStatement(SET_ENERGO_RESOURCE_TYPE)){
			ps.setString(1, energyResourceType.getName());
			ps.setInt(2, energyResourceType.getGeneratedEnergy());
			ps.executeUpdate();
		} catch (SQLException e) {

			log.error(e);
		} finally {
			POOL.releaseConnection(connection);			
		}
	}
	@Override
	public void update(EnergyResourceType energyResourceType) {		
		Connection connection =POOL.getConnection();
		try (PreparedStatement ps= connection.prepareStatement(UPDATE_ENERGO_RESOURCE_TYPE)){
			ps.setString(1, energyResourceType.getName());	
			ps.setInt(2, energyResourceType.getGeneratedEnergy());
			ps.setLong(3, energyResourceType.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			log.error(e);
		} finally {
			POOL.releaseConnection(connection);			
		}
	}
	
	@Override
	public EnergyResourceType getById(long id)  {
		Connection connection =POOL.getConnection();		
		ResultSet rs = null;
		EnergyResourceType energyResourceType = new EnergyResourceType();
		try (PreparedStatement ps= connection.prepareStatement(GET_ENERGO_RESOURCE_TYPE)){	
			ps.setLong(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				buildEnergyResourceType(rs, energyResourceType);
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
		return energyResourceType;
	}
	
	@Override
	public void delete(EnergyResourceType energyResourceType)  {
		Connection connection =POOL.getConnection();
		try (PreparedStatement ps= connection.prepareStatement(DELETE_ENERGO_RESOURCE_TYPE)){
			ps.setLong(1, energyResourceType.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			log.error(e);
		} finally {
			POOL.releaseConnection(connection);			
		}
	}

	private void buildEnergyResourceType(ResultSet rs, EnergyResourceType energyResourceType) throws SQLException {
		energyResourceType.setName(rs.getString("name"));
		energyResourceType.setGeneratedEnergy(rs.getInt("generated_energy"));
		energyResourceType.setId(rs.getInt("id"));
	}
}
