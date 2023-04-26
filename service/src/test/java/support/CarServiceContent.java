package support;

import model.car.Car;
import model.car.CarMapper;
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
                .filter(c -> CarMapper.carToId.apply(c).compareTo(id) == 0)
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
                            .type(EngineType.DIESEL)
                            .power(150)
                            .build()
                    )
                    .carBody(CarBody
                            .builder()
                            .color(Color.BLACK)
                            .type(CarBodyType.HATCHBACK)
                            .components(List.of("ABS"))
                            .build()
                    )
                    .carWheel(Wheel
                            .builder()
                            .model("AUDI_ORIGINAL")
                            .type(TyreType.SUMMER)
                            .size(16)
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
                            .type(EngineType.DIESEL)
                            .power(160)
                            .build()
                    )
                    .carBody(CarBody
                            .builder()
                            .color(Color.WHITE)
                            .type(CarBodyType.COMBI)
                            .components(List.of("ABS", "AIR_CONDITIONING"))
                            .build()
                    )
                    .carWheel(Wheel
                            .builder()
                            .model("MBW_ORIGINAL")
                            .type(TyreType.SUMMER)
                            .size(17)
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
                            .type(EngineType.DIESEL)
                            .power(200)
                            .build()
                    )
                    .carBody(CarBody
                            .builder()
                            .color(Color.RED)
                            .type(CarBodyType.HATCHBACK)
                            .components(List.of("ABS", "AIR_CONDITIONING"))
                            .build()
                    )
                    .carWheel(Wheel
                            .builder()
                            .model("AUDI_ORIGINAL")
                            .type(TyreType.SUMMER)
                            .size(18)
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
                            .type(EngineType.GASOLINE)
                            .power(250)
                            .build()
                    )
                    .carBody(CarBody
                            .builder()
                            .color(Color.BLUE)
                            .type(CarBodyType.HATCHBACK)
                            .components(List.of("ABS"))
                            .build()
                    )
                    .carWheel(Wheel
                            .builder()
                            .model("AUDI_ORIGINAL")
                            .type(TyreType.SUMMER)
                            .size(17)
                            .build()
                    )
                    .build()
    );
}
