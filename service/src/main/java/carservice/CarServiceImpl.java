package carservice;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
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

@RequiredArgsConstructor
@EqualsAndHashCode
public class CarServiceImpl implements CarService {

    private final Set<Car> cars;


    /*Metoda zwraca kolekcję samochodów posortowaną według kryterium
    podanego jako argument. Metoda powinna umożliwiać sortowanie
    według ilości komponentów, mocy silnika oraz rozmiaru opony.
    Dodatkowo metoda powinna umożliwiać sortowanie rosnąco oraz
    malejąco.*/

    public List<Car> getCarsSortedByCriterion() {
        return null;
    }

    /*Metoda zwraca kolekcję samochodów o określonym rodzaju nadwozia
    przekazanym jako argument (CarBodyType) oraz o cenie z
    przedziału <a, b>, gdzie a oraz b to kolejne argumenty metody.*/

    public List<Car> getCarsFilteredByCarBodyTypeFromPriceCompartment(CarBodyType carBodyType, BigDecimal min, BigDecimal max) {
        return null;
    }

    /*Metoda zwraca posortowaną alfabetycznie kolekcję modeli
    samochodów, które posiadają typ silnika (EngineType) przekazany
    jako argument metody.*/

    public List<Car> getCarsSortedByModelFilteredByEngineType() {
        return null;
    }

    /*Metoda zwraca dane statystyczne dla podanej jako argument
    wielkości. Dopuszczalne wielkości to cena, przebieg oraz moc
    silnika. Dane statystyczne powinny zawierać wartość
    najmniejszą, wartość największą oraz wartość średnią.*/

    public StatsAvailable getStatsForGivenType(StatsType type) {
        return null;
    }

    /*Metoda zwraca mapę, w której kluczem jest obiekt klasy Car,
    natomiast wartością jest liczba kilometrów, które samochód
    przejechał. Pary w mapie posortowane są malejąco według
    wartości.*/

    public Map<Car, Integer> getMileagesSortedByCars() {
        return null;
    }

    /*Metoda zwraca mapę, w której kluczem jest rodzaj opony
    (TyreType), a wartością lista samochodów o takim typie opony.
    Mapa posortowana jest malejąco po ilości elementów w kolekcji.*/

    public Map<TyreType, List<Car>> getCarListsSortedByTyreType() {
        return null;
    }

    /*Metoda zwraca kolekcję samochodów, które posiadają wszystkie
    komponenty z kolekcji przekazanej jako argument. Kolekcja
    posortowana jest alfabetycznie według nazwy modelu samochodu.*/

    public List<Car> getCarsContainsAllComponentsFromGivenList(List<String> components) {
        return null;
    }


}
