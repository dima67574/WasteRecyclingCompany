package com.bakhir.wasteRecycling.services;

import com.bakhir.wasteRecycling.dAO.IAdressDao;
import com.bakhir.wasteRecycling.dAO.IUtilityCompanyDao;
import com.bakhir.wasteRecycling.models.UtilityCompany;
import com.bakhir.wasteRecycling.myBatis.MyBatisConnection;

public class UtilityCompanyService implements IUtilityCompanyDao {
	private IAdressDao adressDao= MyBatisConnection.getInstance().getSqlSessionFactory().openSession().getMapper(IAdressDao.class);
	private IUtilityCompanyDao utilityCompanyDao= MyBatisConnection.getInstance().getSqlSessionFactory().openSession().getMapper(IUtilityCompanyDao.class);
	@Override
	public void insert(UtilityCompany utilityCompany)  {
		utilityCompanyDao.insert(utilityCompany);
		adressDao.insert(utilityCompany.getAdress());
		
	}

	@Override
	public UtilityCompany getById(long id) {
		UtilityCompany utilityCompany = utilityCompanyDao.getById(id);		
		return utilityCompany;
	}

	@Override
	public void update(UtilityCompany utilityCompany) {
		
		adressDao.update(utilityCompany.getAdress());	
		utilityCompanyDao.update(utilityCompany);
		
	}


	@Override
	public void delete(UtilityCompany utilityCompany) {
		utilityCompanyDao.delete(utilityCompany);
		adressDao.delete(utilityCompany.getAdress());	
		
	}
	
	

}
