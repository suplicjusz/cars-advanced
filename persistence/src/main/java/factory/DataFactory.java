package factory;


import loader.Loader;
import model.car.Car;
import model.car.CarData;
import saver.Saver;
import validator.Validator;

import java.util.Collection;
import java.util.List;

public interface DataFactory<T> {

    Loader<List<CarData>> createJsonLoader();
    Validator<List<CarData>> createValidator();
    Saver<T, Collection<Car>> createSaver();




}
