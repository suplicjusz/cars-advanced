package model.wheel;

import lombok.*;
import model.enums.TyreType;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@ToString
@Builder
public class Wheel {

    private String model;
    private int size;
    private TyreType type;

}
