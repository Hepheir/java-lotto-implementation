package utils;

public interface Analytics<E extends AnalyticsItem> {
    void clear();

    void add(E e);

    String getLabel(E e);

    Integer getValue(E e);

    Integer getQuantity(E e);

    Integer getTotalValue();
}
