package factory;


import loader.Loader;
import model.car.CarData;
import validator.CarDataValidator;
import java.util.Set;

public interface CarDataFactory {

    Loader<Set<CarData>> createLoader();
    CarDataValidator createValidator();




}
