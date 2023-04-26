package stats_service;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import model.car.Car;
import model.car.CarMapper;

import java.util.Collection;
import java.util.DoubleSummaryStatistics;
import java.util.stream.Collectors;

@EqualsAndHashCode
@ToString
public class MileageStatsService implements StatsService<Double>, StatsAvailable {

    private final DoubleSummaryStatistics dss;

    private MileageStatsService(DoubleSummaryStatistics dss) {
        this.dss = dss;
    }

    public static MileageStatsService of(Collection<Car> cars) {
        return new MileageStatsService(
                cars
                        .stream()
                        .collect(Collectors.summarizingDouble(CarMapper.carToDoubleMileage))
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
