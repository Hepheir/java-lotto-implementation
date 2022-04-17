package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGroup implements TicketGroup<Lotto> {
    private final List<Lotto> lottos;

    public LottoGroup(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public LottoGroup() {
        this.lottos = new ArrayList<>();
    }

    @Override
    public List<Lotto> getTickets() {
        return Collections.unmodifiableList(lottos);
    }

    @Override
    public void addTicket(Lotto ticket) {
        lottos.add(ticket);
    }

    public void addTicket(LotteryTicket ticket) {
        addTicket(new Lotto(ticket));
    }
}
