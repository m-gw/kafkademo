package m.gaw.kafkademo.implementation.components;

import m.gaw.kafkademo.abstraction.components.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer implements Producer<String> {

    private final String TOPIC = "output";

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void produce(String message) {
        kafkaTemplate.send(TOPIC, message);
    }

}
