package m.gaw.kafkademo.abstraction;

import com.fasterxml.jackson.core.JsonProcessingException;
import m.gaw.kafkademo.abstraction.components.*;
import m.gaw.kafkademo.abstraction.model.DeserializationException;
import m.gaw.kafkademo.abstraction.model.ValidatedObject;

public abstract class ValidationService<I, T extends ValidatedObject, O> {

    protected Deserializer<I,T> deserializer;
    protected Serializer<T,O> serializer;
    protected ErrorInputConverter<I,O> errorInputConverter;
    protected Validator validator;
    protected Producer<O> producer;

    public ValidationService(Deserializer<I, T> deserializer, Serializer<T, O> serializer, ErrorInputConverter<I, O> errorInputConverter, Validator validator, Producer<O> producer) {
        this.deserializer = deserializer;
        this.serializer = serializer;
        this.errorInputConverter = errorInputConverter;
        this.validator = validator;
        this.producer = producer;
    }

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
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return;
        }
        producer.produce(topic, outputMessage);
    }

    protected abstract String topic(boolean isValid);

}
