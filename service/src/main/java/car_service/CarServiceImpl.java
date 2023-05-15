package car_service;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import model.car.Car;
import model.enums.*;
import stats_service.MileageStatsService;
import stats_service.PowerStatsService;
import stats_service.PriceStatsService;
import stats_service.StatsAvailable;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import static model.car.CarComparators.*;
import static model.car.CarMappers.*;

@RequiredArgsConstructor
@EqualsAndHashCode
@Getter
@Builder
public class CarServiceImpl implements CarService {

    private final Set<Car> cars;

    /**
     * @param comparator is a comparator you can choose as criterion of sorting
     * @return List of cars sorted by given criterion
     */

    @Override
    public List<Car> getCarsSortedByCriterion(Comparator<Car> comparator) {
        if (comparator == null) {
            throw new NullPointerException("CarComparator is null");
        }

        return cars
                .stream()
                .sorted(comparator)
                .toList();
    }

    /**
     * @param carBodyType is an enum you can choose a car body type
     * @param min         is a minimal price of car
     * @param max         is a maximal price of car
     * @return List of cars represented given params
     */

    @Override
    public List<Car> getCarsFilteredByCarBodyTypeFromPriceCompartment(
            CarBodyType carBodyType, BigDecimal min, BigDecimal max) {
        if (carBodyType == null) {
            throw new NullPointerException("CarBodyType is null");
        }
        if (min == null) {
            throw new NullPointerException("Min value is null");
        }
        if (max == null) {
            throw new NullPointerException("Max value is null");
        }

        return cars
                .stream()
                .filter(car -> car.hasCarBodyType(carBodyType) && car.hasPriceBetween(min, max))
                .sorted(Comparator.comparing(carToPrice).thenComparing(byIdComparator))
                .toList();
    }

    /**
     * @param engineType is an enum you choose an engine tpe
     * @return List of cars sorted by model represented by given engine type
     */
    @Override
    public List<Car> getCarsSortedByModelFilteredByEngineType(EngineType engineType) {
        return cars
                .stream()
                .filter(car -> carToEngine.apply(car).getEngineType().equals(engineType))
                .sorted(byCarModelInAlphabeticalOrder.thenComparing(byIdComparator))
                .toList();

    }

    /**
     * StatsAvailable is a general type of classes that implement generic type StatsService
     *
     * @param type is an enum you choose a type of stats
     * @return a stats object represented by general type, has avg(), max() and min() methods
     */

    @Override
    public StatsAvailable getStatsForGivenType(StatsType type) {
        return switch (type) {
            case PRICE -> PriceStatsService.of(cars);
            case POWER -> PowerStatsService.of(cars);
            case MILEAGE -> MileageStatsService.of(cars);
        };
    }

    /**
     * @return mileage values sorted by cars in reverse order
     */

    @Override
    public Map<Car, Integer> getMileagesSortedByCars() {
        var temp = new HashMap<Car, Integer>();
        cars.forEach(
                car -> temp.put(car, carToIntMileage.applyAsInt(car))
        );

        return temp
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (c1, c2) -> c2,
                        LinkedHashMap::new
                ));
    }


    /**
     * @return lists of cars sorted by tyre type
     */

    @Override
    public Map<TyreType, List<Car>> getListsOfCarsGroupedByTyreType() {
        return cars
                .stream()
                .collect(Collectors.groupingBy(carToTyreType))
                .entrySet()
                .stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e2,
                        LinkedHashMap::new
                ));

    }

    /**
     * @param components is a list of required components should cars to have
     * @return list of cars contains a given components list
     */
    @Override
    public List<Car> getCarsContainsAllComponentsFromGivenList(List<String> components) {
        if (components == null) {
            throw new NullPointerException("List of required components is null!");
        }
        var temp = new ArrayList<Car>();
        cars.forEach(
                car -> {
                    if (car.hasAllComponents(components)) {
                        temp.add(car);
                    }
                }
        );
        return temp
                .stream()
                .sorted(Comparator.comparing(carToCarModel))
                .toList();
    }

}

