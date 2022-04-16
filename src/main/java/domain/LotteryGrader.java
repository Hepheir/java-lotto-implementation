package domain;

public interface LotteryGrader {
    void setWinningNumbers(LotteryTicket winningNumbers);

    void setBonusNumber(LotteryNumber bonusNumber);

    LotteryGrade grade(LotteryTicket ticket);
}
