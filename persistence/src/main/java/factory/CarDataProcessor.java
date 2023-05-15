package factory;

import com.google.gson.Gson;
import converter.ToCarsConverter;
import loader.Loader;
import lombok.EqualsAndHashCode;
import model.car.Car;
import model.car.CarData;
import validator.CarDataValidator;

import java.util.Set;

@EqualsAndHashCode
public class CarDataProcessor {

    private final Loader<Set<CarData>> loader;
    private final CarDataValidator validator;

    public enum ProcessorType {
        FROM_JSON_WITH_VALIDATION,
        FROM_XML_WITH_VALIDATION
    }


    private CarDataProcessor(CarDataFactory carDataFactory) {
        this.loader = carDataFactory.createLoader();
        this.validator = carDataFactory.createValidator();
    }

    public Set<Car> process(String path) {
        var data = loader.load(path);
        var converter = ToCarsConverter.of(validator);
        return converter.convert(data);
    }

    public static CarDataProcessor createDataProcessor(ProcessorType processorType, Gson gson) {
        return switch (processorType) {
            case FROM_XML_WITH_VALIDATION -> new CarDataProcessor(new FromXmlWithValidationCarDataFactory(gson));
            case FROM_JSON_WITH_VALIDATION -> new CarDataProcessor(new FromJsonWithValidationCarDataFactory(gson));
        };
    }

}

