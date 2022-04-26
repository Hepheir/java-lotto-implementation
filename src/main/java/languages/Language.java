package languages;

public interface Language {
    String enterPurchaseAmount();

    String enterNumberOfLotteryTicketsToManuallySetNumber();

    String enterNumbersToSet();

    String purchaseReport(Integer manuallyCreatedCount, Integer automaticallyCreatedCount);

    String enterWinningNumbersOfLastWeek();

    String enterBonusBall();

    String winningAnalytics();

    String gradeAndPrizeAndQuantity(String grade, Integer prize, Integer quantity);

    String profitReport(Double profitRate);
}
