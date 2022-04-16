package domain;

public interface LotteryNumberSupplier {
    void restore();

    LotteryNumber getNext();
}
