package m.gaw.kafkademo.abstraction.components;

import m.gaw.kafkademo.abstraction.model.ObjectToBeValidated;

public interface Validator<T extends ObjectToBeValidated> {

    boolean isValid(T objectToBeValidated);

}
