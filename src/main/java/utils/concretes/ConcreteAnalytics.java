package utils.concretes;

import utils.Accumulator;
import utils.Analytics;
import utils.AnalyticsItem;
import utils.Counter;

public class ConcreteAnalytics<E extends AnalyticsItem> implements Analytics<E> {
    private final Counter<E> counter = new ConcreteCounter<>();
    private final Accumulator accumulator = new ConcreteAccumulator();

    @Override
    public void clear() {
        counter.reset();
        accumulator.reset();
    }

    @Override
    public void add(E e) {
        counter.addCount(e);
        accumulator.add(e.getValue());
    }

    @Override
    public String getLabel(E e) {
        return e.getLabel();
    }

    @Override
    public Integer getValue(E e) {
        return e.getValue() * getQuantity(e);
    }

    @Override
    public Integer getQuantity(E e) {
        return counter.getCount(e);
    }

    @Override
    public Integer getTotalValue() {
        return accumulator.getValue();
    }

}
