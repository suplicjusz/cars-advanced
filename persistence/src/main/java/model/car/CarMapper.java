package model.car;

import model.engine.Engine;

import java.util.function.Function;
import java.util.function.ToDoubleFunction;

public interface CarMapper {
    ToDoubleFunction<Car> carToDoubleMileage = car -> car.carMileage;
    Function<Car, Engine> carToEngine = car -> car.carEngine;
}
