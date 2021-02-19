package m.gaw.kafkademo.implementation;

import m.gaw.kafkademo.abstraction.ValidationService;
import m.gaw.kafkademo.abstraction.components.*;
import m.gaw.kafkademo.implementation.model.Triangle;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TriangleValidationService extends ValidationService<String,Triangle,String> {

    @Value("${spring.kafka.topic.valid}")
    private String validObjectsTopic;

    @Value("${spring.kafka.topic.invalid}")
    private String invalidObjectsTopic;

    public TriangleValidationService(Deserializer<String, Triangle> deserializer, Serializer<Triangle, String> serializer, ErrorInputConverter<String, String> errorInputConverter, Validator<Triangle> validator, Producer<String> producer) {
        super(deserializer, serializer, errorInputConverter, validator, producer);
    }

    public String topic(boolean isValid){
        return isValid ? validObjectsTopic : invalidObjectsTopic;
    }

}
