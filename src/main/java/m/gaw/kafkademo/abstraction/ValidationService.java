package m.gaw.kafkademo.abstraction;

import m.gaw.kafkademo.abstraction.components.Deserializer;
import m.gaw.kafkademo.abstraction.components.Producer;
import m.gaw.kafkademo.abstraction.components.Serializer;
import m.gaw.kafkademo.abstraction.components.Validator;
import m.gaw.kafkademo.abstraction.model.ValidatedObject;

public class ValidationService<T,U> {

    protected Deserializer<T> deserializer;
    protected Serializer<U> serializer;
    protected Validator validator;
    protected Producer<U> validObjectProducer;
    protected Producer<U> invalidObjectProducer;

    public ValidationService(Deserializer<T> deserializer, Serializer<U> serializer, Validator validator, Producer<U> validObjectProducer, Producer<U> invalidObjectProducer) {
        this.deserializer = deserializer;
        this.serializer = serializer;
        this.validator = validator;
        this.validObjectProducer = validObjectProducer;
        this.invalidObjectProducer = invalidObjectProducer;
    }

    public void process(T input){

        ValidatedObject validatedObject = deserializer.deserialize(input);
        U outputMessage = serializer.serialize(validatedObject);

        if(validator.isValid(validatedObject))
            validObjectProducer.produce(outputMessage);

        else
            invalidObjectProducer.produce(outputMessage);

    }

}
