package car_service;

import extension.CarServiceParameterResolver;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.extension.ExtendWith;

@RequiredArgsConstructor
@ExtendWith(CarServiceParameterResolver.class)
public class GetCarsContainsAllComponentsFromGivenListTest {

    private final CarService carService;

}
