package domain;

public interface Driver {
    public LotteryTicket createLotteryTicket(LotteryTicketBuilder ticketBuilder, LotteryNumberSupplier numberSupplier);

    public LotteryNumber createLotteryNumber(LotteryNumberSupplier numberSupplier);
}
