package com.bakhir.wasteRecycling.models;

public class ProductType extends Model {
	
	private String name;
	private String usage;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsage() {
		return usage;
	}
	public void setUsage(String usage) {
		this.usage = usage;
	}
	@Override
	public String toString() {
		return "ProductType [name=" + name + ", usage=" + usage + ", " + super.toString() + "]";
	}
	

}
