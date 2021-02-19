package m.gaw.kafkademo.abstraction.components;

import m.gaw.kafkademo.abstraction.model.ValidatedObject;

public interface Validator<T extends ValidatedObject> {

    boolean isValid(T validatedObject);

}
