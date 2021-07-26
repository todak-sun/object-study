package io.todak.study.objectstudy.chapter01.step03;


import io.todak.study.objectstudy.chapter01.step02.Ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketOffice {

    /**
     * TicketOffice는 자율적인 존재가 되었으며,
     * TicketSeller의 통제를 더이상 받지 않는다.
     * <p>
     * 그러나, sellTicketTo를 구현하며
     * <p>
     * 그 전에 존재하지 않던 Audience와의 의존성이 추가되었다.
     * TicketOffice는 Audience에 관해 알고 있어야 한다.
     */

    private Long amount;
    private List<Ticket> tickets = new ArrayList<>();


    public void sellTicketTo(Audience audience) {
        plusAmount(audience.buy(getTicket()));
    }

    private Ticket getTicket() {
        return tickets.remove(0);
    }

    private void plusAmount(Long amount) {
        this.amount += amount;
    }
}
