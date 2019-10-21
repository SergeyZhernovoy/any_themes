package com.example.cars;

import javax.enterprise.inject.Produces;

public class CarFactoryProducer {
	@Produces
	public CarFactory exposeCarFactory() {
		CarFactory factory = new BMWCarFactory();
		return factory;
	}

	@Produces
	public CarStorage exposeCarStorage() {
		CarStorage storage = new CarStorageImpl();
		return storage;
	}

}
