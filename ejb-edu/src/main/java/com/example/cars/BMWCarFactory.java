package com.example.cars;

public class BMWCarFactory implements CarFactory {
	@Override
	public Car createCar(Specification spec) {
		return new Car();
	}
}
