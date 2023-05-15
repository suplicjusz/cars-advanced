package converter;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import model.car.Car;
import model.car.CarData;
import validator.CarDataValidator;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode
@ToString
public class ToCarsConverter {

    private final CarDataValidator validator;

    private ToCarsConverter(CarDataValidator validator) {
        this.validator = validator;
    }

    public static ToCarsConverter of(CarDataValidator validator) {
        return new ToCarsConverter(validator);
    }

    public Set<Car> convert(Set<CarData> cars) {
        var temp = cars
                .stream()
                .map(validator::validate)
                .map(CarData::toCar)
                .toList();
        return new HashSet<>(temp);
    }

}
