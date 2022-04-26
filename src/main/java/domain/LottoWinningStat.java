package domain;

import lombok.Builder;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import types.Mergeable;

import java.util.Formattable;
import java.util.Formatter;

@Builder
@Getter
public class LottoWinningStat implements Comparable<LottoWinningStat>, Formattable, Mergeable<LottoWinningStat> {
    private LottoGrade grade;
    @Builder.Default
    private Integer quantity = 0;

    @Override
    public int compareTo(@NotNull LottoWinningStat otherStat) {
        return otherStat.grade.getReward().compareTo(grade.getReward());
    }

    @Override
    public void formatTo(Formatter formatter, int flags, int width, int precision) {
        formatter.format("%s - %d개", grade, quantity);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof LottoWinningStat) {
            LottoWinningStat otherStat = (LottoWinningStat) obj;
            return equals(otherStat);
        }
        return false;
    }

    @Override
    public LottoWinningStat merge(LottoWinningStat otherStat) throws IllegalArgumentException {
        if (!isMergeable(otherStat)) {
            throw new IllegalArgumentException("합칠 수 없음.");
        }
        this.quantity += otherStat.quantity;
        return this;
    }

    private boolean equals(LottoWinningStat otherStat) {
        return otherStat.grade.equals(grade);
    }

    private boolean isMergeable(LottoWinningStat otherStat) {
        return grade.equals(otherStat.grade);
    }
}
