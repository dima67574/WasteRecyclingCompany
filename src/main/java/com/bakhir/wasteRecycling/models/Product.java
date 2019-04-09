package com.bakhir.wasteRecycling.models;

public class Product extends Model {
	
	private int cost;
	private ProductType productType;
	private WasteRecyclingFactory wasteRecyclingFactory;
	private int weight;
	private int productTypeId;
	private int wasteRecyclingFactoryId;
	
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public ProductType getProductType() {
		return productType;
	}
	public void setProductType(ProductType productType) {
		this.productType = productType;
	}
	public WasteRecyclingFactory getWasteRecyclingFactory() {
		return wasteRecyclingFactory;
	}
	public void setWasteRecyclingFactory(WasteRecyclingFactory wasteRecyclingFactory) {
		this.wasteRecyclingFactory = wasteRecyclingFactory;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getProductTypeId() {
		return productTypeId;
	}
	public void setProductTypeId(int productTypeId) {
		this.productTypeId = productTypeId;
	}
	public int getWasteRecyclingFactoryId() {
		return wasteRecyclingFactoryId;
	}
	public void setWasteRecyclingFactoryId(int wasteRecyclingFactoryId) {
		this.wasteRecyclingFactoryId = wasteRecyclingFactoryId;
	}
	@Override
	public String toString() {
		return "Product [cost=" + cost + ", productType=" + productType + ", wasteRecyclingFactory="
				+ wasteRecyclingFactory + ", weight=" + weight + ", productTypeId=" + productTypeId
				+ ", wasteRecyclingFactoryId=" + wasteRecyclingFactoryId + ", " + super.toString() + "]";
	}
	
	

}
