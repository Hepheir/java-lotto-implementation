package domain.enums;

import utils.Analytics;

public enum LotteryGrade implements Analytics.AnalyticsItem {
    FIRST_PLACE(new LotteryGrade.Grade("1등", 2000000000)),
    SECOND_PLACE(new LotteryGrade.Grade("2등", 30000000)),
    THIRD_PLACE(new LotteryGrade.Grade("3등", 1500000)),
    FOURTH_PLACE(new LotteryGrade.Grade("4등", 50000)),
    FIFTH_PLACE(new LotteryGrade.Grade("5등", 5000)),
    NONE(new LotteryGrade.Grade("등수 외", 0));

    private static class Grade {
        private final String label;
        private final Integer reward;

        private Grade(String label, Integer reward) {
            this.label = label;
            this.reward = reward;
        }
    }

    private final Grade value;

    LotteryGrade(Grade value) {
        this.value = value;
    }

    @Override
    public String getLabel() {
        return this.value.label;
    }

    @Override
    public Integer getValue() {
        return this.value.reward;
    }
}
