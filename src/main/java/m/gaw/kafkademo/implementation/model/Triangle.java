package m.gaw.kafkademo.implementation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import m.gaw.kafkademo.abstraction.model.ObjectToBeValidated;

import java.util.stream.Stream;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Triangle extends ObjectToBeValidated {

    private int a,b,c;

    public boolean canBeConstructed() {
        int circuit = a + b + c;

        return Stream.of(a, b, c)
                .noneMatch(side -> side < 0 || 2 * side >= circuit);
    }

}
