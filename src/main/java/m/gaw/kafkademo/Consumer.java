/*
package m.gaw.kafkademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Consumer {

    @Autowired
    private Producer producer;

    @KafkaListener(topics = "triangles", groupId = "group_id")
    public void consume(String message) throws IOException {
        System.out.printf("#### -> Consumed message -> %s%n", message);
        producer.send(message);
    }

}
*/
