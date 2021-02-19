/*
package m.gaw.kafkademo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    private final Producer producer;

    public KafkaController(Producer producer) {
        this.producer = producer;
    }

    @GetMapping("/publish")
    public void publish(){
        System.out.println("controller works");
        producer.send("im working");
    }

}
*/
