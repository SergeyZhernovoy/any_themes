package com.example.cars;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class CarManufacturer {
	@Inject
	CarFactory carFactory;

	@Inject
	CarStorage carStorage;

	public Car manufactureCar(Specification spec) {
		Car car = carFactory.createCar(spec);
		carStorage.store(car);
		return car;
	}
}
