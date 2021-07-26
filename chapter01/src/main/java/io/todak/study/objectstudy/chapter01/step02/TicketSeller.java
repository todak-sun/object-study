package io.todak.study.objectstudy.chapter01.step02;


public class TicketSeller {

    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public void sellTo(Audience audience) {
        ticketOffice.plusAmount(audience.buy(ticketOffice.getTicket()));
    }


    /**
     * getTicketOffice()를 제거
     * ticketOffice에 대한 접근은 오직 TicketSeller를 통해서만 가능하다.
     *
     * 따라서, ticketSessler는 ticketOffice에서
     * 티켓을 꺼내거나 판매 요금을 적립하는 일을 스스로 수행할 수 밖에 없다.
     *
     * => 캡슐화(encapsulation)
     */

}
