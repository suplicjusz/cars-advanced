package model.car;

import model.engine.Engine;
import model.enums.TyreType;

import java.math.BigDecimal;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public interface CarMappers {

    Function<Car, Long> carToId = car -> car.id;
    Function<Car, String> carToCarModel = car -> car.carModel;
    Function<Car, BigDecimal> carToPrice = car -> car.carPrice;
    ToIntFunction<Car> carToIntMileage = car -> car.carMileage;
    Function<Car, Engine> carToEngine = car -> car.carEngine;
    //Function<Car, CarBody> carToCarBody = car -> car.carBody;
    ///Function<Car, Wheel> carToWheel = car -> car.carWheel;
    //Function<Car, List<String>> carToListOfComponents = car -> carToCarBody.apply(car).getComponents();

    Function<Car, TyreType> carToTyreType = car -> car.carWheel.getTyreType();
}
