package m.gaw.kafkademo.abstraction.components;

import com.fasterxml.jackson.core.JsonProcessingException;
import m.gaw.kafkademo.abstraction.model.ValidatedObject;

public interface Serializer<T extends ValidatedObject,U> {
    U serialize(T validatedObject) throws JsonProcessingException;
}
