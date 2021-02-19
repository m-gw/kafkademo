package m.gaw.kafkademo.implementation.components;

import m.gaw.kafkademo.abstraction.components.Validator;
import m.gaw.kafkademo.abstraction.model.ValidatedObject;
import m.gaw.kafkademo.implementation.model.Triangle;
import org.springframework.stereotype.Component;

@Component
public class TriangleValidator implements Validator {

    public boolean isValid(ValidatedObject validatedObject) {
//        return ((Triangle)validatedObject).getWord().length()>=2;
        return true;
    }

}
