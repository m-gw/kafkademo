package m.gaw.kafkademo.implementation.model;

import lombok.Getter;
import lombok.ToString;
import m.gaw.kafkademo.abstraction.model.ValidatedObject;

import java.util.stream.Stream;

@Getter
@ToString
public class Triangle extends ValidatedObject {

    private int a,b,c;

    public boolean canBeConstructed() {
        int circuit = a + b + c;

        return Stream.of(a, b, c)
                .noneMatch(side -> side < 0 || 2 * side >= circuit);
    }

}
