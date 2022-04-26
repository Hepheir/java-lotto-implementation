package domain;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class LottoGradingOptions {
    private LottoNumberSequence winningNumbers;
    private LottoNumber bonusNumber;
}
