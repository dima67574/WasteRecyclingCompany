package com.bakhir.wasteRecycling.services;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.bakhir.wasteRecycling.models.Adress;
import com.bakhir.wasteRecycling.models.UtilityCompany;

public class MyBatisRunner {
	private static final Logger log = LogManager.getLogger(MyBatisRunner.class);
	public static void main(String[] args) {
		
		AdressService adressService=new AdressService();
		log.info(adressService.getById(1));
		Adress adress= new Adress();
		adress.setCity("city");
		adress.setCountry("country");
		adress.setNumber("15");
		adress.setRegion("regihhhhhhon");
		adress.setStreet("street");
		adress.setZipCode(15);
		adress.setId(6);
		adressService.update(adress);
		adressService.insert(adress);
		//myBatisAdress.delete(adress);
		UtilityCompanyService utilityCompanyService=new UtilityCompanyService();
		log.info(utilityCompanyService.getById(2));
		Adress adress2= new Adress();
		adress2.setCity("city");
		adress2.setCountry("country");
		adress2.setNumber("15");
		adress2.setRegion("regihinsert");
		adress2.setStreet("street");
		adress2.setZipCode(1554355);
		adress2.setId(6);
		UtilityCompany utilityCompany=new UtilityCompany();
		utilityCompany.setName("name");
		utilityCompany.setNumberEmployees(15);
		utilityCompany.setId(8);
		utilityCompany.setAdress(adress2);
		//utilityCompanyService.update(utilityCompany);
		
		Adress adress3= new Adress();
		adress3.setCity("city");
		adress3.setCountry("country");
		adress3.setNumber("15");
		adress3.setRegion("regihinsert");
		adress3.setStreet("street");
		adress3.setZipCode(1554355);
		UtilityCompany utilityCompany2=new UtilityCompany();
		utilityCompany2.setName("name");
		utilityCompany2.setNumberEmployees(15);
		utilityCompany2.setAdress(adress3);
		//myBatisUtilityCompany.insert(utilityCompany2);
		
		
	}

}
