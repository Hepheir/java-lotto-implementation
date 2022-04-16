package domain.concretes;

import domain.LotteryNumber;
import domain.LotteryTicket;
import domain.LotteryTicketBuilder;

public class ConcreteLotteryTicketBuilder implements LotteryTicketBuilder {
    private static Class<? extends LotteryTicket> concrete = ConcreteLotteryTicket.class;
    private LotteryTicket ticket;

    @Override
    public void reset() {
        try {
            ticket = (LotteryTicket) concrete.newInstance();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @Override
    public LotteryTicket build() {
        LotteryTicket builtTicket = ticket;
        reset();
        return builtTicket;
    }

    @Override
    public void addNumber(LotteryNumber number) throws IndexOutOfBoundsException {
        ticket.addNumber(number);
    }
}
