package utils;

public interface Analytics<E extends AnalyticsItem> {
    void clear();

    void add(E e);

    String getLabelOf(E e);

    Integer getValueOf(E e);

    Integer getTotalValueOf(E e);

    Integer getQuantityOf(E e);

    Integer getTotalValueOfAll();
}
