package m.gaw.kafkademo.implementation.components;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import m.gaw.kafkademo.abstraction.components.Producer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@AllArgsConstructor
public class KafkaProducer implements Producer<String> {

    private final KafkaTemplate<String,String> kafkaTemplate;

    public void produce(String topic, String message) {
        log.info("Message '{}' passed to topic {}", message, topic);
        kafkaTemplate.send(topic, message);
    }

}
