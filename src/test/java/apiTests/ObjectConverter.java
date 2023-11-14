package apiTests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectConverter {
    static ObjectMapper objectMapper = new ObjectMapper();
    public static CarPojo convertJsonToCarClass(String json) throws JsonProcessingException {
        return objectMapper.readValue(json, CarPojo.class);
    }

    public static <T> T convertJsonToAnyJavaObject(String json, Class<T> clazz) throws JsonProcessingException {
        return objectMapper.readValue(json, clazz);
    }

    public static String convertJavaToJson(CarPojo carPojo) throws JsonProcessingException {
        return objectMapper.writeValueAsString(carPojo);
    }
}

 //   CarPojo audi = new CarPojo("A6", "red", "2.4");
//        String audiPayLoad = objectMapper.writeValueAsString(audi);
//        System.out.println(audiPayLoad);
