package com.bakhir.wasteRecycling.models;

public class IncinerationFactory  extends Model{
	
	private String name;
	private Adress adress;
	private int numberEmployees;
	private int adressId;
	
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
		return "IncinerationFactory [name=" + name + ", adress=" + adress + ", numberEmployees=" + numberEmployees
				+ ", adressId=" + adressId + ", " + super.toString() + "]";
	}
	
	

}
