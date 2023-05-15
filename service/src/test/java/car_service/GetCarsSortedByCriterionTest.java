package car_service;

import extension.CarServiceParameterResolver;
import lombok.RequiredArgsConstructor;
import model.car.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import support.CarServiceContent;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import static model.car.CarComparators.*;

@RequiredArgsConstructor
@ExtendWith(CarServiceParameterResolver.class)
public class GetCarsSortedByCriterionTest implements CarServiceContent<Map<Comparator<Car>, List<Car>>> {

    private final CarService extensionCarService;

    @ParameterizedTest
    @DisplayName("when is called the getCarsSortedByCriterion method")
    @MethodSource("comparatorArgumentSource")
    void shouldReturnListOfSortedCars(Comparator<Car> comparator) {
        Assertions
                .assertEquals(
                        getExpected().get(comparator),
                        extensionCarService.getCarsSortedByCriterion(comparator)
                );
    }

    static Stream<Comparator<Car>> comparatorArgumentSource() {
        return Stream.of(byComponentsQuantityComparator, byEnginePowerComparator, byWheelSizeComparator);
    }

    @Override
    public Map<Comparator<Car>, List<Car>> getExpected() {
        return Map.of(
                byComponentsQuantityComparator,
                List.of(
                        findContentCarById(0L),
                        findContentCarById(3L),
                        findContentCarById(1L),
                        findContentCarById(2L)
                ),
                byEnginePowerComparator,
                List.of(
                        findContentCarById(0L),
                        findContentCarById(1L),
                        findContentCarById(2L),
                        findContentCarById(3L)
                ),
                byWheelSizeComparator,
                List.of(
                        findContentCarById(0L),
                        findContentCarById(1L),
                        findContentCarById(3L),
                        findContentCarById(2L)
                )
        );
    }
}
