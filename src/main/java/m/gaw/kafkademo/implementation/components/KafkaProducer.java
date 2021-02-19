package m.gaw.kafkademo.implementation.components;

import lombok.AllArgsConstructor;
import m.gaw.kafkademo.abstraction.components.Producer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class KafkaProducer implements Producer<String> {

    private final KafkaTemplate<String,String> kafkaTemplate;

    public void produce(String topic, String message) {
        kafkaTemplate.send(topic, message);
    }

}
