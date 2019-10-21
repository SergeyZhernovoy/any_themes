package com.example.cars;

public interface CarStorage {
	void store(Car car);

	Car retrieve(String id);
}
