package com.bakhir.wasteRecycling.services;

import com.bakhir.wasteRecycling.dAO.IWasteTypeDao;
import com.bakhir.wasteRecycling.models.WasteType;
import com.bakhir.wasteRecycling.myBatis.MyBatisConnection;

public class WasteTypeService implements IWasteTypeDao {
	private IWasteTypeDao wasteTypeDao= MyBatisConnection.getInstance().getSqlSessionFactory().openSession().getMapper(IWasteTypeDao.class);
	@Override
	public void insert(WasteType adress)  {		
			wasteTypeDao.insert(adress);	
		
	}

	@Override
	public WasteType getById(long id) {
		WasteType wasteType = wasteTypeDao.getById(id);		
		return wasteType;
	}

	@Override
	public void update(WasteType wasteType) {
		wasteTypeDao.update(wasteType);
		
	}


	@Override
	public void delete(WasteType wasteType) {
		wasteTypeDao.delete(wasteType);
		
	}

}