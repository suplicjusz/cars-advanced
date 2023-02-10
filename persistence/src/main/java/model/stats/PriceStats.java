package model.stats;

import lombok.RequiredArgsConstructor;
import model.car.Car;

import java.math.BigDecimal;
import java.util.Collection;
@RequiredArgsConstructor
public class PriceStats implements Stats<BigDecimal>, StatsAvailable {

    private final Collection<Car> cars;
    @Override
    public BigDecimal getMin() {
        return new BigDecimal("0");
    }

    @Override
    public BigDecimal getMax() {
        return null;
    }

    @Override
    public BigDecimal getAvg() {
        return null;
    }
}
