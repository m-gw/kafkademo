package m.gaw.kafkademo.abstraction.components;

import m.gaw.kafkademo.abstraction.model.ObjectToBeValidated;

import java.util.Optional;

public interface Serializer<T extends ObjectToBeValidated,U> {

    Optional<U> serialize(T objectToBeSerialized);

}
