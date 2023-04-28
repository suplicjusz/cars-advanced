package stats_service;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import model.car.Car;
import model.engine.Engine;


import java.util.Collection;
import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;

import static model.car.CarMapper.carToEngine;
@EqualsAndHashCode
@ToString
public class PowerStatsService implements StatsService<Integer, Double> {

    private final IntSummaryStatistics iss;

    private PowerStatsService(IntSummaryStatistics iss) {
        this.iss = iss;
    }

    public static PowerStatsService of(Collection<Car> cars) {
        if (cars == null || cars.isEmpty()) {
            throw new IllegalArgumentException("Collection of cars is null or empty!");
        }
        return new PowerStatsService(
                cars
                        .stream()
                        .map(carToEngine)
                        .collect(Collectors.summarizingInt(Engine::getEnginePower))
        );
    }

    @Override
    public Integer getMin() {
        return iss.getMin();
    }

    @Override
    public Integer getMax() {
        return iss.getMax();
    }

    @Override
    public Double getAvg() {
        return iss.getAverage();
    }
}
