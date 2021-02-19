package m.gaw.kafkademo.implementation.components;

import m.gaw.kafkademo.abstraction.components.Deserializer;
import m.gaw.kafkademo.abstraction.model.ValidatedObject;
import m.gaw.kafkademo.implementation.model.Word;
import org.springframework.stereotype.Component;

@Component
public class WordDeserializer implements Deserializer<String> {

    @Override
    public ValidatedObject deserialize(String input) {
        return new Word(input);
    }
}
