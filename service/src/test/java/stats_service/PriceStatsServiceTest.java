package stats_service;

import car_service.CarService;
import extension.CarServiceParameterResolver;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.extension.ExtendWith;

import java.math.BigDecimal;

@RequiredArgsConstructor
@ExtendWith(CarServiceParameterResolver.class)
public class PriceStatsServiceTest {

    private final CarService extensionService;

    private static BigDecimal MIN = BigDecimal.ZERO;
    private static BigDecimal MAX = BigDecimal.ZERO;
    private static BigDecimal AVG = BigDecimal.ZERO;
}
