package domain;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto implements LotteryTicket {
    public static final Integer LOTTO_PRICE = 1000;
    public static final int QUANTITY_OF_NUMBERS = 6;
    private final Set<Integer> numbers;

    public Lotto(Set<Integer> numbers) throws IndexOutOfBoundsException {
        this.numbers = numbers;
    }

    public Lotto() {
        this.numbers = new HashSet<>();
    }

    public Lotto(LotteryTicket ticket) {
        this.numbers = ticket.numbers().stream()
            .map(LotteryNumber::intValue)
            .collect(Collectors.toSet());
    }

    @Override
    public Set<LotteryNumber> numbers() {
        return numbers.stream()
            .map(LotteryNumber::of)
            .collect(Collectors.toSet());
    }

    @Override
    public void addNumber(LotteryNumber number) throws IndexOutOfBoundsException {
        addNumber(number.intValue());
    }

    private void addNumber(Integer number) throws IndexOutOfBoundsException {
        if (numbers.size() >= QUANTITY_OF_NUMBERS) {
            throw new IndexOutOfBoundsException();
        }
        numbers.add(number);
    }

    @Override
    public String toString() {
        String[] stringifiedNumbers = numbers.stream()
            .sorted()
            .map(LotteryNumber::toString)
            .toArray(String[]::new);
        return "[" + String.join(", ", stringifiedNumbers) + "]";
    }
}
