package m.gaw.kafkademo.abstraction.components;

import m.gaw.kafkademo.abstraction.model.ValidatedObject;

public interface Serializer<T> {
    T serialize(ValidatedObject validatedObject);
}
