package m.gaw.kafkademo.implementation.components;

import m.gaw.kafkademo.abstraction.components.ErrorInputConverter;
import org.springframework.stereotype.Component;

@Component
public class ErrorTriangleConverterImpl implements ErrorInputConverter<String,String> {

    public String convert(String errorInput) {
        return errorInput;
    }

}
