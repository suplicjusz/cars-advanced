package car_service;

import model.car.Car;
import model.enums.*;
import stats_service.StatsAvailable;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;


public interface CarService {

    List<Car> getCarsSortedByCriterion(Comparator<Car> carComparator);
    List<Car> getCarsFilteredByCarBodyTypeFromPriceCompartment(CarBodyType carBodyType, BigDecimal min, BigDecimal max);
    List<Car> getCarsSortedByModelFilteredByEngineType(EngineType engineType);
    StatsAvailable getStatsForGivenType(StatsType type);
    Map<Car, Integer> getMileagesSortedByCars();
    Map<TyreType, List<Car>> getListsOfCarsGroupedByTyreType();
    List<Car> getCarsContainsAllComponentsFromGivenList(List<String> components);
}
