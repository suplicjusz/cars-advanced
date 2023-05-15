package loader.json.impl;

import com.google.gson.Gson;
import loader.json.JsonLoader;
import loader.json.parser.JsonAbstractParser;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import model.car.CarData;
import java.util.Set;

@EqualsAndHashCode(callSuper = false)
@ToString
public class CarsJsonLoaderImpl extends JsonAbstractParser<Set<CarData>> implements JsonLoader<Set<CarData>> {

    protected CarsJsonLoaderImpl(Gson gson) {
        super(gson);
    }

    @Override
    public Set<CarData> load(String path) {
        return parseJson(path);
    }

    public static CarsJsonLoaderImpl of(Gson gson) {
        return new CarsJsonLoaderImpl(gson);
    }
}
