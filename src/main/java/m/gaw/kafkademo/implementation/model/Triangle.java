package m.gaw.kafkademo.implementation.model;

import m.gaw.kafkademo.abstraction.model.ValidatedObject;

public class Triangle extends ValidatedObject {
    private int a;
    private int b;
    private int c;

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }
}
