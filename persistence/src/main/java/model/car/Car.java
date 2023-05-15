package model.car;

import lombok.*;
import model.carbody.CarBody;
import model.engine.Engine;
import model.enums.CarBodyType;
import model.wheel.Wheel;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
@Builder
public class Car {

    long id;
    String carModel;
    BigDecimal carPrice;
    int carMileage;
    Engine carEngine;
    CarBody carBody;
    Wheel carWheel;

    public int countComponents() {
        return carBody.getComponents().size();
    }

    public boolean hasCarBodyType(CarBodyType carBodyType) {
        return carBody.hasCarBodyType(carBodyType);
    }

    public boolean hasPriceBetween(BigDecimal min, BigDecimal max) {
        if (min == null) {
            throw new NullPointerException("Min price is null");
        }
        if (max == null) {
            throw new NullPointerException("Max price is null");
        }
        if (min.compareTo(BigDecimal.ZERO) < 0 || max.compareTo(BigDecimal.ZERO) < 0 || min.compareTo(max) > 0) {
            throw new IllegalArgumentException("Invalid input price");
        }

        return carPrice.compareTo(min) >= 0 && carPrice.compareTo(max) <= 0;
    }

    public boolean hasAllComponents(List<String> components) {
        return carBody.hasAllComponents(components);
    }


}
