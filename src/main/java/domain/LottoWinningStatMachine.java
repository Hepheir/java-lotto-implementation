package domain;


import lombok.Builder;

import java.util.Collection;
import java.util.stream.Collectors;

@Builder
public class LottoWinningStatMachine {
    private LottoGradeSequence grades;

    public LottoWinningStatSequence statAll() {
        Collection<LottoWinningStat> stats = statEach();
        LottoWinningStatSequence statSequence = new LottoWinningStatSequence();
        statSequence.addAll(stats);
        return statSequence;
    }

    private Collection<LottoWinningStat> statEach() {
        return grades.stream()
                .map(this::statOne)
                .collect(Collectors.toSet());
    }

    private LottoWinningStat statOne(LottoGrade grade) {
        return LottoWinningStat.builder()
                .grade(grade)
                .quantity(1)
                .build();
    }
}
