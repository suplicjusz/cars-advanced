package model.wheel;

import lombok.*;
import model.enums.TyreType;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@ToString
@Builder
public class Wheel {

    private String wheelModel;
    private int wheelSize;
    private TyreType tyreType;

}
