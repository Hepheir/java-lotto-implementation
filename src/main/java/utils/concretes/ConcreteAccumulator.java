package utils.concretes;

import utils.Accumulator;

public class ConcreteAccumulator implements Accumulator {
    private Integer value = 0;

    @Override
    public void reset() {
        value = 0;
    }

    @Override
    public void add(Integer i) {
        value += i;
    }

    @Override
    public Integer getValue() {
        return value;
    }
}
