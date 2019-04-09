package com.bakhir.wasteRecycling.models;


public class WasteRecyclingFactory extends Model  {
	
	private String name;
	private Adress adress;
	private int adressId;
	private int numberEmployees;
	
	
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
	public int getNumberEmployees() {
		return numberEmployees;
	}
	public void setNumberEmployees(int numberEmployees) {
		this.numberEmployees = numberEmployees;
	}
	public int getAdressId() {
		return adressId;
	}
	public void setAdressId(int adressId) {
		this.adressId = adressId;
	}
	@Override
	public String toString() {
		return "WasteRecyclingFactory [name=" + name + ", adress=" + adress + ", adressId=" + adressId
				+ ", numberEmployees=" + numberEmployees + ", " + super.toString() + "]";
	}
	
	
	
	
	

}
