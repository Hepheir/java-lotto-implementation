package domain;

import java.util.Collection;
import java.util.LinkedList;


public class LottoTicketSequence extends LinkedList<LottoTicket> implements Cloneable, Collection<LottoTicket> {
    @Override
    public LottoTicketSequence clone() {
        return (LottoTicketSequence) super.clone();
    }
}
