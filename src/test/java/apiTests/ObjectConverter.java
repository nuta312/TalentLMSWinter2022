package apiTests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectConverter {
   static ObjectMapper objectMapper = new ObjectMapper();
    public static CarPojo convertJsonToJavaObject(String json) throws JsonProcessingException {
        return objectMapper.readValue(json,CarPojo.class);
    }
}
