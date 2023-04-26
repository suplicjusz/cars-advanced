package car_service;

import extension.CarServiceParameterResolver;
import lombok.RequiredArgsConstructor;
import model.enums.StatsType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import stats_service.StatsAvailable;

@RequiredArgsConstructor
@ExtendWith(CarServiceParameterResolver.class)
public class GetStatsForGivenTypeTest {

    private final CarService extensionCarService;

    @ParameterizedTest
    @DisplayName("when is called the getStatsForGivenType")
    @EnumSource(value = StatsType.class)
    void shouldReturnStatsAvailable(StatsType type) {
        Assertions
                .assertThat(extensionCarService.getStatsForGivenType(type))
                .isInstanceOf(StatsAvailable.class);
    }

}
