package com.bakhir.wasteRecycling.services;

import com.bakhir.wasteRecycling.dAO.IAdressDao;
import com.bakhir.wasteRecycling.dAO.IIncinerationFactoryDao;
import com.bakhir.wasteRecycling.models.IncinerationFactory;
import com.bakhir.wasteRecycling.myBatis.MyBatisConnection;

public class IncinerationFactoryService implements IIncinerationFactoryDao{
	private IAdressDao adressDao= MyBatisConnection.getInstance().getSqlSessionFactory().openSession().getMapper(IAdressDao.class);
	private IIncinerationFactoryDao incinerationFactoryDao = MyBatisConnection.getInstance().getSqlSessionFactory().openSession().getMapper(IIncinerationFactoryDao.class);
	public IncinerationFactory getById(long id)  {		 
		IncinerationFactory incinerationFactory=incinerationFactoryDao.getById(id);
		return incinerationFactory;		 
	}
	public void insert(IncinerationFactory incinerationFactory)  {
		incinerationFactoryDao.insert(incinerationFactory);
		adressDao.insert(incinerationFactory.getAdress());	
		
	}
	public void update(IncinerationFactory incinerationFactory) {	
		incinerationFactoryDao.update(incinerationFactory);
		adressDao.update(incinerationFactory.getAdress());	
		
		
		
	}
	public void delete(IncinerationFactory incinerationFactory)  {
		incinerationFactoryDao.delete(incinerationFactory);
		adressDao.delete(incinerationFactory.getAdress());	
		
	}
	

}
