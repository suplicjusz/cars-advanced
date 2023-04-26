package stats_service;

import collector.BigDecimalSummaryStatistic;
import collector.model.BigDecimalStatistics;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import model.car.Car;
import model.car.CarMapper;

import java.math.BigDecimal;
import java.util.Collection;

@EqualsAndHashCode
@ToString
public class PriceStatsService implements StatsService<BigDecimal>, StatsAvailable {

    private final BigDecimalStatistics bigDecimalStatistics;

    private PriceStatsService(BigDecimalStatistics bigDecimalStatistics) {
        this.bigDecimalStatistics = bigDecimalStatistics;
    }

    public static PriceStatsService of(Collection<Car> cars) {
        return new PriceStatsService(
                cars
                        .stream()
                        .map(CarMapper.carToPrice)
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
