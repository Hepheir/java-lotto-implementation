package domain;

public interface Builder<E> {
    void reset();

    E build();
}
