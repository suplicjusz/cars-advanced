package stats_service;

import car_service.CarService;
import extension.CarServiceParameterResolver;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.extension.ExtendWith;

@RequiredArgsConstructor
@ExtendWith(CarServiceParameterResolver.class)
public class PowerStatsServiceTest {

    private final CarService extensionService;
    private final static int MIN = 150;
    private final static int MAX = 250;
    private final static double AVG = 190.0;
}
