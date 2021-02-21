package m.gaw.kafkademo.implementation.components;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import m.gaw.kafkademo.abstraction.components.Consumer;
import m.gaw.kafkademo.implementation.TriangleValidationService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@AllArgsConstructor
public class KafkaConsumer implements Consumer<String> {

    private final TriangleValidationService triangleValidationService;

    @KafkaListener(topics = "${spring.kafka.topic.input}", groupId = "m_gaw")
    public void consume(String message) {
        log.info("Received message: '{}'", message);
        triangleValidationService.process(message);
    }

}
