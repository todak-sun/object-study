package io.todak.study.objectstudy.chapter01.step01;

public class TicketSeller {

    /**
     * 판매원은 다음 두 가지의 역할을 수행한다.
     * 1. 초대장을 티켓으로 교환
     * 2. 티켓을 판매
     */

    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public TicketOffice getTicketOffice() {
        return ticketOffice;
    }
}
