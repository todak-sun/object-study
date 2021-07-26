package io.todak.study.objectstudy.chapter01.step01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicketOffice {
    /**
     * 관람객이 극장에 입장하기 위해서는,
     * 매표소에서 초대장을 티켓으로 교환하거나 구매해야 한다.
     * <p>
     * 따라서, 매표소에는 관람객에게 판매할 티켓과, 티켓의 판매 금액이
     * 보관(상태로 관리)되어야 한다.
     */

    /**
     * 판매 금액
     */
    private Long amount;

    /**
     * 보유한 티켓의 목록
     */
    private List<Ticket> tickets = new ArrayList<>();

    public TicketOffice(Long amount, Ticket... tickets) {
        this.amount = amount;
        this.tickets.addAll(Arrays.asList(tickets));
    }

    public Ticket getTicket() {
        return tickets.remove(0);
    }

    public void minusAmount(Long amount) {
        this.amount -= amount;
    }

    public void plusAmount(Long amount) {
        this.amount += amount;
    }
}