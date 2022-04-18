package utils;

public interface Analytics<E extends Analytics.AnalyticsItem> {
    public static interface AnalyticsItem {
        public String getLabel();

        public Integer getValue();
    }

    void clear();

    void add(E e);

    String getLabelOf(E e);

    Integer getValueOf(E e);

    Integer getTotalValueOf(E e);

    Integer getQuantityOf(E e);

    Integer getTotalValueOfAll();
}
