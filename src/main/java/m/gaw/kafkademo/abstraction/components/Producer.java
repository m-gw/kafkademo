package m.gaw.kafkademo.abstraction.components;

public interface Producer<T> {
    void produce(String topic, T output);
}
