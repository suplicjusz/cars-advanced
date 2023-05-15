package model.carbody;

import lombok.*;
import model.enums.Color;
import model.enums.CarBodyType;

import java.util.HashSet;
import java.util.List;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@ToString
@Builder
public class CarBody {

    private Color color;
    private CarBodyType carBodyType;
    private List<String> components;

    public boolean hasCarBodyType(CarBodyType cbt) {
        if (cbt == null) {
            throw new NullPointerException("Enum CarBodyType is null");
        }
        return carBodyType.equals(cbt);
    }

    public boolean hasAllComponents(List<String> components) {
        return new HashSet<>(this.components).containsAll(components);
    }

}
