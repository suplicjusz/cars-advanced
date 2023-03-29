package model.car;

import java.util.Comparator;

public interface CarComparator {
    Comparator<Car> compareByComponentsQuantity = Comparator.comparing(Car::countComponents);
    Comparator<Car> compareByEnginePower = Comparator.comparing(car -> car.carEngine.getPower());
}
