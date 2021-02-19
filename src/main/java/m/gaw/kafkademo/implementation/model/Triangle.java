package m.gaw.kafkademo.implementation.model;

import lombok.Getter;
import m.gaw.kafkademo.abstraction.model.ValidatedObject;

@Getter
public class Triangle extends ValidatedObject {
    private int a;
    private int b;
    private int c;
}
