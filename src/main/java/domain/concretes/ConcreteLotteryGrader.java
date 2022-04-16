package domain.concretes;

import java.util.HashSet;
import java.util.Set;

import domain.LotteryGrader;
import domain.LotteryNumber;
import domain.LotteryTicket;
import domain.enums.LotteryGrade;

public class ConcreteLotteryGrader implements LotteryGrader {
    private LotteryTicket winningNumbers;
    private LotteryNumber bonusNumber;

    @Override
    public void setWinningNumbers(LotteryTicket winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    @Override
    public void setBonusNumber(LotteryNumber bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    @Override
    public LotteryGrade grade(LotteryTicket ticket) {
        Set<LotteryNumber> intersection = new HashSet<>(ticket.numbers());
        intersection.retainAll(winningNumbers.numbers());
        return grade(intersection.size(), ticket.numbers().contains(bonusNumber));
    }

    /**
     * 당첨 번호와 일치하는 숫자의 개수와, 보너스 볼을 맞췄는지 입력받아 해당하는 등수를 반환.
     *
     * @param winningCount 맞춘 당첨 번호의 개수 (보너스 볼 미포함)
     * @param isWinBonus   보너스 볼을 맞추었는지 여부
     * @return 등수
     */
    private LotteryGrade grade(Integer winningCount, Boolean isWinBonus) {
        if (winningCount == 6) {
            return LotteryGrade.FIRST_PLACE;
        }
        if (winningCount == 5 && isWinBonus) {
            return LotteryGrade.SECOND_PLACE;
        }
        if (winningCount == 5) {
            return LotteryGrade.THIRD_PLACE;
        }
        if (winningCount == 4) {
            return LotteryGrade.FOURTH_PLACE;
        }
        if (winningCount == 3) {
            return LotteryGrade.FIFTH_PLACE;
        }
        return LotteryGrade.NONE;
    }
}
