package com.bakhir.wasteRecycling.dAO.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import com.bakhir.wasteRecycling.dAO.IWasteTypeDao;
import com.bakhir.wasteRecycling.models.WasteType;

public class WasteTypeDao extends AbstractJDBC implements IWasteTypeDao {
	private static final Logger log = LogManager.getLogger(WasteTypeDao.class);
	private final static String SET_WASTE_TYPE=("INSERT INTO  waste_type (name) VALUES (?)");
	private final static String UPDATE_WASTE_TYPE=("UPDATE waste_type SET name=? WHERE id=?");
	private final static String GET_WASTE_TYPE=("SELECT * FROM waste_type  where id = ?");
	private final static String DELETE_WASTE_TYPE=("DELETE FROM waste_type WHERE id=?");
	@Override
	public void insert(WasteType wasteType)  {
		Connection connection =POOL.getConnection();
		try (PreparedStatement ps= connection.prepareStatement(SET_WASTE_TYPE)){
			ps.setString(1, wasteType.getName());
			ps.executeUpdate();
		} catch (SQLException e) {

			log.error(e);
		} finally {
			POOL.releaseConnection(connection);
		}
	}
	@Override
	public void update(WasteType wasteType) {
		Connection connection =POOL.getConnection();
		try (PreparedStatement ps= connection.prepareStatement(UPDATE_WASTE_TYPE)){	
			ps.setString(1, wasteType.getName());			
			ps.setLong(2, wasteType.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			log.error(e);
		}  finally {
			POOL.releaseConnection(connection);
		}
	}
	
	@Override
	public WasteType getById(long id)  {
		Connection connection =POOL.getConnection();
		ResultSet rs = null;
		WasteType wasteType = new WasteType();
		try (PreparedStatement ps= connection.prepareStatement(GET_WASTE_TYPE)){
			ps.setLong(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				buildWasteType(rs, wasteType);
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
		return wasteType;
	}
	
	@Override
	public void delete(WasteType wasteType)  {
		Connection connection =POOL.getConnection();
		try (PreparedStatement ps= connection.prepareStatement(DELETE_WASTE_TYPE)){
			ps.setLong(1, wasteType.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			log.error(e);
		} finally {
			POOL.releaseConnection(connection);
		}
	}

	private void buildWasteType(ResultSet rs, WasteType wasteType) throws SQLException {
		wasteType.setName(rs.getString("name"));
		wasteType.setId(rs.getInt("id"));
	}
}
