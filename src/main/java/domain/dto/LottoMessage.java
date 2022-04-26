package domain.dto;

import domain.LottoTicket;
import domain.LottoNumber;
import domain.LottoNumberSequence;
import lombok.Builder;
import lombok.Getter;

import java.util.Formattable;
import java.util.Formatter;

@Builder
@Getter
public class LottoMessage implements Formattable {
    @Builder.Default
    private final String prefix = "[";
    @Builder.Default
    private final String suffix = "]";
    @Builder.Default
    private final String delimiter = ", ";
    private final LottoTicket ticket;

    @Override
    public void formatTo(Formatter formatter, int flags, int width, int precision) {
        formatter.format(this.toString());
    }

    @Override
    public String toString() {
        return prefix + String.join(delimiter, getStringifiedNumbers()) + suffix;
    }

    private String[] getStringifiedNumbers() {
        return stringifyNumberSequence(ticket.getNumbers());
    }

    private String[] stringifyNumberSequence(LottoNumberSequence numberSequence) {
        return numberSequence.stream()
                .sorted()
                .map(LottoNumber::toString)
                .toArray(String[]::new);
    }
}
