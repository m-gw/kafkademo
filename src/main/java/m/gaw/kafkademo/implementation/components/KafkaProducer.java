package m.gaw.kafkademo.implementation.components;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import m.gaw.kafkademo.abstraction.components.Producer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@RequiredArgsConstructor
public class KafkaProducer implements Producer<String> {

    @Value("${spring.kafka.topic.valid}")
    private String validObjectsTopic;

    @Value("${spring.kafka.topic.invalid}")
    private String invalidObjectsTopic;

    private final KafkaTemplate<String,String> kafkaTemplate;

    public void produce(String message, boolean isValid) {
        String topic = isValid ? validObjectsTopic : invalidObjectsTopic;
        log.info("Message '{}' passed to topic {}", message, topic);
        kafkaTemplate.send(topic, message);
    }

}
