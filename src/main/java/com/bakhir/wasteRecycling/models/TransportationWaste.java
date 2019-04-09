package com.bakhir.wasteRecycling.models;

import java.util.Date;

public class TransportationWaste extends Model {
	
	private int weight;
	private Date dateTransportation;
	private Waste waste;
	private Car car;
	
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public Date getDateTransportation() {
		return dateTransportation;
	}
	public void setDateTransportation(Date dateTransportation) {
		this.dateTransportation = dateTransportation;
	}
	public Waste getWaste() {
		return waste;
	}
	public void setWaste(Waste waste) {
		this.waste = waste;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	
	

}
