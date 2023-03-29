package model.engine;

import lombok.*;
import model.enums.EngineType;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@ToString
@Builder
public class Engine {

    private EngineType type;
    private int power;

}
