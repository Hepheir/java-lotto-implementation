package controllers;

import domain.*;


public interface Controller {

    /**
     * 구입금액・수동・자동으로 구매할 로또 수 등을 입력받아,
     * {@code LottoBuyingOption} 객체를 반환한다.
     * <p></p>
     * <p>입출력 예시에서 해당하는 부분은 다음과 같다.</p>
     * <pre>
     * 구입금액을 입력해 주세요.
     * 7000
     * 수동으로 구매할 로또 수를 입력해 주세요.
     * 2
     * </pre>
     *
     * @return
     */
    LottoBuyingOption getLottoBuyingOption();

    /**
     * <p>입출력 예시에서 해당하는 부분은 다음과 같다.</p>
     * <pre>
     * 수동으로 구매할 번호를 입력해 주세요.
     * 1, 2, 3, 4, 5, 6
     * 3, 4, 5, 6, 7, 8
     * 수동으로 2개, 자동으로 5개를 구매했습니다.
     * [1, 2, 3, 4, 5, 6]
     * [3, 4, 5, 6, 7, 8]
     * [17, 2, 34, 8, 42, 16]
     * [21, 6, 9, 43, 28, 16]
     * [2, 20, 4, 43, 29, 30]
     * [19, 38, 25, 11, 30, 14]
     * [19, 23, 27, 11, 31, 32]
     * </pre>
     *
     * @return
     */
    LottoTicketSequence getBoughtTickets(LottoBuyingOption buyingOption);

    /**
     * <p>입출력 예시에서 해당하는 부분은 다음과 같다.</p>
     * <pre>
     * 지난 주 당첨 번호를 입력해 주세요.
     * 3, 4, 5, 6, 7, 8
     * 보너스 볼을 입력해 주세요.
     * 11
     * </pre>
     *
     * @return
     */
    LottoGradingOptions getLottoGradingOptions();

    /**
     * <p>입출력 예시에서 해당하는 부분은 다음과 같다.</p>
     * <pre>
     * 당첨 통계
     * 1등 (2,000,000,000원) - 1개
     * 2등 (30,000,000원) - 0개
     * 3등 (1,500,000원) - 0개
     * 4등 (50,000원) - 1개
     * 5등 (5,000원) - 0개
     * 등수 외 (0원) - 5개
     * 총 수익률은 28,572,142.86% 입니다.
     * </pre>
     *
     * @return
     */
    LottoWinningStatSequence getLottoWinningStats(LottoGradingOptions gradingOptions, LottoTicketSequence tickets);

    Double getProfitRate(LottoBuyingOption buyingOption, LottoWinningStatSequence winningStats);
}
