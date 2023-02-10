package model.stats;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import model.car.Car;
import model.car.CarConverter;

import java.util.Collection;
import java.util.DoubleSummaryStatistics;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public class MileageStats implements Stats<Double>, StatsAvailable {

    private final DoubleSummaryStatistics dss;

    public static MileageStats of(Collection<Car> cars) {
        return new MileageStats(cars.stream().collect(Collectors.summarizingDouble(CarConverter.carToDoubleMileage)));
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
