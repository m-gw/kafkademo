/*
package m.gaw.kafkademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    private static final String TOPIC = "triangles-ok";

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void send(String message){
        kafkaTemplate.send(TOPIC, message + " modified");
    }

}
*/
