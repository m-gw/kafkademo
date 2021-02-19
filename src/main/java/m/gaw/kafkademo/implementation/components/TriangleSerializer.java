package m.gaw.kafkademo.implementation.components;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import m.gaw.kafkademo.abstraction.components.Serializer;
import m.gaw.kafkademo.implementation.model.Triangle;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TriangleSerializer implements Serializer<Triangle,String> {

    private final static ObjectMapper MAPPER = new ObjectMapper();

    public Optional<String> serialize(Triangle validatedObject){
        try {
            return Optional.of(MAPPER.writeValueAsString(validatedObject));
        } catch (JsonProcessingException e) {
            return Optional.empty();
        }
    }

}
