package m.gaw.kafkademo.abstraction;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import m.gaw.kafkademo.abstraction.components.*;
import m.gaw.kafkademo.abstraction.model.ValidatedObject;

import java.util.Optional;

@AllArgsConstructor
public abstract class ValidationService<I, T extends ValidatedObject, O> {

    protected Deserializer<I,T> deserializer;
    protected Serializer<T,O> serializer;
    protected ErrorInputConverter<I,O> errorInputConverter;
    protected Validator<T> validator;
    protected Producer<O> producer;

    public void process(I input) {
        final Optional<T> deserializedObject = deserializer.deserialize(input);

        if (deserializedObject.isPresent()) {
            final boolean isValid = validator.isValid(deserializedObject.get());
            final String topic = topic(isValid);

            serializer.serialize(deserializedObject.get())
                    .ifPresent(outputMessage -> producer.produce(topic, outputMessage));

        } else {
            final String errorTopic = topic(false);
            producer.produce(errorTopic, errorInputConverter.convert(input));

        }
    }

    protected abstract String topic(boolean isValid);

}
