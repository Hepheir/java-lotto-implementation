package domain.concretes;

import java.util.Collections;
import java.util.Stack;

import domain.LotteryNumber;
import domain.LotteryNumberSupplier;

public class AutoLotteryNumberSupplier implements LotteryNumberSupplier {
    private Stack<LotteryNumber> numberStack = new Stack<>();

    @Override
    public void restore() {
        numberStack.clear();
        for (int i = LotteryNumber.MIN_VALUE; i <= LotteryNumber.MAX_VALUE; i++) {
            numberStack.push(LotteryNumber.of(i));
        }
        Collections.shuffle(numberStack);
    }

    @Override
    public boolean hasNext() {
        return !numberStack.isEmpty();
    }

    @Override
    public LotteryNumber next() {
        return numberStack.pop();
    }
}
