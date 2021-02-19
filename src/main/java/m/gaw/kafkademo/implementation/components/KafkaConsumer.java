package m.gaw.kafkademo.implementation.components;

import m.gaw.kafkademo.abstraction.components.Consumer;
import m.gaw.kafkademo.implementation.TriangleValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer implements Consumer<String> {

    @Autowired
    private TriangleValidationService triangleValidationService;

    @KafkaListener(topics = "${spring.kafka.topic.input}", groupId = "group_id")
    public void consume(String message) {
        System.out.printf("#### -> Consumed message -> %s%n", message);
        triangleValidationService.process(message);
    }

}
