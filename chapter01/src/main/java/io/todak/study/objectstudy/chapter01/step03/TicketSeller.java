package io.todak.study.objectstudy.chapter01.step03;


public class TicketSeller {

    /**
     * 기존 TicketSeller는 아래와 같이 TicketOffice의 자율권을 침해하였다.
     * <p>
     * 1. TicketOffice에 있는 Ticket을 꺼낸다.
     * 2. TicketOffice에 있는 Ticket을 Audience에게 판매한다.
     * 3. Audience에게 받은 돈을 TicketOffice에 넣는다.
     */

    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public void sellTo(Audience audience) {

        /**
         * ticketSeller는 ticketOffice의 sellTicketTo 메서드를 호출함으로써
         * 원하는 목적을 달성할 수 있다.
         *
         * TicketSeller가 TicketOffice의 구현이 아닌
         * 인터페이스에만 의존해도 된다.
         */
        ticketOffice.sellTicketTo(audience);
    }

}
