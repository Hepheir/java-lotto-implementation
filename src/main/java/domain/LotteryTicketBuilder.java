package domain;

public interface LotteryTicketBuilder extends Builder<LotteryTicket> {
    /**
     * 체인으로 사용할 수 있도록 함.
     */
    void addNumber(LotteryNumber number) throws IndexOutOfBoundsException;
}
