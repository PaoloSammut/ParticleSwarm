package com.swarm.world;


public class ObjectList {
	private String entity;
	private int quantity;
	private String colour;
	
	public ObjectList(String entity, int quantity, String colour) {
		this.entity = entity;
		this.quantity = quantity;
		this.colour = colour;
	}

	public String getEntity() {
		return entity;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getColour() {
		return colour;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}
	
	
}
