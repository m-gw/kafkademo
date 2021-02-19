package m.gaw.kafkademo.implementation.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public class KafkaErrorProducer {

    private final String TOPIC = "output-error";

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void produce(String message) {
        kafkaTemplate.send(TOPIC, message);
    }

}
