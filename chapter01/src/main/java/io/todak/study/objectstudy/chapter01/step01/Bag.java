package io.todak.study.objectstudy.chapter01.step01;

import java.util.Objects;

public class Bag {

    /**
     * 1. 이벤트 당첨자 => 티켓으로 교환할 초대장 소지.
     * 2. 이벤트 미당첨자 => 티켓을 구매할 현금 소지
     * 3. 이벤트 당첨자/미당첨자 모두, 티켓을 보유할 수 있게됨
     * <p>
     * 따라서, 가방(Bag)에는 세가지 필드가 존재한다.
     */

    private Long amount;
    private Invitation invitation;
    private Ticket ticket;

    /**
     * Bag의 인스턴스가 생성되는 시점에는
     * 위 설명과 같이, 현금만 있거나 또는 초대장과 현금 모두가 있는
     * 두 가지 경우만 존재한다.
     * <p>
     * 이를 생성자로 제약한다.
     */

    public Bag(long amount) {
        this(null, amount);
    }

    public Bag(Invitation invitation, long amount) {
        this.invitation = invitation;
        this.amount = amount;
    }

    /**
     * 초대장 소지여부
     */
    public boolean hasInvitation() {
        return Objects.nonNull(invitation);
    }

    /**
     * 티켓 소지여부
     */
    public boolean hasTicket() {
        return Objects.nonNull(ticket);
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    /**
     * 보유한 현금을 감소
     */
    public void minusAmount(Long amount) {
        this.amount -= amount;
    }

    /**
     * 보유한 현금을 증가
     */
    public void plusAmount(Long amount) {
        this.amount += amount;
    }


}
