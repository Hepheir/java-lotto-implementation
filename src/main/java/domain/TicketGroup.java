package domain;

import java.util.List;

public interface TicketGroup<E extends Ticket> {
    List<E> getTickets();

    void addTicket(E ticket);
}
