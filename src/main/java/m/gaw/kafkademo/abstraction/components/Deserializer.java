package m.gaw.kafkademo.abstraction.components;

import m.gaw.kafkademo.abstraction.model.ValidatedObject;

import java.util.Optional;

public interface Deserializer<T,U extends ValidatedObject> {

    Optional<U> deserialize(T input);

}
