package m.gaw.kafkademo.implementation.components;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import m.gaw.kafkademo.abstraction.components.Deserializer;
import m.gaw.kafkademo.implementation.model.Triangle;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TriangleDeserializer implements Deserializer<String,Triangle> {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public Optional<Triangle> deserialize(String input) {
        try {
            return Optional.of(MAPPER.readValue(input, Triangle.class));
        } catch (JsonProcessingException e) {
            return Optional.empty();
        }
    }

}
