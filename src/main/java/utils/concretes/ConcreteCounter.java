package utils.concretes;

import java.util.HashMap;
import java.util.Map;

import utils.Counter;

public class ConcreteCounter<E> implements Counter<E> {
    Map<E, Integer> counter = new HashMap<>();

    @Override
    public void reset() {
        counter.clear();
    }

    @Override
    public void addCount(E item) {
        counter.put(item, getCount(item) + 1);
    }

    @Override
    public Integer getCount(E item) {
        Integer value = counter.get(item);
        if (value == null) {
            return 0;
        }
        return value;
    }
}
