package com.bakhir.wasteRecycling.services;

import com.bakhir.wasteRecycling.dAO.IAdressDao;
import com.bakhir.wasteRecycling.dAO.IDumpDao;
import com.bakhir.wasteRecycling.dAO.IUtilityCompanyDao;
import com.bakhir.wasteRecycling.models.Dump;
import com.bakhir.wasteRecycling.myBatis.MyBatisConnection;

public class DumpService implements IDumpDao {
	private IDumpDao dumpDao=MyBatisConnection.getInstance().getSqlSessionFactory().openSession().getMapper(IDumpDao.class);
	private IAdressDao adressDao= MyBatisConnection.getInstance().getSqlSessionFactory().openSession().getMapper(IAdressDao.class);
	private IUtilityCompanyDao utilityCompanyDao=MyBatisConnection.getInstance().getSqlSessionFactory().openSession().getMapper(IUtilityCompanyDao.class);
	public Dump getById(long id)  {		 
		 Dump dump=dumpDao.getById(id);		
		return dump;		 
	}
	public void insert(Dump dump)  {
		dumpDao.insert(dump);
		adressDao.insert(dump.getAdress());		
		utilityCompanyDao.insert(dump.getUtilityCompany());		
		
	}
	public void update(Dump dump) {	
		dumpDao.update(dump);
		adressDao.update(dump.getAdress());		
		utilityCompanyDao.update(dump.getUtilityCompany());		
		
		
		
	}
	public void delete(Dump dump)  {
		dumpDao.delete(dump);
		adressDao.delete(dump.getAdress());		
		utilityCompanyDao.delete(dump.getUtilityCompany());
		
	}
}
