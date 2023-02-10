package model.carbody;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import model.enums.CarBodyColor;
import model.enums.CarBodyType;

import java.util.List;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class CarBody {

    CarBodyColor color;
    CarBodyType type;
    List<String> components;

}
