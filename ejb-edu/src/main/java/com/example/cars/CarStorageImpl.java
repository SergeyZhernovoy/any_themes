package com.example.cars;

import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class CarStorageImpl implements CarStorage {
	private Map<String, Car> cars = new HashMap<>();

	@Lock
	@Override
	public void store(Car car) {
		cars.put(car.getId(), car);
	}

	@Lock(LockType.READ)
	@Override
	public Car retrieve(String id) {
		return cars.get(id);
	}
}
