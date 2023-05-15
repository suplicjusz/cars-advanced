package saver.cars.impl;

import model.car.Car;
import saver.Saver;

import java.io.File;
import java.util.Collection;
import java.util.Optional;

public class ToXmlCarSaver implements Saver<Collection<Car>, File> {
    @Override
    public Optional<File> save(Collection<Car> cars) {
        return Optional.empty();
    }
}
