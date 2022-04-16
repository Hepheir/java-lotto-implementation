import java.util.Arrays;

import controllers.Controller;
import controllers.concretes.ConcreteController;
import domain.Driver;
import domain.Grade;
import domain.LotteryGrader;
import domain.LotteryNumber;
import domain.LotteryNumberSupplier;
import domain.LotteryTicket;
import domain.LotteryTicketBuilder;
import domain.TicketGroup;
import domain.concretes.AutoLotteryNumberSupplier;
import domain.concretes.ConcreteDriver;
import domain.concretes.ConcreteLotteryGrader;
import domain.concretes.ConcreteLotteryTicketBuilder;
import domain.concretes.ConcreteTicketGroup;
import domain.concretes.ManualLotteryNumberSupplier;
import domain.enums.LotteryGrade;
import languages.Korean;
import utils.Analytics;
import utils.concretes.ConcreteAnalytics;
import views.View;
import views.concretes.ConcreteView;

public class Main {
    public static void main(String[] args) {
        Controller controller = ConcreteController.getInstance();
        View view = ConcreteView.getInstance();
        Driver driver = new ConcreteDriver();
        LotteryTicketBuilder ticketBuilder = new ConcreteLotteryTicketBuilder();
        LotteryNumberSupplier manualNumberSupplier = new ManualLotteryNumberSupplier();
        LotteryNumberSupplier autoNumberSupplier = new AutoLotteryNumberSupplier();
        Analytics<Grade> analytics = new ConcreteAnalytics<>();
        TicketGroup<LotteryTicket> ticketGroup = new ConcreteTicketGroup<>();
        LotteryGrader grader = new ConcreteLotteryGrader();
        view.setLanguage(new Korean());

        view.printEnterPurchaseAmount();
        Integer money = controller.readInteger();
        Integer countOfBuyableTickets = money / LotteryTicket.PRICE;

        view.printEnterNumberOfLotteryTicketsToManuallySetNumber();
        Integer countOfManuallyCreatedTickets = controller.readInteger();
        Integer countOfAutomaticallyCreatedTickets = countOfBuyableTickets - countOfManuallyCreatedTickets;

        view.printEnterNumbersToSet();
        for (int i = 0; i < countOfManuallyCreatedTickets; i++) {
            ticketGroup.addTicket(driver.createLotteryTicket(ticketBuilder, manualNumberSupplier));
        }
        for (int i = 0; i < countOfAutomaticallyCreatedTickets; i++) {
            ticketGroup.addTicket(driver.createLotteryTicket(ticketBuilder, autoNumberSupplier));
        }
        view.printPurchaseReport(countOfManuallyCreatedTickets, countOfAutomaticallyCreatedTickets);
        ticketGroup.getTickets().stream().map(LotteryTicket::toString).forEach(view::printLine);

        view.printEnterWinningNumbersOfLastWeek();
        LotteryTicket winningNumbers = driver.createLotteryTicket(ticketBuilder, manualNumberSupplier);

        view.printEnterBonusBall();
        LotteryNumber bonusNumber = driver.createLotteryNumber(manualNumberSupplier);

        grader.setWinningNumbers(winningNumbers);
        grader.setBonusNumber(bonusNumber);

        view.printWinningAnalytics();
        ticketGroup.getTickets().stream()
                .map(grader::grade)
                .map(LotteryGrade::getValue)
                .forEach(analytics::add);

        Arrays.asList(LotteryGrade.values()).stream()
                .map(LotteryGrade::getValue)
                .forEach(grade -> view.printGradeAndPrizeAndQuantity(
                        analytics.getLabel(grade),
                        analytics.getValue(grade),
                        analytics.getQuantity(grade)));

        view.printProfitReport(analytics.getTotalValue().doubleValue() / money.doubleValue());
    }
}
