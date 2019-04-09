package com.bakhir.wasteRecycling.dAO.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import com.bakhir.wasteRecycling.dAO.IProductDao;
import com.bakhir.wasteRecycling.models.Product;

public class ProductDao extends AbstractJDBC implements IProductDao {
	private static final Logger log = LogManager.getLogger(Product.class);
	private final static String SET_PRODUCT=("INSERT INTO  product (cost, weight, product_type_id, waste_recycling_factory_id ) VALUES (?,?,?,?)");
	private final static String UPDATE_PRODUCT=("UPDATE product SET cost=?, weight=?, product_type_id=?, waste_recycling_factory_id=?  WHERE id=?");
	private final static String GET_PRODUCT=("SELECT * FROM product  where id = ?");
	private final static String DELETE_PRODUCT=("DELETE FROM product WHERE id=?");	
	@Override
	public void insert(Product product)  {
		Connection connection =POOL.getConnection();
		try (PreparedStatement ps= connection.prepareStatement(SET_PRODUCT)){	
			ps.setInt(1, product.getCost());
			ps.setInt(2, product.getWeight());
			ps.setInt(3, product.getProductTypeId());
			ps.setInt(4, product.getWasteRecyclingFactoryId());
			ps.executeUpdate();
		} catch (SQLException e) {
			log.error(e);
		} finally {
			POOL.releaseConnection(connection);
		}
	}
	@Override
	public void update(Product product) {
		Connection connection =POOL.getConnection();
		try (PreparedStatement ps= connection.prepareStatement(UPDATE_PRODUCT)){	
			ps.setInt(1, product.getCost());
			ps.setInt(2, product.getWeight());
			ps.setInt(3, product.getProductTypeId());
			ps.setInt(4, product.getWasteRecyclingFactoryId());
			ps.setLong(5, product.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			log.error(e);
		} finally {
			POOL.releaseConnection(connection);
		}
	}
	
	@Override
	public Product getById(long id)  {
		Connection connection =POOL.getConnection();
		ResultSet rs = null;
		Product product = new Product();
		try (PreparedStatement ps= connection.prepareStatement(GET_PRODUCT)){
			ps.setLong(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				buildProduct(rs, product);
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
		return product;
	}
	
	@Override
	public void delete(Product product)  {
		Connection connection =POOL.getConnection();
		try (PreparedStatement ps= connection.prepareStatement(DELETE_PRODUCT)){
			ps.setLong(1, product.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			log.error(e);
		} finally {
			POOL.releaseConnection(connection);
		}
	}

	private void buildProduct(ResultSet rs, Product product) throws SQLException {
		product.setCost(rs.getInt("cost"));
		product.setWeight(rs.getInt("weight"));
		product.setProductTypeId(rs.getInt("product_type_id"));
		product.setWasteRecyclingFactoryId(rs.getInt("waste_recycling_factory_id"));
		product.setId(rs.getInt("id"));		
	}
}
