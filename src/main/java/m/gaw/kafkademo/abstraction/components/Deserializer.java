package m.gaw.kafkademo.abstraction.components;

import m.gaw.kafkademo.abstraction.model.ValidatedObject;

public interface Deserializer<T> {
    ValidatedObject deserialize(T input);
}
