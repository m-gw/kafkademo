package m.gaw.kafkademo.implementation.components;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import m.gaw.kafkademo.abstraction.components.Serializer;
import m.gaw.kafkademo.implementation.model.Triangle;
import org.springframework.stereotype.Component;

@Component
public class TriangleSerializer implements Serializer<Triangle,String> {

    private static ObjectMapper MAPPER = new ObjectMapper();

    public String serialize(Triangle validatedObject) throws JsonProcessingException {
        return MAPPER.writeValueAsString(validatedObject);
    }

}
