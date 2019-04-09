package com.bakhir.wasteRecycling.services;

import com.bakhir.wasteRecycling.dAO.IProductTypeDao;
import com.bakhir.wasteRecycling.models.ProductType;
import com.bakhir.wasteRecycling.myBatis.MyBatisConnection;

public class ProductTypeService implements IProductTypeDao {
	private IProductTypeDao productTypeDao= MyBatisConnection.getInstance().getSqlSessionFactory().openSession().getMapper(IProductTypeDao.class);
	@Override
	public void insert(ProductType productType)  {		
			productTypeDao.insert(productType);	
		
	}

	@Override
	public ProductType getById(long id) {
		ProductType productType = productTypeDao.getById(id);		
		return productType;
	}

	@Override
	public void update(ProductType productType) {
		productTypeDao.update(productType);
		
	}


	@Override
	public void delete(ProductType productType) {
		productTypeDao.delete(productType);
		
	}

}
