package com.bakhir.wasteRecycling.models;
public class Dump extends Model {
	
	private int capacity;	
	private UtilityCompany utilityCompany;
	private Adress adress;	
	private int adressId;
	private int utilityCompanyId;
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public UtilityCompany getUtilityCompany() {
		return utilityCompany;
	}
	public void setUtilityCompany(UtilityCompany utilityCompany) {
		this.utilityCompany = utilityCompany;
	}
	public Adress getAdress() {
		return adress;
	}
	public void setAdress(Adress adress) {
		this.adress = adress;
	}
	public int getAdressId() {
		return adressId;
	}
	public void setAdressId(int adressId) {
		this.adressId = adressId;
	}
	public int getUtilityCompanyId() {
		return utilityCompanyId;
	}
	public void setUtilityCompanyId(int utilityCompanyId) {
		this.utilityCompanyId = utilityCompanyId;
	}
	@Override
	public String toString() {
		return "Dump [capacity=" + capacity + ", utilityCompany=" + utilityCompany + ", adress=" + adress
				+ ", adressId=" + adressId + ", utilityCompanyId=" + utilityCompanyId + ", "
				+ super.toString() + "]";
	}
	

}
