package stats_service;

import collector.BigDecimalSummaryStatistic;
import collector.model.BigDecimalStatistics;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import model.car.Car;

import java.math.BigDecimal;
import java.util.Collection;

import static model.car.CarMappers.carToPrice;

@EqualsAndHashCode
@ToString
public class PriceStatsService implements StatsService<BigDecimal, BigDecimal> {

    private final BigDecimalStatistics bigDecimalStatistics;

    private PriceStatsService(BigDecimalStatistics bigDecimalStatistics) {
        this.bigDecimalStatistics = bigDecimalStatistics;
    }

    public static PriceStatsService of(Collection<Car> cars) {
        if (cars == null || cars.isEmpty()) {
            throw new IllegalArgumentException("Collection of cars is null or empty!");
        }
        return new PriceStatsService(
                cars
                        .stream()
                        .map(carToPrice)
                        .collect(new BigDecimalSummaryStatistic())
        );
    }

    @Override
    public BigDecimal getMin() {
        return bigDecimalStatistics.min();
    }

    @Override
    public BigDecimal getMax() {
        return bigDecimalStatistics.max();
    }

    @Override
    public BigDecimal getAvg() {
        return bigDecimalStatistics.avg();
    }
}
