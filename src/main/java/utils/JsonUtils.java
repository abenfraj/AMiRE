package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fr.amire.entities.CandidatureEntity;
import com.fr.amire.entities.EcoleEntity;
import com.fr.amire.entities.EnseignantEntity;

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

    public static EnseignantEntity convertJsonToEnseignant(String json) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            EnseignantEntity enseignant = mapper.readValue(json, EnseignantEntity.class);
            return enseignant;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static EcoleEntity convertJsonToEcole(String json) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            EcoleEntity ecole = mapper.readValue(json, EcoleEntity.class);
            return ecole;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static CandidatureEntity convertJsonToCandidature(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(json, CandidatureEntity.class);
        } catch (JsonProcessingException e) {
            return null;
        }
    }
}
