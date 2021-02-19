package m.gaw.kafkademo.implementation;

import m.gaw.kafkademo.abstraction.ValidationService;
import m.gaw.kafkademo.abstraction.components.*;
import org.springframework.stereotype.Service;

@Service
public class WordValidationService extends ValidationService<String,String> {

    public WordValidationService(Deserializer<String> deserializer, Serializer<String> serializer, Validator validator, Producer<String> validObjectProducer, Producer<String> invalidObjectProducer) {
        super(deserializer, serializer, validator, validObjectProducer, invalidObjectProducer);
    }
}
