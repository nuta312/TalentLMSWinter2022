package apiTests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//import static apiTests.ObjectConverter.convertJsonToCarClass;

public class JacksonDemo {

    public static void main(String[] args) throws JsonProcessingException {

        String bmwPayLoad = "{\n" +
                "    \"model\": \"X6\",\n" +
                "    \"color\": \"black\",\n" +
                "    \"engine\": \"4.0\"\n" +
                "}";


//        CarPojo bmw = convertJsonToCarClass(bmwPayLoad);
//        System.out.println(bmw.getModel());


    }
}
