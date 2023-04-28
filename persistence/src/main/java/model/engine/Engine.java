package model.engine;

import lombok.*;
import model.enums.EngineType;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@ToString
@Builder
public class Engine {

    private EngineType engineType;
    private int enginePower;

}
