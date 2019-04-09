package com.bakhir.wasteRecycling.models;

public class Waste extends Model {	
	
	private int cost;
	private int weight;
	private IncinerationFactory incinerationFactory;
	private WasteRecyclingFactory wasteRecyclingFactory;
	private UtilityCompany utilityCompany;
	private WasteType wasteType;
	
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
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
	public WasteType getWasteType() {
		return wasteType;
	}
	public void setWasteType(WasteType wasteType) {
		this.wasteType = wasteType;
	}
	

}
