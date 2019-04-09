package com.bakhir.wasteRecycling.models;

public class WasteType extends Model  {
	
	private String name;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "WasteType [name=" + name + "," + super.toString() + "]";
	}

}
