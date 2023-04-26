package car_service;

import extension.CarServiceParameterResolver;
import lombok.RequiredArgsConstructor;
import model.car.Car;
import model.enums.EngineType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import support.CarServiceContent;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@ExtendWith(CarServiceParameterResolver.class)
public class GetCarsSortedByModelFilteredByEngineTypeTest implements CarServiceContent<EnumMap<EngineType, List<Car>>> {
    private final CarService extensionCarService;

    @ParameterizedTest
    @DisplayName("")
    @EnumSource(value = EngineType.class)
    void shouldReturnListOfCarsWithChosenEngineTypeInAlphabeticalOrder(EngineType engineType) {
        Assertions
                .assertEquals(
                        getExpected().get(engineType),
                        extensionCarService.getCarsSortedByModelFilteredByEngineType(engineType)
                );
    }

    @Override
    public EnumMap<EngineType, List<Car>> getExpected() {
        return new EnumMap<>(Map.of(
                EngineType.DIESEL,
                List.of(
                        findContentCarById(0L),
                        findContentCarById(1L),
                        findContentCarById(2L)
                ),
                EngineType.GASOLINE,
                List.of(
                        findContentCarById(3L)
                ),
                EngineType.LPG,
                List.of()
        ));
    }
}
