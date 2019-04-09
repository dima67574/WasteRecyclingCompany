package com.bakhir.wasteRecycling.models;

public class Adress extends Model{	
	private String region;
	private String country;
	private String city;
	private String street;
	private String number;
	private int zipCode;
	
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	@Override
	public String toString() {
		return "Adress [region=" + region + ", country=" + country + ", city=" + city + ", street=" + street
				+ ", number=" + number + ", zipCode=" + zipCode + ", " + super.toString() + "]";
	}
	
	
	

}
