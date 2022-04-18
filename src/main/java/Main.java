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
import domain.Lotto;
import domain.LottoGroup;
import domain.TicketGroup;
import domain.concretes.AutoLotteryNumberSupplier;
import domain.concretes.ConcreteDriver;
import domain.concretes.ConcreteLotteryGrader;
import domain.concretes.ConcreteLotteryTicketBuilder;
import domain.concretes.ManualLotteryNumberSupplier;
import domain.enums.LotteryGrade;
import languages.Korean;
import utils.Analytics;
import utils.concretes.ConcreteAnalytics;
import views.View;
import views.concretes.ConcreteView;

public class Main {
    private static Controller controller = ConcreteController.getInstance();
    private static View view = ConcreteView.getInstance();
    private static Driver driver = new ConcreteDriver();
    private static LotteryTicketBuilder ticketBuilder = new ConcreteLotteryTicketBuilder();
    private static LotteryNumberSupplier manualNumberSupplier = new ManualLotteryNumberSupplier();
    private static LotteryNumberSupplier autoNumberSupplier = new AutoLotteryNumberSupplier();
    private static Analytics<Grade> analytics = new ConcreteAnalytics<>();
    private static TicketGroup<Lotto> ticketGroup = new LottoGroup();
    private static LotteryGrader grader = new ConcreteLotteryGrader();

    static {
        view.setLanguage(new Korean());
    }

    public static void main(String[] args) {
        view.printEnterPurchaseAmount();
        Integer money = controller.readInteger();
        Integer countOfBuyableTickets = money / LotteryTicket.PRICE;

        view.printEnterNumberOfLotteryTicketsToManuallySetNumber();
        Integer countOfManuallyCreatedTickets = controller.readInteger();
        Integer countOfAutomaticallyCreatedTickets = countOfBuyableTickets - countOfManuallyCreatedTickets;

        view.printEnterNumbersToSet();
        for (int i = 0; i < countOfManuallyCreatedTickets; i++) {
            ticketGroup.addTicket(new Lotto(driver.createLotteryTicket(ticketBuilder, manualNumberSupplier)));
        }
        for (int i = 0; i < countOfAutomaticallyCreatedTickets; i++) {
            ticketGroup.addTicket(new Lotto(driver.createLotteryTicket(ticketBuilder, autoNumberSupplier)));
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
                .forEach(grade -> Main.printGradeAndPrizeAndQuantity(view, grade, analytics));

        view.printProfitReport(analytics.getTotalValue().doubleValue() / money.doubleValue());
    }

    private static void printGradeAndPrizeAndQuantity(View view, Grade grade, Analytics<Grade> analytics) {
        view.printGradeAndPrizeAndQuantity(grade.getLabel(), grade.getValue(), analytics.getQuantity(grade));
    }
}
