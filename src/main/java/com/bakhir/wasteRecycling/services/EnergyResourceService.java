
package com.bakhir.wasteRecycling.services;
import com.bakhir.wasteRecycling.dAO.IEnergyResourceDao;
import com.bakhir.wasteRecycling.dAO.IEnergyResourceTypeDao;
import com.bakhir.wasteRecycling.dAO.IIncinerationFactoryDao;
import com.bakhir.wasteRecycling.dAO.impl.EnergyResourceDao;
import com.bakhir.wasteRecycling.dAO.impl.EnergyResourceTypeDao;
import com.bakhir.wasteRecycling.dAO.impl.IncinerationFactoryDao;
import com.bakhir.wasteRecycling.models.EnergyResource;
public class EnergyResourceService implements IEnergyResourceDao  {
	private IEnergyResourceDao energyResourceDao= new EnergyResourceDao();
	private IEnergyResourceTypeDao energyResourceTypeDao= new EnergyResourceTypeDao();
	private IIncinerationFactoryDao incinerationFactoryDao= new IncinerationFactoryDao();
	
	public EnergyResource getById(long id)  {		 
		EnergyResource energyResource=energyResourceDao.getById(id);
		energyResource.setEnergyResourceType(energyResourceTypeDao.getById(energyResource.getEnergyResourceTypeId()));
		energyResource.setIncinerationFactory(incinerationFactoryDao.getById(energyResource.getIncinerationFactoryId()));
		return energyResource;		 
	}
	public void insert(EnergyResource energyResource)  {
		energyResourceDao.insert(energyResource);
		energyResourceTypeDao.insert(energyResource.getEnergyResourceType());
		incinerationFactoryDao.insert(energyResource.getIncinerationFactory());
		
	}
	public void update(EnergyResource energyResource) {	
		energyResourceDao.update(energyResource);
		energyResourceTypeDao.update(energyResource.getEnergyResourceType());
		incinerationFactoryDao.update(energyResource.getIncinerationFactory());
		
	}
	public void delete(EnergyResource energyResource)  {
		energyResourceDao.delete(energyResource);
		energyResourceTypeDao.delete(energyResource.getEnergyResourceType());
		incinerationFactoryDao.delete(energyResource.getIncinerationFactory());	
		
	}
}
