package m.gaw.kafkademo.implementation.components;

import m.gaw.kafkademo.abstraction.components.Validator;
import m.gaw.kafkademo.abstraction.model.ValidatedObject;
import m.gaw.kafkademo.implementation.model.Word;
import org.springframework.stereotype.Component;

@Component
public class WordValidator implements Validator {

    public boolean isValid(ValidatedObject validatedObject) {
        return ((Word)validatedObject).getWord().length()>=2;
    }

}
