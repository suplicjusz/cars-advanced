package stats_service;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import model.car.Car;

import java.math.BigDecimal;
import java.util.Collection;

@EqualsAndHashCode
@ToString
public class PriceStatsService implements StatsService<BigDecimal>, StatsAvailable {

    private final Collection<Car> cars;

    private PriceStatsService(Collection<Car> cars) {
        this.cars = cars;
    }

    public static PriceStatsService of(Collection<Car> cars) {
        return new PriceStatsService(cars);
    }
    @Override
    public BigDecimal getMin() {
        return null;
    } //todo impl

    @Override
    public BigDecimal getMax() {
        return null;
    }

    @Override
    public BigDecimal getAvg() {
        return null;
    }
}
