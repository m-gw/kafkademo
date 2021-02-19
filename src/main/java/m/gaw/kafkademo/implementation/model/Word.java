package m.gaw.kafkademo.implementation.model;

import m.gaw.kafkademo.abstraction.model.ValidatedObject;

public class Word extends ValidatedObject {
    String word;

    public Word(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }
}
