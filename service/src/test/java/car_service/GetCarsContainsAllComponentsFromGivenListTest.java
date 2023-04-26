package car_service;

import extension.CarServiceParameterResolver;
import lombok.RequiredArgsConstructor;
import model.car.Car;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import support.CarServiceContent;
import java.util.List;


@RequiredArgsConstructor
@ExtendWith(CarServiceParameterResolver.class)
public class GetCarsContainsAllComponentsFromGivenListTest implements CarServiceContent<List<Car>> {

    private final CarService extensionCarService;
    private final List<String> givenComponents = List.of("ABS", "AIR_CONDITIONING");

    @Test
    @DisplayName("when given is a list of components and returned is a correct list of cars contains that")
    void shouldReturnedListOfCarsContainsGivenComponents() {
        Assertions
                .assertEquals(
                        getExpected(),
                        extensionCarService.getCarsContainsAllComponentsFromGivenList(givenComponents)
                );
    }

    @Override
    public List<Car> getExpected() {
        return List.of(
                findContentCarById(1L), findContentCarById(2L)
        );
    }
}
