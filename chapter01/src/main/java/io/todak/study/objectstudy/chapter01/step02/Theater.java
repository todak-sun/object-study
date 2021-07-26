package io.todak.study.objectstudy.chapter01.step02;


public class Theater {

    /**
     * 수정된 이후의 Theater는
     * 코드 어디에서도 ticketOffice에 접근하지 않는다.
     * <p>
     * 즉, Theater는 TicketOffice가 TicektSeller에 내부에 존재한다는
     * 사실조차 알지 못하며
     * <p>
     * 단지, ticketSeller가 sellTo 메시지를 이해하고 응답할 수 있다는 것만
     * 알고 있다.
     */
    private TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    public void enter(Audience audience) {
        ticketSeller.sellTo(audience);
    }


}
