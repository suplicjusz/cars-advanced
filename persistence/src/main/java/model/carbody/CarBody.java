package model.carbody;

import lombok.*;
import model.enums.Color;
import model.enums.CarBodyType;

import java.util.List;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@ToString
@Builder
public class CarBody {

    private Color color;
    private CarBodyType type;
    private List<String> components;

}
