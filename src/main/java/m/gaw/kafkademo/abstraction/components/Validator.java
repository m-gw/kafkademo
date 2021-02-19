package m.gaw.kafkademo.abstraction.components;

import m.gaw.kafkademo.abstraction.model.ValidatedObject;

public interface Validator {
    boolean isValid(ValidatedObject validatedObject);
}
