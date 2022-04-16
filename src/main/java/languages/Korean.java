package languages;

import java.text.DecimalFormat;

public class Korean implements Language {
    private static final String MESSAGE_ENTER_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String MESSAGE_ENTER_NUMBER_OF_LOTTERY_TICKETS_TO_MANUALLY_SET_NUMBER = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MESSAGE_ENTER_NUMBERS_TO_SET = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String FORMAT_PURCHASE_REPORT = "수동으로%d개, 자동으로 %d개를 구매했습니다.";
    private static final String MESSAGE_ENTER_WINNING_NUMBERS_OF_LAST_WEEK = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String MESSAGE_ENTER_BONUS_BALL = "보너스 볼을 입력해 주세요.";
    private static final String MESSAGE_WINNING_ANALYTICS = "당첨 통계";
    private static final String FORMAT_GRADE_N_PRIZE_N_QUANTITY = "%s (%s원) - %d개";
    private static final String FORMAT_PROFIT_REPORT = "총 수익률은 %s%% 입니다.";
    private static final Integer PERCENTAGE_MULTIPLIER = 100;

    @Override
    public String enterPurchaseAmount() {
        return MESSAGE_ENTER_PURCHASE_AMOUNT;
    }

    @Override
    public String enterNumberOfLotteryTicketsToManuallySetNumber() {
        return MESSAGE_ENTER_NUMBER_OF_LOTTERY_TICKETS_TO_MANUALLY_SET_NUMBER;
    }

    @Override
    public String enterNumbersToSet() {
        return MESSAGE_ENTER_NUMBERS_TO_SET;
    }

    @Override
    public String purchaseReport(Integer manuallyCreatedCount, Integer automaticallyCreatedCount) {
        return String.format(FORMAT_PURCHASE_REPORT, manuallyCreatedCount, automaticallyCreatedCount);
    }

    @Override
    public String enterWinningNumbersOfLastWeek() {
        return MESSAGE_ENTER_WINNING_NUMBERS_OF_LAST_WEEK;
    }

    @Override
    public String enterBonusBall() {
        return MESSAGE_ENTER_BONUS_BALL;
    }

    @Override
    public String winningAnalytics() {
        return MESSAGE_WINNING_ANALYTICS;
    }

    @Override
    public String gradeAndPrizeAndQuantity(String grade, Integer prize, Integer quantity) {
        DecimalFormat formatter = new DecimalFormat("#,###");
        return String.format(FORMAT_GRADE_N_PRIZE_N_QUANTITY, grade, formatter.format(prize), quantity);
    }

    @Override
    public String profitReport(Double profitRate) {
        DecimalFormat formatter = new DecimalFormat("#,###.00");
        return String.format(FORMAT_PROFIT_REPORT, formatter.format(percentagefy(profitRate)));
    }

    /**
     * 0~1 을 0%~100% 로 보정
     */
    private Double percentagefy(Double rate) {
        return rate * PERCENTAGE_MULTIPLIER;
    }
}
