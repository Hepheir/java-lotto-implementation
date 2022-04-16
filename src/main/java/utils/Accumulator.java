package utils;

public interface Accumulator {
    void reset();

    void add(Integer i);

    Integer getValue();
}
