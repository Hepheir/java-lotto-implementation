package domain;

import java.text.DecimalFormat;
import java.util.Formattable;
import java.util.Formatter;

public enum LottoGrade implements Formattable {
    FIRST_PLACE(new Tuple("1등", 2000000000)),
    SECOND_PLACE(new Tuple("2등", 30000000)),
    THIRD_PLACE(new Tuple("3등", 1500000)),
    FOURTH_PLACE(new Tuple("4등", 50000)),
    FIFTH_PLACE(new Tuple("5등", 5000)),
    NONE(new Tuple("등수 외", 0));

    private static class Tuple {
        private final String label;
        private final Integer reward;

        private Tuple(String label, Integer reward) {
            this.label = label;
            this.reward = reward;
        }
    }

    private final Tuple data;

    public String getLabel() {
        return this.data.label;
    }

    public Integer getReward() {
        return this.data.reward;
    }

    @Override
    public void formatTo(Formatter formatter, int flags, int width, int precision) {
        formatter.format(String.format("%s (%s)", getLabel(), formatMoney(getReward())));
    }

    private String formatMoney(Integer money) {
        DecimalFormat formatter = new DecimalFormat("#,###원");
        return formatter.format(money);
    }

    private LottoGrade(Tuple data) {
        this.data = data;
    }
}
