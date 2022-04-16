package exception;

// TODO: Exception handling
public class LotteryException extends IllegalArgumentException {
    public LotteryException(LotteryExceptionCode code) {
        super(code.getValue());
    }
}
