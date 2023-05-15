import com.google.gson.Gson;
import factory.CarDataProcessor;

public class AppTemp {
    public static void main(String[] args) {
        Gson gson = new Gson();
        var dataProcessor = CarDataProcessor.createDataProcessor(
                CarDataProcessor.ProcessorType.FROM_JSON_WITH_VALIDATION, gson
        );
        var res1 = dataProcessor.process(
                "C:\\Users\\adasup\\IdeaProjects\\cars-advanced\\persistence\\src\\main\\resources\\cars.json"
        );
        System.out.println(res1);

        var dataProcessor2 = CarDataProcessor.createDataProcessor(
                CarDataProcessor.ProcessorType.FROM_XML_WITH_VALIDATION, gson //ten gson tu trochę bez sensu.
        );
        var res2 = dataProcessor2.process(
                "C:\\Users\\adasup\\IdeaProjects\\cars-advanced\\persistence\\src\\main\\resources\\cars.xml"
        );
        System.out.println(res2);
    }


}

