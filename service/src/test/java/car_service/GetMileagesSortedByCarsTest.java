package car_service;

import extension.CarServiceParameterResolver;
import lombok.RequiredArgsConstructor;
import model.car.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import support.CarServiceContent;

import java.util.Map;

@RequiredArgsConstructor
@ExtendWith(CarServiceParameterResolver.class)
public class GetMileagesSortedByCarsTest implements CarServiceContent<Map<Car, Integer>> {

    private final CarService extensionCarService;

    @Test
    @DisplayName("when os called the getMileageSortedByCars method")
    void shouldReturnMileagesSortedByCars() {
        Assertions
                .assertEquals(
                        getExpected(),
                        extensionCarService.getMileagesSortedByCars()
                );
    }

    @Override
    public Map<Car, Integer> getExpected() {
        return Map.of(
                findContentCarById(3L), 120000,
                findContentCarById(2L), 10000,
                findContentCarById(1L), 50000,
                findContentCarById(0L), 40000
        );
    }
}
