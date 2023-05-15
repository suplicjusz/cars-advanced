package car_service;

import extension.CarServiceParameterResolver;
import lombok.RequiredArgsConstructor;
import model.car.Car;
import model.enums.TyreType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import support.CarServiceContent;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@RequiredArgsConstructor
@ExtendWith(CarServiceParameterResolver.class)
public class GetListsOfCarsGroupedByTyreTypeTest implements CarServiceContent<Map<TyreType, List<Car>>> {

    private final CarService extensionCarService;
    @Test
    @DisplayName("when is returned map: key is TyreType, values are lists of Cars contains that")
    void shouldSortedCarsByTyreType() {
        Assertions
                .assertThat(extensionCarService.getListsOfCarsGroupedByTyreType())
                .containsAllEntriesOf(getExpected());

    }

    @Override
    public Map<TyreType, List<Car>> getExpected() {
        return new TreeMap<>(Map.of(
                TyreType.SUMMER,
                List.of(
                        findContentCarById(0L),
                        findContentCarById(1L)
                ),
                TyreType.WINTER,
                List.of(
                        findContentCarById(2L),
                        findContentCarById(3L)
                )
        ));
    }
}
