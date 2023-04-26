package model.car;

import model.carbody.CarBody;
import model.engine.Engine;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;

public interface CarMapper {

    Function<Car, BigDecimal> carToPrice = car -> car.carPrice;
    ToDoubleFunction<Car> carToDoubleMileage = car -> car.carMileage;
    Function<Car, Engine> carToEngine = car -> car.carEngine;
    Function<Car, Long> carToId = car -> car.id;
    Function<Car, CarBody> carToCarBody = car -> car.carBody;
    Function<Car, List<String>> carToListOfComponents = car -> carToCarBody.apply(car).getComponents();
}
