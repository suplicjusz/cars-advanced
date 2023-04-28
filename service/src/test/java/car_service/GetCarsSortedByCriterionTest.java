package car_service;

import extension.CarServiceParameterResolver;
import lombok.RequiredArgsConstructor;
import model.car.Car;
import model.enums.SortCriterion;
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
public class GetCarsSortedByCriterionTest implements CarServiceContent<EnumMap<SortCriterion, List<Car>>> {
    private final CarService extensionCarService;

    @ParameterizedTest
    @DisplayName("when is called the getCarsSortedByCriterion method")
    @EnumSource(value = SortCriterion.class)
    void shouldReturnListOfSortedCars(SortCriterion sortCriterion) {
        Assertions
                .assertEquals(
                        getExpected().get(sortCriterion),
                        extensionCarService.getCarsSortedByCriterion(sortCriterion, true)
                );
    }

    @Override
    public EnumMap<SortCriterion, List<Car>> getExpected() {
        return new EnumMap<>(Map.of(
                SortCriterion.COMPONENTS_QUANTITY,
                List.of(
                        findContentCarById(0L),
                        findContentCarById(1L),
                        findContentCarById(3L),
                        findContentCarById(2L)
                ),
                SortCriterion.ENGINE_POWER,
                List.of(
                        findContentCarById(0L),
                        findContentCarById(1L),
                        findContentCarById(2L),
                        findContentCarById(3L)
                ),
                SortCriterion.WHEEL_SIZE,
                List.of(
                        findContentCarById(0L),
                        findContentCarById(1L),
                        findContentCarById(3L),
                        findContentCarById(2L)
                )
        ));
    }
}
