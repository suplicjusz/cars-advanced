package loader.json.impl;

import com.google.gson.Gson;
import loader.json.JsonLoader;
import loader.parser.JsonAbstractParser;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import model.car.CarData;
import java.util.List;


@EqualsAndHashCode(callSuper = false)
@ToString
public class CarsJsonLoaderImpl extends JsonAbstractParser<List<CarData>> implements JsonLoader<List<CarData>> {

    protected CarsJsonLoaderImpl(Gson gson) {
        super(gson);
    }

    @Override
    public List<CarData> load(String path) {
        return parseJson(path);
    }
}
