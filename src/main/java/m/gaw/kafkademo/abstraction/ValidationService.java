package m.gaw.kafkademo.abstraction;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import m.gaw.kafkademo.abstraction.components.*;
import m.gaw.kafkademo.abstraction.model.DeserializationException;
import m.gaw.kafkademo.abstraction.model.SerializationException;
import m.gaw.kafkademo.abstraction.model.ValidatedObject;

@AllArgsConstructor
public abstract class ValidationService<I, T extends ValidatedObject, O> {

    protected Deserializer<I,T> deserializer;
    protected Serializer<T,O> serializer;
    protected ErrorInputConverter<I,O> errorInputConverter;
    protected Validator<T> validator;
    protected Producer<O> producer;

    public void process(I input){
        T validatedObject;
        try {
            validatedObject = deserializer.deserialize(input);
        } catch (DeserializationException e){
            producer.produce(topic(false), errorInputConverter.convert(input));
            return;
        }

        final boolean isValid = validator.isValid(validatedObject);
        final String topic = topic(isValid);

        final O outputMessage;
        try {
            outputMessage = serializer.serialize(validatedObject);
        } catch (SerializationException e) {
            e.printStackTrace();
            return;
        }
        producer.produce(topic, outputMessage);
    }

    protected abstract String topic(boolean isValid);

}
