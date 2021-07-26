package io.todak.study.objectstudy.chapter01.step01;

public class Theater {

    private TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    public void enter(Audience audience) {
        if (audience.getBag().hasInvitation()) {
            /**
             * 관객이 초대장을 가지고 있는 경우
             */
            Ticket ticket = ticketSeller.getTicketOffice().getTicket(); // 1
            audience.getBag().setTicket(ticket); // 2

            /**
             * 1. 판매원이 매표소에서 ticket을 하나 가져온다.
             * 2. 관람객은 가방에, 위에서 꺼내온 ticket을 보관한다
             */

        } else {
            /**
             * 관객이 초대장을 가지고 있지 않은 경우
             */
            Ticket ticket = ticketSeller.getTicketOffice().getTicket(); //1
            audience.getBag().minusAmount(ticket.getFee());
            ticketSeller.getTicketOffice().plusAmount(ticket.getFee());
            audience.getBag().setTicket(ticket);

            /**
             * 1. 판매원이 매표소에서 ticket을 하나 가져온다.
             * 2. 관람객의 가방에 담긴 현금은 ticket요금 만큼 줄어든다.
             * 3. 판매원은 매표소의 판매 금액을 ticket의 요금 만큼 증가시켜준다.
             * 4. 관객은 ticket을 보유하게 된다.
             */

        }
    }

}
