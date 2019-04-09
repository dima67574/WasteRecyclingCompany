package com.bakhir.wasteRecycling.services;
import com.bakhir.wasteRecycling.dAO.IAdressDao;
import com.bakhir.wasteRecycling.models.Adress;
import com.bakhir.wasteRecycling.myBatis.MyBatisConnection;

public class AdressService implements IAdressDao {
	private IAdressDao adressDao= MyBatisConnection.getInstance().getSqlSessionFactory().openSession().getMapper(IAdressDao.class);
	@Override
	public void insert(Adress adress)  {		
			adressDao.insert(adress);	
		
	}

	@Override
	public Adress getById(long id) {
		Adress adress = adressDao.getById(id);		
		return adress;
	}

	@Override
	public void update(Adress adress) {
		adressDao.update(adress);
		
	}


	@Override
	public void delete(Adress adress) {
		adressDao.delete(adress);
		
	}
	
	

}
