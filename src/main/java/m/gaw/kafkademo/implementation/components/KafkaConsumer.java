package m.gaw.kafkademo.implementation.components;

import lombok.AllArgsConstructor;
import m.gaw.kafkademo.abstraction.components.Consumer;
import m.gaw.kafkademo.implementation.TriangleValidationService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class KafkaConsumer implements Consumer<String> {

    private final TriangleValidationService triangleValidationService;

    @KafkaListener(topics = "${spring.kafka.topic.input}", groupId = "group_id")
    public void consume(String message) {
        System.out.printf("#### -> Consumed message -> %s%n", message);
        triangleValidationService.process(message);
    }

}
