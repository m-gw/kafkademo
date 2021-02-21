package m.gaw.kafkademo.implementation;

import m.gaw.kafkademo.abstraction.ValidationService;
import m.gaw.kafkademo.abstraction.components.*;
import m.gaw.kafkademo.implementation.model.Triangle;
import org.springframework.stereotype.Service;

@Service
public class TriangleValidationService extends ValidationService<String,Triangle,String> {

    public TriangleValidationService(Deserializer<String, Triangle> deserializer, Serializer<Triangle, String> serializer, ErrorInputConverter<String, String> errorInputConverter, Validator<Triangle> validator, Producer<String> producer) {
        super(deserializer, serializer, errorInputConverter, validator, producer);
    }

}
