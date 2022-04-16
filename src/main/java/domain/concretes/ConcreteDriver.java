package domain.concretes;

import domain.Driver;
import domain.LotteryNumber;
import domain.LotteryNumberSupplier;
import domain.LotteryTicket;
import domain.LotteryTicketBuilder;

public class ConcreteDriver implements Driver {

    @Override
    public LotteryTicket createLotteryTicket(LotteryTicketBuilder ticketBuilder, LotteryNumberSupplier numberSupplier) {
        numberSupplier.restore();
        ticketBuilder.reset();
        for (int i = 0; i < LotteryTicket.QUANTITY_OF_NUMBERS; i++) {
            ticketBuilder.addNumber(numberSupplier.next());
        }
        return ticketBuilder.build();
    }

    @Override
    public LotteryNumber createLotteryNumber(LotteryNumberSupplier numberSupplier) {
        numberSupplier.restore();
        return numberSupplier.next();
    }
}
