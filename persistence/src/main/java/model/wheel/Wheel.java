package model.wheel;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import model.enums.TyreType;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Wheel {

    String model;
    int size;
    TyreType type;

}
