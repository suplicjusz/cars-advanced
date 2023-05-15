package factory;

import com.google.gson.Gson;
import loader.Loader;
import loader.xml.impl.CarsXmlLoaderImpl;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import model.car.CarData;
import validator.CarDataValidator;
import validator.impl.CarDataValidatorImpl;

import java.util.Set;

@RequiredArgsConstructor
@EqualsAndHashCode
public class FromXmlWithValidationCarDataFactory implements CarDataFactory {
    private final Gson gson;
    @Override
    public Loader<Set<CarData>> createLoader() {
        return new CarsXmlLoaderImpl();
    }

    @Override
    public CarDataValidator createValidator() {
        return new CarDataValidatorImpl();
    }
}
