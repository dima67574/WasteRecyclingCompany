package com.bakhir.wasteRecycling.dAO.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import com.bakhir.wasteRecycling.dAO.IEnergyResourceDao;
import com.bakhir.wasteRecycling.models.EnergyResource;

public class EnergyResourceDao extends AbstractJDBC implements IEnergyResourceDao {
	private static final Logger log = LogManager.getLogger(EnergyResource.class);
	private final static String SET_ENERGO_RESOURCE=("INSERT INTO  energy_resource (weight,incineration_factory_id, energy_resource_type_id) VALUES (?,?,?)");
	private final static String UPDATE_ENERGO_RESOURCE=("UPDATE energy_resource SET weight=?, incineration_factory_id=?, energy_resource_type_id=? WHERE id=?");
	private final static String GET_ENERGO_RESOURCE=("SELECT * FROM energy_resource  where id = ?");
	private final static String DELETE_ENERGO_RESOURCE=("DELETE FROM energy_resource WHERE id=?");	
	@Override
	public void insert(EnergyResource energyResource)  {
		Connection connection =POOL.getConnection();
		try (PreparedStatement ps= connection.prepareStatement(SET_ENERGO_RESOURCE)){
			ps.setInt(1, energyResource.getWeight());
			ps.setInt(2, energyResource.getIncinerationFactoryId());
			ps.setInt(3, energyResource.getEnergyResourceTypeId());
			ps.executeUpdate();
		} catch (SQLException e) {

			log.error(e);
		} finally {
			POOL.releaseConnection(connection);			
		}
	}
	@Override
	public void update(EnergyResource energyResource) {		
		Connection connection =POOL.getConnection();
		try (PreparedStatement ps= connection.prepareStatement(UPDATE_ENERGO_RESOURCE)){
			ps.setInt(1, energyResource.getWeight());
			ps.setInt(2, energyResource.getIncinerationFactoryId());
			ps.setInt(3, energyResource.getEnergyResourceTypeId());
			ps.setLong(4, energyResource.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			log.error(e);
		} finally {
			POOL.releaseConnection(connection);			
		}
	}
	
	@Override
	public EnergyResource getById(long id)  {
		Connection connection =POOL.getConnection();		
		ResultSet rs = null;
		EnergyResource energyResource = new EnergyResource();
		try (PreparedStatement ps= connection.prepareStatement(GET_ENERGO_RESOURCE)){	
			ps.setLong(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				buildEnergyResource(rs, energyResource);
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
		return energyResource;
	}
	
	@Override
	public void delete(EnergyResource energyResource)  {
		Connection connection =POOL.getConnection();
		try (PreparedStatement ps= connection.prepareStatement(DELETE_ENERGO_RESOURCE)){
			ps.setLong(1, energyResource.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			log.error(e);
		} finally {
			POOL.releaseConnection(connection);			
		}
	}

	private void buildEnergyResource(ResultSet rs, EnergyResource energyResource) throws SQLException {
		energyResource.setWeight(rs.getInt("weight"));
		energyResource.setIncinerationFactoryId(rs.getInt("incineration_factory_id"));
		energyResource.setEnergyResourceTypeId(rs.getInt("energy_resource_type_id"));
		energyResource.setId(rs.getInt("id"));		
	}
}
