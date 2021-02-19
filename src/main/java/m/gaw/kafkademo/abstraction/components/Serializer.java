package m.gaw.kafkademo.abstraction.components;

import m.gaw.kafkademo.abstraction.model.ValidatedObject;

import java.util.Optional;

public interface Serializer<T extends ValidatedObject,U> {

    Optional<U> serialize(T validatedObject);

}
