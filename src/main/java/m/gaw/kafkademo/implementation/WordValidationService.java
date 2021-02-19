package m.gaw.kafkademo.implementation;

import m.gaw.kafkademo.abstraction.ValidationService;
import m.gaw.kafkademo.abstraction.components.*;
import org.springframework.stereotype.Service;

@Service
public class WordValidationService extends ValidationService<String,String> {

    private final String TOPIC = "output";

    public WordValidationService(Deserializer<String> deserializer, Serializer<String> serializer, Validator validator, Producer<String> producer) {
        super(deserializer, serializer, validator, producer);
    }

    public String topic(boolean isValid){
        return TOPIC;
    }

}
