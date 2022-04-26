package controllers;

import domain.*;
import domain.LottoBuyingOption;
import domain.LottoGradingOptions;
import io.Console;
import lombok.Builder;
import views.View;

import java.text.DecimalFormat;


@Builder
public class ConsoleController implements Controller {
    private static final Integer PERCENTAGE_MULTIPLIER = 100;
    private static final String LOTTO_NUMBER_DELIMITER = ", ";

    private Console console;
    private View view;

    @Override
    public LottoBuyingOption getLottoBuyingOption() {
        view.printEnterPurchaseAmount();
        Integer budget = readInt();

        view.printEnterNumberOfLotteryTicketsToManuallySetNumber();
        Integer toCreateManually = readInt();
        Integer toCreateAutomatically = (budget / LottoTicket.LOTTO_PRICE) - toCreateManually;

        return LottoBuyingOption
                .builder()
                .budget(budget)
                .manual(toCreateManually)
                .auto(toCreateAutomatically)
                .build();
    }

    @Override
    public LottoTicketSequence getBoughtTickets(LottoBuyingOption buyingOption) {
        view.printEnterNumbersToSet();

        final LottoBuyingMachine buyingMachine = LottoBuyingMachine.builder()
                .options(buyingOption)
                .console(console)
                .build();
        buyingMachine.buy();

        final LottoTicketSequence boughtTickets = buyingMachine.getTickets();

        view.printLine(buyingOption);
        for (LottoTicket boughtTicket : boughtTickets) {
            view.printLine(boughtTicket);
        }
        return boughtTickets;
    }

    @Override
    public LottoGradingOptions getLottoGradingOptions() {
        final LottoBuyingOption option = LottoBuyingOption.builder()
                .manual(1)
                .build();
        final LottoBuyingMachine buyingMachine = LottoBuyingMachine.builder()
                .options(option)
                .console(console)
                .build();

        view.printEnterWinningNumbersOfLastWeek();
        buyingMachine.buy();
        final LottoNumberSequence winningNumbers = buyingMachine.getTickets().peek().getNumbers();

        view.printEnterBonusBall();
        final LottoNumber bonusNumber = LottoNumber.of(readInt());

        return LottoGradingOptions.builder()
                .winningNumbers(winningNumbers)
                .bonusNumber(bonusNumber)
                .build();
    }

    @Override
    public LottoWinningStatSequence getLottoWinningStats(LottoGradingOptions gradingOptions, LottoTicketSequence tickets) {
        final LottoGradingMachine gradingMachine = LottoGradingMachine.builder()
                .gradingOptions(gradingOptions)
                .tickets(tickets)
                .build();
        final LottoGradeSequence grades = gradingMachine.gradeAll();
        final LottoWinningStatMachine winningStatMachine = LottoWinningStatMachine.builder()
                .grades(grades)
                .build();
        final LottoWinningStatSequence winningStats = winningStatMachine.statAll();

        view.printWinningAnalytics();
        for (LottoWinningStat winningStat : winningStats) {
            view.printLine(winningStat);
        }
        return winningStats;
    }

    @Override
    public Double getProfitRate(LottoBuyingOption buyingOption, LottoWinningStatSequence winningStats) {
        Integer totalProfit = 0;
        for (LottoWinningStat winningStat : winningStats) {
            totalProfit += winningStat.getGrade().getReward() * winningStat.getQuantity();
        }
        final Double profitRate = totalProfit.doubleValue() / buyingOption.getBudget().doubleValue();

        final DecimalFormat formatter = new DecimalFormat("#,###.00");
        final String formattedPercentageRate = formatter.format(asPercentage(profitRate));
        final String formattedTotalProfitRate = String.format("총 수익률은 %s%% 입니다.", formattedPercentageRate);
        view.printLine(formattedTotalProfitRate);

        return profitRate;
    }


    private String readLine() {
        return console.readLine();
    }

    private Integer readInt() {
        return Integer.parseInt(readLine());
    }

    private Double asPercentage(Double rate) {
        return rate * PERCENTAGE_MULTIPLIER;
    }
}
