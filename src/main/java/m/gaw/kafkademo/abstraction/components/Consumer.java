package m.gaw.kafkademo.abstraction.components;

public interface Consumer<T> {

    void consume(T input);

}
