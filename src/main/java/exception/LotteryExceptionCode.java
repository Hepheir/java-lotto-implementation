package exception;

// TODO: Exception handling
public enum LotteryExceptionCode {
    NUMBER_NOT_IN_RANGE("올바른 범위의 숫자가 아닙니다"),
    NUMBER_QUANTITY_LACK("숫자의 개수가 모자랍니다");

    private final String value;

    LotteryExceptionCode(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
