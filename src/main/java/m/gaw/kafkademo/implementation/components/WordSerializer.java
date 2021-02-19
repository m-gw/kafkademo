package m.gaw.kafkademo.implementation.components;

import m.gaw.kafkademo.abstraction.components.Serializer;
import m.gaw.kafkademo.abstraction.model.ValidatedObject;
import m.gaw.kafkademo.implementation.model.Word;
import org.springframework.stereotype.Component;

@Component
public class WordSerializer implements Serializer<String> {

    public String serialize(ValidatedObject validatedObject) {
        return ((Word)validatedObject).getWord();
    }

}
