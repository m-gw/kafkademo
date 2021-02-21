package m.gaw.kafkademo.abstraction;

import lombok.AllArgsConstructor;
import m.gaw.kafkademo.abstraction.components.*;
import m.gaw.kafkademo.abstraction.model.ObjectToBeValidated;

import java.util.Optional;

@AllArgsConstructor
public abstract class ValidationService<I, T extends ObjectToBeValidated, O> {

    protected Deserializer<I,T> deserializer;
    protected Serializer<T,O> serializer;
    protected ErrorInputConverter<I,O> errorInputConverter;
    protected Validator<T> validator;
    protected Producer<O> producer;

    public void process(I input) {
        final Optional<T> deserializedObject = deserializer.deserialize(input);

        if (deserializedObject.isPresent()) {
            final boolean isValid = validator.isValid(deserializedObject.get());

            serializer.serialize(deserializedObject.get())
                    .ifPresent(outputMessage -> producer.produce(outputMessage, isValid));

        } else {
            producer.produce(errorInputConverter.convert(input), false);

        }
    }

}
