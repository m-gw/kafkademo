package m.gaw.kafkademo.abstraction.components;

public interface ErrorInputConverter<T,U> {

    U convert(T errorInput);

}
