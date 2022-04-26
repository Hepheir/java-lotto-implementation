package domain;

import domain.lot.ConsoleDrawingLot;
import domain.lot.RandomDrawingLot;
import io.Console;
import lombok.Builder;
import types.Drawable;


@Builder
public class LottoBuyingMachine {
    @Builder.Default
    private LottoTicketSequence tickets = new LottoTicketSequence();
    private LottoBuyingOption options;
    private Console console;

    public void buy() {
        buyManyManually(options.getManual());
        buyManyAutomatically(options.getAuto());
    }

    public LottoTicketSequence getTickets() {
        return tickets.clone();
    }

    private void buyManyManually(Integer amount) {
        while (amount > 0) {
            buyOneManually();
            amount--;
        }
    }

    private void buyManyAutomatically(Integer amount) {
        while (amount > 0) {
            buyOneAutomatically();
            amount--;
        }
    }

    private void buyOneManually() {
        buyOneUsingDrawer(new ConsoleDrawingLot(console));
    }

    private void buyOneAutomatically() {
        buyOneUsingDrawer(new RandomDrawingLot(LottoNumber.MIN_VALUE, LottoNumber.MAX_VALUE));
    }

    private void buyOneUsingDrawer(Drawable<Integer> drawer) {
        LottoNumberSequence numberSequence = getNumberSequence(drawer);
        LottoTicket ticket = new LottoTicket(numberSequence);
        registerBoughtLotto(ticket);
    }

    private LottoNumberSequence getNumberSequence(Drawable<Integer> drawer) {
        LottoNumberSequence numberSequence = new LottoNumberSequence(LottoTicket.QUANTITY_OF_NUMBERS);
        while (!numberSequence.isFull()) {
            Integer rawNumber = drawer.draw();
            numberSequence.add(LottoNumber.of(rawNumber));
            // 메소드 중첩?도 들여쓰기 레벨처럼 뭔가... 지켜야하지 않을까
        }
        return numberSequence;
    }

    private void registerBoughtLotto(LottoTicket newLotto) {
        tickets.add(newLotto);
    }
}
