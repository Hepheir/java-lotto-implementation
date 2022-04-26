package domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Formattable;
import java.util.Formatter;

@Builder
@Getter
@Setter
public class LottoBuyingOption implements Formattable {
    @Builder.Default
    private Integer budget = 0;
    @Builder.Default
    private Integer auto = 0;
    @Builder.Default
    private Integer manual = 0;


    @Override
    public void formatTo(Formatter formatter, int flags, int width, int precision) {
        formatter.format("수동으로 %d개, 자동으로 %d개를 구매했습니다.", manual, auto);
    }
}
