package stats_service;

import car_service.CarService;
import extension.CarServiceParameterResolver;
import lombok.RequiredArgsConstructor;
import model.enums.StatsType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@RequiredArgsConstructor
@ExtendWith(CarServiceParameterResolver.class)
public class MileageStatsServiceTest {

    private final CarService extensionService;

    private final static int MIN = 40000;
    private final static int MAX = 120000;
    private final static double AVG = 197500.0;

    private static StatsAvailable mileageStatsService;
    @BeforeAll
    static void shouldSetMileageStatsService() {
        mileageStatsService = extensionService.getStatsForGivenType(StatsType.MILEAGE);
    }


}
