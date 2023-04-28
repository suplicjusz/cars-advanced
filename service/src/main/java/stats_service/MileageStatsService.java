package stats_service;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import model.car.Car;

import java.util.Collection;
import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;

import static model.car.CarMapper.*;

@EqualsAndHashCode
@ToString
public class MileageStatsService implements StatsService<Integer, Double> {

    private final IntSummaryStatistics iss;

    private MileageStatsService(IntSummaryStatistics iss) {
        this.iss = iss;
    }

    public static MileageStatsService of(Collection<Car> cars) {
        if (cars == null || cars.isEmpty()) {
            throw new IllegalArgumentException("Collection of cars is null or empty!");
        }
        return new MileageStatsService(
                cars
                        .stream()
                        .collect(Collectors.summarizingInt(carToIntMileage))
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
