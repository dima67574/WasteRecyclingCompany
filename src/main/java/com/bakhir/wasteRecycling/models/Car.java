package com.bakhir.wasteRecycling.models;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Car extends Model {
	
	private String manufacturer;
	private String model;
	private Date dateOfManufacture;
	private int capacity;
	private IncinerationFactory incinerationFactory;	
	private WasteRecyclingFactory wasteRecyclingFactory;
	private UtilityCompany utilityCompany;
	private int incinerationFactoryId;
	private int wasteRecyclingFactoryId;
	private int utilityCompanyId;
	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public IncinerationFactory getIncinerationFactory() {
		return incinerationFactory;
	}
	public void setIncinerationFactory(IncinerationFactory incinerationFactory) {
		this.incinerationFactory = incinerationFactory;
	}
	public WasteRecyclingFactory getWasteRecyclingFactory() {
		return wasteRecyclingFactory;
	}
	public void setWasteRecyclingFactory(WasteRecyclingFactory wasteRecyclingFactory) {
		this.wasteRecyclingFactory = wasteRecyclingFactory;
	}
	public UtilityCompany getUtilityCompany() {
		return utilityCompany;
	}
	public void setUtilityCompany(UtilityCompany utilityCompany) {
		this.utilityCompany = utilityCompany;
	}
	public String  getDateOfManufacture() {		
		return format.format( dateOfManufacture  );
	}
	public void setDateOfManufacture(String dateOfManufacture) {		
		try {
			this.dateOfManufacture = format.parse( dateOfManufacture );
		} catch (ParseException e) {			
			e.printStackTrace();
		}
	}
	public int getIncinerationFactoryId() {
		return incinerationFactoryId;
	}
	public void setIncinerationFactoryId(int incinerationFactoryId) {
		this.incinerationFactoryId = incinerationFactoryId;
	}
	public int getWasteRecyclingFactoryId() {
		return wasteRecyclingFactoryId;
	}
	public void setWasteRecyclingFactoryId(int wasteRecyclingFactoryId) {
		this.wasteRecyclingFactoryId = wasteRecyclingFactoryId;
	}
	public int getUtilityCompanyId() {
		return utilityCompanyId;
	}
	public void setUtilityCompanyId(int utilityCompanyId) {
		this.utilityCompanyId = utilityCompanyId;
	}
	@Override
	public String toString() {
		return "Car [manufacturer=" + manufacturer + ", model=" + model + ", dateOfManufacture=" + dateOfManufacture
				+ ", capacity=" + capacity + ", incinerationFactory=" + incinerationFactory + ", wasteRecyclingFactory="
				+ wasteRecyclingFactory + ", utilityCompany=" + utilityCompany + ", incinerationFactoryId="
				+ incinerationFactoryId + ", wasteRecyclingFactoryId=" + wasteRecyclingFactoryId + ", utilityCompanyId="
				+ utilityCompanyId + ", " + super.toString() + "]";
	}
		
	

}
