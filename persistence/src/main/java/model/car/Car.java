package model.car;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import model.carbody.CarBody;
import model.engine.Engine;
import model.wheel.Wheel;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
public class Car {

    long id;
    String carModel;
    BigDecimal carPrice;
    int carMileage;
    Engine carEngine;
    CarBody carBody;
    Wheel carWheel;




}
