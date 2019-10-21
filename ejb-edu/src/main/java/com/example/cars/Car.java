package com.example.cars;

public class Car {
	public void setId(String id) {
		this.id = id;
	}

	private String id;

	public Car() {
	}

	public Car(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
}
