package io.todak.study.objectstudy.chapter01.step03;

import io.todak.study.objectstudy.chapter01.step02.Invitation;
import io.todak.study.objectstudy.chapter01.step02.Ticket;

import java.util.Objects;

public class Bag {

    /**
     * Bag을 캡슐화 하여,
     * <p>
     * 다른 클래스(본 프로그램에서 Audience)를 통해
     * 직접 사용되지 않도록 변경했다.
     */

    private Long amount;
    private Invitation invitation;
    private Ticket ticket;

    public Bag(long amount) {
        this(null, amount);
    }

    public Bag(Invitation invitation, long amount) {
        this.invitation = invitation;
        this.amount = amount;
    }

    public Long hold(Ticket ticket) {
        if (hasInvitation()) {
            setTicket(ticket);
            return 0L;
        } else {
            setTicket(ticket);
            minusAmount(ticket.getFee());
            return ticket.getFee();
        }
    }

    private boolean hasInvitation() {
        return Objects.nonNull(invitation);
    }


    private void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    private void minusAmount(Long amount) {
        this.amount -= amount;
    }

}
