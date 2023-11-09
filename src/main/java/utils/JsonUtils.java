package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class JsonUtils {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static <T> String convertToJson(T object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return object instanceof List ? "[]" : "{}";
        }
    }
}
