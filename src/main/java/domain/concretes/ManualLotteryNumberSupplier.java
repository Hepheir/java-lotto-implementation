package domain.concretes;

import java.util.LinkedList;
import java.util.Queue;

import controllers.Controller;
import controllers.concretes.ConcreteController;
import domain.LotteryNumber;
import domain.LotteryNumberSupplier;

public class ManualLotteryNumberSupplier implements LotteryNumberSupplier {
    private static final String SEQUENCE_DELIMITER = ", ";
    private static final Controller contoller = ConcreteController.getInstance();
    private final Queue<LotteryNumber> numberQueue = new LinkedList<>();

    @Override
    public void restore() {
        numberQueue.clear();
        contoller.readIntegerSequence(SEQUENCE_DELIMITER).stream()
                .map(LotteryNumber::of)
                .forEach(numberQueue::offer);
    }

    @Override
    public boolean hasNext() {
        return !numberQueue.isEmpty();
    }

    @Override
    public LotteryNumber next() {
        return numberQueue.remove();
    }
}
