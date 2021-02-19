package m.gaw.kafkademo.implementation.components;

import m.gaw.kafkademo.abstraction.components.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer implements Producer<String> {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void produce(String topic, String message) {
        kafkaTemplate.send(topic, message);
    }

}
