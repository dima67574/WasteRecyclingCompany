package com.bakhir.wasteRecycling.services;

import com.bakhir.wasteRecycling.dAO.IAdressDao;
import com.bakhir.wasteRecycling.dAO.IWasteRecyclingFactoryDao;
import com.bakhir.wasteRecycling.models.WasteRecyclingFactory;
import com.bakhir.wasteRecycling.myBatis.MyBatisConnection;

public class WasteRecyclingFactoryService implements IWasteRecyclingFactoryDao {
	private IAdressDao adressDao= MyBatisConnection.getInstance().getSqlSessionFactory().openSession().getMapper(IAdressDao.class);
	private  IWasteRecyclingFactoryDao wasteRecyclingFactoryDao=MyBatisConnection.getInstance().getSqlSessionFactory().openSession().getMapper(IWasteRecyclingFactoryDao.class);
	public WasteRecyclingFactory getById(long id)  {		 
		WasteRecyclingFactory wasteRecyclingFactory=wasteRecyclingFactoryDao.getById(id);
		return wasteRecyclingFactory;		 
	}
	public void insert(WasteRecyclingFactory wasteRecyclingFactory)  {
		wasteRecyclingFactoryDao.insert(wasteRecyclingFactory);
		adressDao.insert(wasteRecyclingFactory.getAdress());	
		
	}
	public void update(WasteRecyclingFactory wasteRecyclingFactory) {	
		wasteRecyclingFactoryDao.update(wasteRecyclingFactory);
		adressDao.update(wasteRecyclingFactory.getAdress());	
		
		
		
	}
	public void delete(WasteRecyclingFactory wasteRecyclingFactory)  {
		wasteRecyclingFactoryDao.delete(wasteRecyclingFactory);
		adressDao.delete(wasteRecyclingFactory.getAdress());	
		
	}
	

}
