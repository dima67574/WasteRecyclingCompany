package com.bakhir.wasteRecycling.services;

import com.bakhir.wasteRecycling.dAO.IEnergyResourceTypeDao;
import com.bakhir.wasteRecycling.models.EnergyResourceType;
import com.bakhir.wasteRecycling.myBatis.MyBatisConnection;

public class EnergyResourceTypeService implements  IEnergyResourceTypeDao {
	private IEnergyResourceTypeDao energyResourceTypeDao= MyBatisConnection.getInstance().getSqlSessionFactory().openSession().getMapper(IEnergyResourceTypeDao.class);
	@Override
	public void insert(EnergyResourceType adress)  {		
			energyResourceTypeDao.insert(adress);	
		
	}

	@Override
	public EnergyResourceType getById(long id) {
		EnergyResourceType energyResourceType = energyResourceTypeDao.getById(id);		
		return energyResourceType;
	}

	@Override
	public void update(EnergyResourceType energyResourceType) {
		energyResourceTypeDao.update(energyResourceType);
		
	}


	@Override
	public void delete(EnergyResourceType energyResourceType) {
		energyResourceTypeDao.delete(energyResourceType);
		
	}

}
