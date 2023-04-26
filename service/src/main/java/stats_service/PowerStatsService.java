package stats_service;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import model.car.Car;
import model.car.CarMapper;
import model.engine.Engine;


import java.util.Collection;
import java.util.DoubleSummaryStatistics;
import java.util.stream.Collectors;

@EqualsAndHashCode
@ToString
public class PowerStatsService implements StatsService<Double>, StatsAvailable {

    private final DoubleSummaryStatistics dss;

    private PowerStatsService(DoubleSummaryStatistics dss) {
        this.dss = dss;
    }

    public static PowerStatsService of(Collection<Car> cars) {
        return new PowerStatsService(
                cars
                        .stream()
                        .map(CarMapper.carToEngine)
                        .collect(Collectors.summarizingDouble(Engine::getPower))
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
