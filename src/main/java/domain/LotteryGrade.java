package domain;

public enum LotteryGrade {
    FIRST_PLACE(new Grade("1등", 2000000000)),
    SECOND_PLACE(new Grade("2등", 30000000)),
    THIRD_PLACE(new Grade("3등", 1500000)),
    FOURTH_PLACE(new Grade("4등", 50000)),
    FIFTH_PLACE(new Grade("5등", 5000)),
    NONE(new Grade("등수 외", 0));

    private static class Grade {
        private final String title;
        private final Integer reward;

        Grade(String title, Integer reward) {
            this.title = title;
            this.reward = reward;
        }

        String getLabel() {
            return title;
        }

        Integer getReward() {
            return reward;
        }
    }

    private final Grade value;

    LotteryGrade(Grade value) {
        this.value = value;
    }

    public Grade getValue() {
        return this.value;
    }

    public String getLabel() {
        return this.value.getLabel();
    }

    public Integer getReward() {
        return this.value.getReward();
    }
}
