package domain;

public interface LotteryTicketBuilder extends Builder<LotteryTicket> {
    void addNumber(LotteryNumber number) throws IndexOutOfBoundsException;
}
