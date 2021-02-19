package m.gaw.kafkademo.implementation.components;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import m.gaw.kafkademo.abstraction.components.Deserializer;
import m.gaw.kafkademo.abstraction.model.DeserializationException;
import m.gaw.kafkademo.implementation.model.Triangle;
import org.springframework.stereotype.Component;

@Component
public class TriangleDeserializer implements Deserializer<String,Triangle> {

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Triangle deserialize(String input) {
        try {
            return objectMapper.readValue(input, Triangle.class);
        } catch (JsonProcessingException e) {
            throw new DeserializationException();
        }
    }

}
