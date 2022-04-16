package domain;

import domain.enums.LotteryGrade;

public interface LotteryGrader {
    void setWinningNumbers(LotteryTicket winningNumbers);

    void setBonusNumber(LotteryNumber bonusNumber);

    LotteryGrade grade(LotteryTicket ticket);
}
