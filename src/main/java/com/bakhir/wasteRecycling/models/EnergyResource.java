package com.bakhir.wasteRecycling.models;

public class EnergyResource extends Model{	
	private int weight;
	private IncinerationFactory incinerationFactory;
	private EnergyResourceType energyResourceType;
	private int incinerationFactoryId;
	private int energyResourceTypeId;
	
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
	public EnergyResourceType getEnergyResourceType() {
		return energyResourceType;
	}
	public void setEnergyResourceType(EnergyResourceType energyResourceType) {
		this.energyResourceType = energyResourceType;
	}
	public int getIncinerationFactoryId() {
		return incinerationFactoryId;
	}
	public void setIncinerationFactoryId(int incinerationFactoryId) {
		this.incinerationFactoryId = incinerationFactoryId;
	}
	public int getEnergyResourceTypeId() {
		return energyResourceTypeId;
	}
	public void setEnergyResourceTypeId(int energyResourceTypeId) {
		this.energyResourceTypeId = energyResourceTypeId;
	}
	@Override
	public String toString() {
		return "EnergyResource [weight=" + weight + ", incinerationFactory=" + incinerationFactory
				+ ", energyResourceType=" + energyResourceType + ", incinerationFactoryId=" + incinerationFactoryId
				+ ", energyResourceTypeId=" + energyResourceTypeId + ", " + super.toString() + "]";
	}
	
	

}
