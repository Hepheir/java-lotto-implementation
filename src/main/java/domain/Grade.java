package domain;

import utils.AnalyticsItem;

public class Grade implements AnalyticsItem {
    private final String label;
    private final Integer reward;

    public Grade(String label, Integer reward) {
        this.label = label;
        this.reward = reward;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public Integer getValue() {
        return getReward();
    }

    private Integer getReward() {
        return reward;
    }
}
