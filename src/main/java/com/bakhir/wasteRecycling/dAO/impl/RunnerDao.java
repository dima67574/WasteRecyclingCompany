package com.bakhir.wasteRecycling.dAO.impl;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.bakhir.wasteRecycling.models.Adress;
import com.bakhir.wasteRecycling.models.Dump;
import com.bakhir.wasteRecycling.models.UtilityCompany;
import com.bakhir.wasteRecycling.models.WasteType;
import com.bakhir.wasteRecycling.services.DumpService;
import com.bakhir.wasteRecycling.services.EnergyResourceService;
import com.bakhir.wasteRecycling.services.IncinerationFactoryService;
import com.bakhir.wasteRecycling.services.ProductService;
import com.bakhir.wasteRecycling.services.UtilityCompanyService;
import com.bakhir.wasteRecycling.services.WasteRecyclingFactoryService;

public class RunnerDao {
	private static final Logger log = LogManager.getLogger(RunnerDao.class);
	public static void main(String[] args) throws InterruptedException, SQLException, IOException {
		
		WasteTypeDao ws= new WasteTypeDao ();
		WasteType w=new WasteType();
		w.setName("dsd");
		ws.insert(w);
		w.setName("dasdas");
		w.setId(12);
		ws.update(w);
		log.info(ws.getById(3));
		ws.delete(w);
		AdressDao a=new AdressDao();
		log.info(a.getById(5));
		ProductTypeDao pr=new ProductTypeDao();
		log.info(pr.getById(5));
		EnergyResourceTypeDao en=new EnergyResourceTypeDao();
		log.info(en.getById(5));
		UtilityCompanyDao util = new UtilityCompanyDao();
		log.info(util.getById(5));
		WasteRecyclingFactoryDao wrf=new WasteRecyclingFactoryDao();
		log.info(wrf.getById(5));
		IncinerationFactoryDao inc=new IncinerationFactoryDao();
		log.info(inc.getById(5));
		CarDao car=new CarDao();
		log.info(car.getById(5));
		DumpDao dumpDao= new DumpDao();
		log.info(dumpDao.getById(5));
	}

}
