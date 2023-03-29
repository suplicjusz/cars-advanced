package car_service;

import extension.CarServiceParameterResolver;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@RequiredArgsConstructor
@ExtendWith(CarServiceParameterResolver.class)
public class GetCarListsSortedByTyreTypeTest {

    private final CarService carService;

    @Test
    @DisplayName("when is returned map: key is TyreType, values are lists od Cars contains that")
    void shouldSortedCarsByTyreType() {
        Assertions
                .assertThat(carService.getListsOfCarsGroupedByTyreType())
                .containsAllEntriesOf(null); //todo

    }



}
