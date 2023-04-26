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
import java.util.List;
import java.util.Map;
import java.util.Set;

@RequiredArgsConstructor
@EqualsAndHashCode
@Getter
@Builder
public class CarServiceImpl implements CarService {

    private final Set<Car> cars;


    /*Metoda zwraca kolekcję samochodów posortowaną według kryterium
    podanego jako argument. Metoda powinna umożliwiać sortowanie
    według ilości komponentów, mocy silnika oraz rozmiaru opony.
    Dodatkowo metoda powinna umożliwiać sortowanie rosnąco oraz
    malejąco.*/

    /**
     * @param sortCriterion is an enum you can choose as criterion
     * @return List of cars sorted by given criterion
     */
    @Override
    public List<Car> getCarsSortedByCriterion(SortCriterion sortCriterion) {

        return null;
    }

    /*Metoda zwraca kolekcję samochodów o określonym rodzaju nadwozia
    przekazanym jako argument (CarBodyType) oraz o cenie z
    przedziału <a, b>, gdzie a oraz b to kolejne argumenty metody.*/

    /**
     * @param carBodyType is an enum you can choose a car body type
     * @param min         is a minimal price of car
     * @param max         is a maximal price of car
     * @return List of cars represented given params
     */
    @Override
    public List<Car> getCarsFilteredByCarBodyTypeFromPriceCompartment(CarBodyType carBodyType, BigDecimal min, BigDecimal max) {
        return null;
    }

    /*Metoda zwraca posortowaną alfabetycznie kolekcję modeli
    samochodów, które posiadają typ silnika (EngineType) przekazany
    jako argument metody.*/

    /**
     * @param engineType is an enum you choose an engine tpe
     * @return List of cars sorted by model represented by given engine type
     */
    @Override
    public List<Car> getCarsSortedByModelFilteredByEngineType(EngineType engineType) {
        return null;
    }

    /*Metoda zwraca dane statystyczne dla podanej jako argument
    wielkości. Dopuszczalne wielkości to cena, przebieg oraz moc
    silnika. Dane statystyczne powinny zawierać wartość
    najmniejszą, wartość największą oraz wartość średnią.*/

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

    /*Metoda zwraca mapę, w której kluczem jest obiekt klasy Car,
    natomiast wartością jest liczba kilometrów, które samochód
    przejechał. Pary w mapie posortowane są malejąco według
    wartości.*/

    /**
     * @return mileage values sorted by cars
     */

    @Override
    public Map<Car, Integer> getMileagesSortedByCars() {
        return null;
    }

    /*Metoda zwraca mapę, w której kluczem jest rodzaj opony
    (Tyre Type), a wartością lista samochodów o takim typie opony.
    Mapa posortowana jest malejąco po ilości elementów w kolekcji.*/

    /**
     * @return lists of cars sorted by tyre type
     */
    @Override
    public Map<TyreType, List<Car>> getListsOfCarsGroupedByTyreType() {
        return null;
    }

    /*Metoda zwraca kolekcję samochodów, które posiadają wszystkie
    komponenty z kolekcji przekazanej jako argument. Kolekcja
    posortowana jest alfabetycznie według nazwy modelu samochodu.*/

    /**
     * @param components is a list of required components should have a cars
     * @return list of cars contains a given components list
     */
    @Override
    public List<Car> getCarsContainsAllComponentsFromGivenList(List<String> components) {
        return null;
    }


}
