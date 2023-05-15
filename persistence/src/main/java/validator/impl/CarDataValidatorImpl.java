package validator.impl;

import lombok.NoArgsConstructor;
import model.car.CarData;
import model.carbody.CarBody;
import model.engine.Engine;
import model.wheel.Wheel;
import validator.CarDataValidator;
import validator.Validator;

import java.math.BigDecimal;

@NoArgsConstructor
public class CarDataValidatorImpl implements CarDataValidator {
    @Override
    public CarData validate(CarData carData) {
        return CarData
                .builder()
                .id(
                        Validator.validateLong(
                                carData.getId(),

                                value -> value >= 0L,
                                "Id cannot be negative number!")
                )
                .carModel(
                        Validator.validateString(
                                "[A-Z]+",
                                carData.getCarModel(),
                                "Invalid name of car")
                )
                .carPrice(
                        Validator.validateBigDecimal(
                                carData.getCarPrice(),
                                value -> value.compareTo(BigDecimal.ZERO) > 0,
                                "Price cannot be negative number!"
                        )
                )
                .carMileage(
                        Validator.validateInt(
                                carData.getCarMileage(),
                                value -> value > 0,
                                "Mileage cannot be a negative number!")
                )
                .carEngine(
                        Engine
                                .builder()
                                .engineType(carData.getCarEngine().getEngineType())
                                .enginePower(
                                        Validator.validateInt(
                                                carData.getCarEngine().getEnginePower(),
                                                value -> value > 0,
                                                "Engine power must be a positive number!")
                                )
                                .build()
                )
                .carBody(
                        CarBody
                                .builder()
                                .color(carData.getCarBody().getColor())
                                .carBodyType(carData.getCarBody().getCarBodyType())
                                .components(
                                        carData.getCarBody()
                                                .getComponents()
                                        //todo impl - to dla mnie, olej
                                )
                                .build()
                )
                .carWheel(
                        Wheel
                                .builder()
                                .wheelModel(carData.getCarWheel().getWheelModel())
                                .tyreType(carData.getCarWheel().getTyreType())
                                .wheelSize(
                                        Validator.validateInt(
                                                carData.getCarWheel().getWheelSize(),
                                                value -> value > 0,
                                                "Wheel size cannot be a zero or negative number!")
                                )
                                .build()
                )
                .build();
    }

}
