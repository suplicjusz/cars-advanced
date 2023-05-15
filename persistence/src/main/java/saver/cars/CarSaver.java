package saver.cars;

import model.car.Car;
import saver.Saver;
import java.util.Set;

public interface CarSaver<U> extends Saver<Set<Car>, U> {
}
