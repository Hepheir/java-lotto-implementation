package domain;

import lombok.Builder;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Builder
public class LottoGradingMachine {
    private LottoGradingOptions gradingOptions;
    private LottoTicketSequence tickets;

    public LottoGradingMachine(LottoGradingOptions gradingOptions, LottoTicketSequence tickets) {
        this.gradingOptions = gradingOptions;
        this.tickets = tickets;
    }

    public LottoGradeSequence gradeAll() {
        Collection<LottoGrade> grades = gradeEach();
        LottoGradeSequence gradeSequence = new LottoGradeSequence();
        gradeSequence.addAll(grades);
        return gradeSequence;
    }

    private Collection<LottoGrade> gradeEach() {
        return tickets.stream()
                .map(this::gradeOne)
                .collect(Collectors.toList());
    }

    private LottoGrade gradeOne(LottoTicket ticket) {
        LottoNumberSequence hits = ticket.getNumbers().clone();
        hits.retainAll(gradingOptions.getWinningNumbers());

        Integer wins = hits.size();
        Boolean winBonus = hits.contains(gradingOptions.getBonusNumber());

        return gradeOneWithDetails(wins, winBonus);
    }

    private LottoGrade gradeOneWithDetails(Integer wins, Boolean winBonus) {
        if (wins == 6) {
            return LottoGrade.FIRST_PLACE;
        }
        if (wins == 5 && winBonus) {
            return LottoGrade.SECOND_PLACE;
        }
        if (wins == 5) {
            return LottoGrade.THIRD_PLACE;
        }
        if (wins == 4) {
            return LottoGrade.FOURTH_PLACE;
        }
        if (wins == 3) {
            return LottoGrade.FIFTH_PLACE;
        }
        return LottoGrade.NONE;
    }
}
