package domain.concretes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import domain.Ticket;
import domain.TicketGroup;

public class ConcreteTicketGroup<T extends Ticket> implements TicketGroup<T> {
    private final List<T> items = new ArrayList<>();

    @Override
    public List<T> getTickets() {
        return Collections.unmodifiableList(items);
    }

    @Override
    public void addTicket(T ticket) {
        items.add(ticket);
    }

}
