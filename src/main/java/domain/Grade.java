package domain;

public class Grade {
    private final String label;
    private final Integer reward;

    public Grade(String label, Integer reward) {
        this.label = label;
        this.reward = reward;
    }

    public String getLabel() {
        return label;
    }

    private Integer getReward() {
        return reward;
    }
}
