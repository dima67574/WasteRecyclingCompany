package com.bakhir.wasteRecycling.services;

import com.bakhir.wasteRecycling.dAO.IProductDao;
import com.bakhir.wasteRecycling.dAO.IProductTypeDao;
import com.bakhir.wasteRecycling.dAO.IWasteRecyclingFactoryDao;
import com.bakhir.wasteRecycling.dAO.impl.ProductDao;
import com.bakhir.wasteRecycling.dAO.impl.ProductTypeDao;
import com.bakhir.wasteRecycling.dAO.impl.WasteRecyclingFactoryDao;
import com.bakhir.wasteRecycling.models.Product;

public class ProductService {
	private IProductDao productDao=new ProductDao();
	private IProductTypeDao productTypeDao=new ProductTypeDao();
	private IWasteRecyclingFactoryDao wasteRecyclingFactoryDao=new WasteRecyclingFactoryDao();
	public Product getById(long id)  {		 
		Product product=productDao.getById(id);
		product.setProductType(productTypeDao.getById(product.getProductTypeId()));
		product.setWasteRecyclingFactory(wasteRecyclingFactoryDao.getById(product.getWasteRecyclingFactoryId()));
		return product;		 
	}
	public void insert(Product product)  {
		productDao.insert(product);
		productTypeDao.insert(product.getProductType());
		wasteRecyclingFactoryDao.insert(product.getWasteRecyclingFactory());
		
	}
	public void update(Product product) {	
		productDao.update(product);
		productTypeDao.update(product.getProductType());
		wasteRecyclingFactoryDao.update(product.getWasteRecyclingFactory());		
		
	}
	public void delete(Product product)  {
		productDao.delete(product);
		productTypeDao.delete(product.getProductType());
		wasteRecyclingFactoryDao.delete(product.getWasteRecyclingFactory());	
		
	}
}
