package support;

import model.car.Car;
import model.car.CarMappers;
import model.carbody.CarBody;
import model.engine.Engine;
import model.enums.CarBodyType;
import model.enums.Color;
import model.enums.EngineType;
import model.enums.TyreType;
import model.wheel.Wheel;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public interface CarServiceContent<T> {

    T getExpected();

    default Car findContentCarById(Long id) {
        return carsTestingSet
                .stream()
                .filter(c -> CarMappers.carToId.apply(c).compareTo(id) == 0)
                .findFirst()
                .orElseThrow();
    }

    Set<Car> carsTestingSet = Set.of(
            Car.builder()
                    .id(0)
                    .carModel("AUDI")
                    .carPrice(new BigDecimal("80000"))
                    .carMileage(40000)
                    .carEngine(Engine
                            .builder()
                            .engineType(EngineType.DIESEL)
                            .enginePower(150)
                            .build()
                    )
                    .carBody(CarBody
                            .builder()
                            .color(Color.BLACK)
                            .carBodyType(CarBodyType.HATCHBACK)
                            .components(List.of("ABS"))
                            .build()
                    )
                    .carWheel(Wheel
                            .builder()
                            .wheelModel("AUDI_ORIGINAL")
                            .wheelSize(16)
                            .tyreType(TyreType.SUMMER)
                            .build()
                    )
                    .build(),
            Car.builder()
                    .id(1)
                    .carModel("BMW")
                    .carPrice(new BigDecimal("90000"))
                    .carMileage(50000)
                    .carEngine(Engine
                            .builder()
                            .engineType(EngineType.DIESEL)
                            .enginePower(160)
                            .build()
                    )
                    .carBody(CarBody
                            .builder()
                            .color(Color.WHITE)
                            .carBodyType(CarBodyType.COMBI)
                            .components(List.of("ABS", "AIR_CONDITIONING"))
                            .build()
                    )
                    .carWheel(Wheel
                            .builder()
                            .wheelModel("MBW_ORIGINAL")
                            .wheelSize(17)
                            .tyreType(TyreType.SUMMER)
                            .build()
                    )
                    .build(),
            Car.builder()
                    .id(2)
                    .carModel("CITROEN")
                    .carPrice(new BigDecimal("100000"))
                    .carMileage(100000)
                    .carEngine(Engine
                            .builder()
                            .engineType(EngineType.DIESEL)
                            .enginePower(200)
                            .build()
                    )
                    .carBody(CarBody
                            .builder()
                            .color(Color.RED)
                            .carBodyType(CarBodyType.HATCHBACK)
                            .components(List.of("ABS", "AIR_CONDITIONING"))
                            .build()
                    )
                    .carWheel(Wheel
                            .builder()
                            .wheelModel("AUDI_ORIGINAL")
                            .wheelSize(18)
                            .tyreType(TyreType.WINTER)
                            .build()
                    )
                    .build(),
            Car.builder()
                    .id(3)
                    .carModel("MERCEDES")
                    .carPrice(new BigDecimal("120000"))
                    .carMileage(120000)
                    .carEngine(Engine
                            .builder()
                            .engineType(EngineType.GASOLINE)
                            .enginePower(250)
                            .build()
                    )
                    .carBody(CarBody
                            .builder()
                            .color(Color.BLUE)
                            .carBodyType(CarBodyType.HATCHBACK)
                            .components(List.of("ABS"))
                            .build()
                    )
                    .carWheel(Wheel
                            .builder()
                            .wheelModel("AUDI_ORIGINAL")
                            .wheelSize(17)
                            .tyreType(TyreType.WINTER)
                            .build()
                    )
                    .build()
    );
}
