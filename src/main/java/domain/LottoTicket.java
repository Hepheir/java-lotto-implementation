package domain;

import domain.dto.LottoMessage;
import lombok.Getter;
import lombok.SneakyThrows;

import java.util.*;

@Getter
public class LottoTicket implements Formattable {
    public static final Integer LOTTO_PRICE = 1000;
    public static final int QUANTITY_OF_NUMBERS = 6;
    private final LottoNumberSequence numbers;

    public LottoTicket(Collection<LottoNumber> numbers) {
        this.numbers = new LottoNumberSequence(numbers, QUANTITY_OF_NUMBERS);
    }

    @Override
    public void formatTo(Formatter formatter, int flags, int width, int precision) {
        LottoMessage.builder()
                .ticket(this)
                .build()
                .formatTo(formatter, flags, width, precision);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof LottoTicket) {
            return o.hashCode() == hashCode();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return numbers.hashCode();
    }
}
