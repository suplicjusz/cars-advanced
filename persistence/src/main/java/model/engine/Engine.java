package model.engine;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import model.enums.EngineType;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Engine {

    EngineType type;
    double power;

}
