package model.stats;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import model.car.Car;
import model.car.CarConverter;
import model.engine.EngineConverter;


import java.util.Collection;
import java.util.DoubleSummaryStatistics;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@EqualsAndHashCode
@ToString

public class PowerStats implements Stats<Double>, StatsAvailable {

    private final DoubleSummaryStatistics dss;

    public static PowerStats of(Collection<Car> cars) {
        return new PowerStats(
                cars
                        .stream()
                        .map(CarConverter.carToEngine)
                        .collect(Collectors.summarizingDouble(EngineConverter.engineToPower))
        );
    }

    @Override
    public Double getMin() {
        return dss.getMin();
    }

    @Override
    public Double getMax() {
        return dss.getMax();
    }

    @Override
    public Double getAvg() {
        return dss.getAverage();
    }
}
