import domain.Lotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import dto.LottoBuyingOption;


public class LottoBuyingOptionTest {
    @Test
    void buildWithoutExceptionTest() {
        LottoBuyingOption.builder()
                .budget(0)
                .lottoToCreateAutomatically(0)
                .lottoToCreateManually(0)
                .build();
    }

    @Test
    void getterTest() {
        LottoBuyingOption sample = LottoBuyingOption.builder()
                .budget(0)
                .lottoToCreateAutomatically(0)
                .lottoToCreateManually(0)
                .build();
        Assertions.assertEquals(sample.getBudget(), 0);
        Assertions.assertEquals(sample.getLottoToCreateAutomatically(), 0);
        Assertions.assertEquals(sample.getLottoToCreateManually(), 0);
    }

    @Test
    void  defaultValueOfGetLottoToCreateAutomaticallyTest() {
        LottoBuyingOption sample = LottoBuyingOption.builder()
                .budget(90 * Lotto.LOTTO_PRICE)
                .lottoToCreateManually(89)
                .build();
        Assertions.assertEquals(sample.getLottoToCreateAutomatically(), 1);
    }
}
