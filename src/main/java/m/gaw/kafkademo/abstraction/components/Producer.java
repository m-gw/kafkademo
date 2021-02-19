package m.gaw.kafkademo.abstraction.components;

public interface Producer<T> {
    void produce(T output);
}
