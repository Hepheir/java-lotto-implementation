package views;

import languages.Language;

public interface View {
    void setLanguage(Language language);

    void printEnterPurchaseAmount();

    void printEnterNumberOfLotteryTicketsToManuallySetNumber();

    void printEnterNumbersToSet();

    void printPurchaseReport(Integer countOfManuallyCreatedTickets, Integer countOfAutomaticallyCreatedTickets);

    void printEnterWinningNumbersOfLastWeek();

    void printEnterBonusBall();

    void printWinningAnalytics();

    void printGradeAndPrizeAndQuantity(String grade, Integer prize, Integer quantity);

    void printProfitReport(Double profitRate);

    void printLine(String message);
}
