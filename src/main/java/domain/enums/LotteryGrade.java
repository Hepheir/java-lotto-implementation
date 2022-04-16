package domain.enums;

import domain.Grade;

public enum LotteryGrade {
    FIRST_PLACE(new Grade("1등", 2000000000)),
    SECOND_PLACE(new Grade("2등", 30000000)),
    THIRD_PLACE(new Grade("3등", 1500000)),
    FOURTH_PLACE(new Grade("4등", 50000)),
    FIFTH_PLACE(new Grade("5등", 5000)),
    NONE(new Grade("등수 외", 0));

    private final Grade value;

    LotteryGrade(Grade value) {
        this.value = value;
    }

    public Grade getValue() {
        return this.value;
    }
}
