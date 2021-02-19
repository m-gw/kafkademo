package m.gaw.kafkademo.abstraction;

import m.gaw.kafkademo.abstraction.components.Deserializer;
import m.gaw.kafkademo.abstraction.components.Producer;
import m.gaw.kafkademo.abstraction.components.Serializer;
import m.gaw.kafkademo.abstraction.components.Validator;
import m.gaw.kafkademo.abstraction.model.ValidatedObject;

public abstract class ValidationService<T,U> {

    protected Deserializer<T> deserializer;
    protected Serializer<U> serializer;
    protected Validator validator;
    protected Producer<U> producer;

    public ValidationService(Deserializer<T> deserializer, Serializer<U> serializer, Validator validator, Producer<U> producer) {
        this.deserializer = deserializer;
        this.serializer = serializer;
        this.validator = validator;
        this.producer = producer;
    }

    public void process(T input){
        ValidatedObject validatedObject = deserializer.deserialize(input);

        final boolean isValid = validator.isValid(validatedObject);
        final String topic = topic(isValid);

        final U outputMessage = serializer.serialize(validatedObject);
        producer.produce(topic, outputMessage);
    }

    protected abstract String topic(boolean isValid);

}
