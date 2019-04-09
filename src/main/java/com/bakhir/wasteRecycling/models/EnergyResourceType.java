package com.bakhir.wasteRecycling.models;

public class EnergyResourceType extends Model {
	
	private String name;
	private int generatedEnergy;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGeneratedEnergy() {
		return generatedEnergy;
	}
	public void setGeneratedEnergy(int generatedEnergy) {
		this.generatedEnergy = generatedEnergy;
	}
	@Override
	public String toString() {
		return "EnergyResourceType [name=" + name + ", generatedEnergy=" + generatedEnergy + ", "
				+ super.toString() + "]";
	}
	

}
