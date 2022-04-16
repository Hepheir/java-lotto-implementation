package domain;

import java.util.Iterator;

public interface LotteryNumberSupplier extends Iterator<LotteryNumber> {
    void restore();
}
