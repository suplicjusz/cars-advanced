package loader.json.impl;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import loader.exception.JsonLoaderException;
import loader.json.JsonLoader;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import model.car.CarData;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class CarsJsonLoaderImpl implements JsonLoader<List<CarData>> {

    private final Gson gson;
    @Override
    public List<CarData> load(String jsonFilename) {
        try(FileReader fileReader = new FileReader(jsonFilename)) {
            return gson.fromJson(fileReader, new TypeToken<List<CarData>>(){}.getType());
        } catch (IOException e) {
            throw new JsonLoaderException("Incorrect filename!");
        }
    }
}
