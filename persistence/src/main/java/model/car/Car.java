package model.car;

import lombok.*;
import model.carbody.CarBody;
import model.engine.Engine;
import model.wheel.Wheel;

import java.math.BigDecimal;

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


}
