package domain.concretes;

import java.util.HashSet;
import java.util.Set;

import domain.LotteryNumber;
import domain.LotteryTicket;

public class ConcreteLotteryTicket implements LotteryTicket {
    private final Set<LotteryNumber> numbers;

    public ConcreteLotteryTicket(Set<LotteryNumber> numbers) {
        this.numbers = numbers;
    }

    public ConcreteLotteryTicket() {
        this.numbers = new HashSet<LotteryNumber>();
    }

    @Override
    public Set<LotteryNumber> numbers() {
        return numbers;
    }

    @Override
    public void addNumber(LotteryNumber number) throws IndexOutOfBoundsException {
        if (numbers.size() >= QUANTITY_OF_NUMBERS) {
            throw new IndexOutOfBoundsException();
        }
        numbers.add(number);
    }

    @Override
    public String toString() {
        String[] stringifiedNumbers = numbers.stream()
            .sorted()
            .map(LotteryNumber::intValue)
            .map(LotteryNumber::toString)
            .toArray(String[]::new);
        return "[" + String.join(", ", stringifiedNumbers) + "]";
    }
}
