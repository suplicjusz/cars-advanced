package model.car;

import model.carbody.CarBody;
import model.engine.Engine;
import model.wheel.Wheel;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public interface CarMapper {

    Function<Car, Long> carToId = car -> car.id;
    Function<Car, String> carToCarModel = car -> car.carModel;
    Function<Car, BigDecimal> carToPrice = car -> car.carPrice;
    ToIntFunction<Car> carToIntMileage = car -> car.carMileage;
    Function<Car, Engine> carToEngine = car -> car.carEngine;
    Function<Car, CarBody> carToCarBody = car -> car.carBody;
    Function<Car, Wheel> carToWheel = car -> car.carWheel;
    Function<Car, List<String>> carToListOfComponents = car -> carToCarBody.apply(car).getComponents();
}
