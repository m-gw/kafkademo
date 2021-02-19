package m.gaw.kafkademo.implementation;

import m.gaw.kafkademo.abstraction.ValidationService;
import m.gaw.kafkademo.abstraction.components.Deserializer;
import m.gaw.kafkademo.abstraction.components.Producer;
import m.gaw.kafkademo.abstraction.components.Serializer;
import m.gaw.kafkademo.abstraction.components.Validator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ValidationService<String,String> validationService(Deserializer<String> deserializer, Serializer<String> serializer, Validator validator, Producer<String> validObjectProducer, Producer<String> invalidObjectProducer){
        return new ValidationService<>(deserializer, serializer, validator, validObjectProducer, invalidObjectProducer);
    }

}
