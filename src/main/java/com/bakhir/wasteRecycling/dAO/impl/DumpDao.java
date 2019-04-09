package com.bakhir.wasteRecycling.dAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import com.bakhir.wasteRecycling.dAO.IDumpDao;
import com.bakhir.wasteRecycling.models.Dump;

public class DumpDao extends AbstractJDBC implements IDumpDao {
	private static final Logger log = LogManager.getLogger(DumpDao.class);
	private final static String SET_DUMP=("INSERT INTO  dump (capacity, adress_id, utility_company_id ) VALUES (?,?,?)");
	private final static String UPDATE_DUMP=("UPDATE dump SET capacity=?, adress_id=?, utility_company_id=?  WHERE id=?");
	private final static String GET_DUMP=("SELECT * FROM dump  where id = ?");
	private final static String DELETE_DUMP=("DELETE FROM dump WHERE id=?");
	
	@Override
	public void insert(Dump dump)  {
		Connection connection =POOL.getConnection();		
		try (PreparedStatement ps= connection.prepareStatement(SET_DUMP)){	
			ps.setInt(1, dump.getCapacity());
			ps.setInt(2, dump.getAdressId());
			ps.setInt(3, dump.getUtilityCompanyId());
			ps.executeUpdate();
		} catch (SQLException e) {

			log.error(e);
		} finally {
			POOL.releaseConnection(connection);			
		}
	}
	@Override
	public void update(Dump dump) {		
		Connection connection =POOL.getConnection();
		try (PreparedStatement ps= connection.prepareStatement(UPDATE_DUMP)){
			ps.setInt(1, dump.getCapacity());
			ps.setInt(2, dump.getAdressId());
			ps.setInt(3, dump.getUtilityCompanyId());		
			ps.setLong(4, dump.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			log.error(e);
		} finally {
			POOL.releaseConnection(connection);			
		}
	}
	
	@Override
	public Dump getById(long id)  {
		Connection connection =POOL.getConnection();		
		ResultSet rs = null;
		Dump dump = new Dump();
		try (PreparedStatement ps= connection.prepareStatement(GET_DUMP)){	
			ps.setLong(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				buildDump(rs, dump);
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
		return dump;
	}
	
	@Override
	public void delete(Dump dump)  {
		Connection connection =POOL.getConnection();		
		try (PreparedStatement ps= connection.prepareStatement(DELETE_DUMP)){
			ps.setLong(1, dump.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			log.error(e);
		} finally {
			POOL.releaseConnection(connection);
		}
	}

	private void buildDump(ResultSet rs, Dump dump) throws SQLException {		
		dump.setCapacity(rs.getInt("capacity"));
		dump.setAdressId(rs.getInt("adress_id"));
		dump.setUtilityCompanyId(rs.getInt("utility_company_id"));
		dump.setId(rs.getInt("id"));
	}
}
