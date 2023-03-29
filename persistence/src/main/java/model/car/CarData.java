package model.car;

import lombok.*;
import model.carbody.CarBody;
import model.engine.Engine;
import model.wheel.Wheel;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
@ToString

public class CarData {
    long id;
    String carModel;
    BigDecimal carPrice;
    int carMileage;
    Engine carEngine;
    CarBody carBody;
    Wheel carWheel;

    public Car toCar() {
        return new Car(id, carModel, carPrice, carMileage, carEngine, carBody, carWheel);
    }


}
