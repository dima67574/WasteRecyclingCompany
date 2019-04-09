package com.bakhir.wasteRecycling.models;

public class UtilityCompany extends Model {
	
	private int numberEmployees;
	private String name;
	private Adress adress;	
	private int adressId;
	
	public int getNumberEmployees() {
		return numberEmployees;
	}
	public void setNumberEmployees(int numberEmployees) {
		this.numberEmployees = numberEmployees;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	@Override
	public String toString() {
		return "UtilityCompany [numberEmployees=" + numberEmployees + ", name=" + name + ", adress=" + adress
				+ ", adressId=" + adressId + ", " + super.toString() + "]";
	}
	

}
