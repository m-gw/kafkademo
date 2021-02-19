package m.gaw.kafkademo.abstraction.components;

import m.gaw.kafkademo.abstraction.model.DeserializationException;
import m.gaw.kafkademo.abstraction.model.ValidatedObject;

public interface Deserializer<T,U extends ValidatedObject> {

    U deserialize(T input) throws DeserializationException;

}
