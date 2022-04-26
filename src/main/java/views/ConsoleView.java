package views;

import io.Console;
import languages.Language;
import lombok.Builder;

import java.util.Formattable;


@Builder
public class ConsoleView implements View {
    private Console console;
    private Language language;

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
        console.printLine(message);
    }

    @Override
    public void printLine(Formattable formattable) {
        printLine(String.format("%s", formattable));
    }
}
