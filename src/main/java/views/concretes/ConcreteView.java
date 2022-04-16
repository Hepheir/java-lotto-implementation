package views.concretes;

import languages.Language;
import views.View;

public class ConcreteView implements View {
    private static final ConcreteView view = new ConcreteView();
    private Language language;

    public static ConcreteView getInstance() {
        return view;
    }

    private ConcreteView() {
    }

    @Override
    public void setLanguage(Language language) {
        this.language = language;
    }

    @Override
    public void printEnterPurchaseAmount() {
        printLine(language.enterPurchaseAmount());
    }

    @Override
    public void printEnterNumberOfLotteryTicketsToManuallySetNumber() {
        printLine(language.enterNumberOfLotteryTicketsToManuallySetNumber());
    }

    @Override
    public void printEnterNumbersToSet() {
        printLine(language.enterNumbersToSet());
    }

    @Override
    public void printPurchaseReport(Integer manuallyCreatedCount, Integer automaticallyCreatedCount) {
        printLine(language.purchaseReport(manuallyCreatedCount, automaticallyCreatedCount));
    }

    @Override
    public void printEnterWinningNumbersOfLastWeek() {
        printLine(language.enterWinningNumbersOfLastWeek());
    }

    @Override
    public void printEnterBonusBall() {
        printLine(language.enterBonusBall());
    }

    @Override
    public void printWinningAnalytics() {
        printLine(language.winningAnalytics());
    }

    @Override
    public void printGradeAndPrizeAndQuantity(String grade, Integer prize, Integer quantity) {
        printLine(language.gradeAndPrizeAndQuantity(grade, prize, quantity));
    }

    @Override
    public void printProfitReport(Double profitRate) {
        printLine(language.profitReport(profitRate));
    }

    @Override
    public void printLine(String message) {
        System.out.println(message);
    }
}
