package carservice;

import model.car.Car;
import model.enums.CarBodyType;
import model.enums.StatsType;
import model.enums.TyreType;
import model.stats.Stats;
import model.stats.StatsAvailable;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface CarService {

    List<Car> getCarsSortedByCriterion();
    List<Car> getCarsFilteredByCarBodyTypeFromPriceCompartment(CarBodyType carBodyType, BigDecimal min, BigDecimal max);
    List<Car> getCarsSortedByModelFilteredByEngineType();
    StatsAvailable getStatsForGivenType(StatsType type);
    Map<Car, Integer> getMileagesSortedByCars();
    Map<TyreType, List<Car>> getCarListsSortedByTyreType();
    List<Car> getCarsContainsAllComponentsFromGivenList(List<String> components);
}
