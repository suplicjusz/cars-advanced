package model.car;

import java.util.Comparator;

public interface CarComparator {

    Comparator<Car> byIdComparator = Comparator.comparing(car -> car.id);
    Comparator<Car> byMileageComparator = Comparator.comparing(car -> car.carMileage);
    Comparator<Car> byComponentsQuantityComparator = Comparator.comparing(Car::countComponents);
    Comparator<Car> byEnginePowerComparator = Comparator.comparing(car -> car.carEngine.getEnginePower());
    Comparator<Car> byWheelSizeComparator = Comparator.comparing(car -> car.carWheel.getWheelSize());
    Comparator<Car> byCarModelInAlphabeticalOrder = Comparator.comparing(car -> car.carModel);
}
