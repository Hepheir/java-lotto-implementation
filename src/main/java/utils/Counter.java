package utils;

public interface Counter<E> {
    void reset();

    void addCount(E item);

    Integer getCount(E item);
}
