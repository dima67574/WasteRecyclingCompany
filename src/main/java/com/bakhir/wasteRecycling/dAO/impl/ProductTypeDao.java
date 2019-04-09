package com.bakhir.wasteRecycling.dAO.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import com.bakhir.wasteRecycling.dAO.IProductTypeDao;
import com.bakhir.wasteRecycling.models.ProductType;

public class ProductTypeDao extends AbstractJDBC implements IProductTypeDao {
	private static final Logger log = LogManager.getLogger(ProductTypeDao.class);
	private final static String SET_PRODUCT_TYPE=("INSERT INTO  product_type (name, usage) VALUES (?,?)");
	private final static String UPDATE_PRODUCT_TYPE=("UPDATE product_type SET name=?, usage=? WHERE id=?");
	private final static String GET_PRODUCT_TYPE=("SELECT * FROM product_type  where id = ?");
	private final static String DELETE_PRODUCT_TYPE=("DELETE FROM product_type WHERE id=?");
	@Override
	public void insert(ProductType productType)  {
		Connection connection =POOL.getConnection();
		try (PreparedStatement ps= connection.prepareStatement(SET_PRODUCT_TYPE)){	
			ps.setString(1, productType.getName());
			ps.setString(2, productType.getUsage());
			ps.executeUpdate();
		} catch (SQLException e) {
			log.error(e);
		} finally {
			POOL.releaseConnection(connection);
		}
	}
	@Override
	public void update(ProductType productType) {
		Connection connection =POOL.getConnection();
		try (PreparedStatement ps= connection.prepareStatement(UPDATE_PRODUCT_TYPE)){	
			ps.setString(1, productType.getName());
			ps.setString(2, productType.getUsage());
			ps.setLong(3, productType.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			log.error(e);
		} finally {
			POOL.releaseConnection(connection);
		}
	}
	
	@Override
	public ProductType getById(long id)  {
		Connection connection =POOL.getConnection();
		ResultSet rs = null;
		ProductType productType = new ProductType();
		try (PreparedStatement ps= connection.prepareStatement(GET_PRODUCT_TYPE)){
			ps.setLong(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				buildProductType(rs, productType);
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
		return productType;
	}
	
	@Override
	public void delete(ProductType productType)  {
		Connection connection =POOL.getConnection();
		try (PreparedStatement ps= connection.prepareStatement(DELETE_PRODUCT_TYPE)){
			ps.setLong(1, productType.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			log.error(e);
		} finally {
			POOL.releaseConnection(connection);
		}
	}

	private void buildProductType(ResultSet rs, ProductType productType) throws SQLException {
		productType.setName(rs.getString("name"));
		productType.setUsage(rs.getString("usage"));
		productType.setId(rs.getInt("id"));
	}
}
