package apiTests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static apiTests.ObjectConverter.*;

public class JacksonDemo {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String bmwPayLoad = "{\n" +
                "    \"model\": \"X6\",\n" +
                "    \"color\": \"black\",\n" +
                "    \"engine\": \"4.0\"\n" +
                "}";


    //    CarPojo bmw = convertJsonToCarClass(bmwPayLoad);
   //   CarPojo bmw = objectMapper.readValue(bmwPayLoad, CarPojo.class);
     //   System.out.println(bmw.getModel());

        CarPojo beha = jsonToAnyJavaObject(bmwPayLoad, CarPojo.class);
        System.out.println(beha.getModel());

//        CarPojo audi = new CarPojo("A6", "red", "2.4");
//        String audiPayLoad = convertJavaToJson(audi);
//        System.out.println(audiPayLoad);
//        String audiPayLoad = objectMapper.writeValueAsString(audi);
//        System.out.println(audiPayLoad);
    }
}
