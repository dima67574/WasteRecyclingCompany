package com.bakhir.wasteRecycling.models;

public abstract class Model {
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Id [id=" + id + "]";
	}
	
}
