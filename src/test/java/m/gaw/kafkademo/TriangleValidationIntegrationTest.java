package m.gaw.kafkademo;

import m.gaw.kafkademo.implementation.components.KafkaConsumer;
import m.gaw.kafkademo.implementation.components.KafkaProducer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.verify;

@SpringBootTest
public class TriangleValidationIntegrationTest {

    @Value("${spring.kafka.topic.valid}")
    private String validObjectsTopic;

    @Value("${spring.kafka.topic.invalid}")
    private String invalidObjectsTopic;


    @Autowired
    private KafkaConsumer consumer;

    @MockBean
    private KafkaProducer producer;


    @Test
    void shouldSendMessageWithIncorrectSyntaxToInvalidObjectTopic(){
        //given
        String input = "incorrect_syntax_input";

        //when
        consumer.consume(input);

        //then
        verify(producer).produce(invalidObjectsTopic, input);
    }

    @Test
    void shouldSendTriangleWithNegativeSideToInvalidObjectTopic(){
        //given
        String input = "{\"a\":-1,\"b\":2,\"c\":2}";

        //when
        consumer.consume(input);

        //then
        verify(producer).produce(invalidObjectsTopic, input);
    }

    @Test
    void shouldSendTriangleWithTooLongSideToInvalidObjectTopic(){
        //given
        String input = "{\"a\":11,\"b\":2,\"c\":2}";

        //when
        consumer.consume(input);

        //then
        verify(producer).produce(invalidObjectsTopic, input);
    }

    @Test
    void shouldSendValidTriangleToValidObjectTopic(){
        //given
        String input = "{\"a\":1,\"b\":2,\"c\":2}";

        //when
        consumer.consume(input);

        //then
        verify(producer).produce(validObjectsTopic, input);
    }

}
