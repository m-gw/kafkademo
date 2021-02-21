package m.gaw.kafkademo.abstraction.components;

import m.gaw.kafkademo.abstraction.model.ObjectToBeValidated;

import java.util.Optional;

public interface Deserializer<T,U extends ObjectToBeValidated> {

    Optional<U> deserialize(T input);

}
