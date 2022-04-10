package domain;

import java.util.Set;

public class Lotto {
    public static final Integer LOTTO_PRICE = 1000;
    public static final int QUANTITY_OF_NUMBERS = 6;
    private final Set<Integer> numbers;

    public Lotto(Set<Integer> numbers) {
        this.numbers = numbers;
    }
}
