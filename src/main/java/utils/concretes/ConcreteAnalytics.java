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

    @Deprecated
    @Override
    public String getLabelOf(E e) {
        return e.getLabel();
    }

    @Override
    public Integer getValueOf(E e) {
        return e.getValue();
    }

    @Override
    public Integer getTotalValueOf(E e) {
        return getValueOf(e) * getQuantityOf(e);
    }

    @Override
    public Integer getQuantityOf(E e) {
        return counter.getCount(e);
    }

    @Override
    public Integer getTotalValueOfAll() {
        return accumulator.getValue();
    }

}
