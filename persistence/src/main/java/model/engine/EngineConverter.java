package model.engine;

import model.enums.EngineType;

import java.util.function.Function;
import java.util.function.ToDoubleFunction;

public interface EngineConverter {
    ToDoubleFunction<Engine> engineToPower = engine -> engine.power;
    Function<Engine, EngineType> engineToType = engine -> engine.type;
}
