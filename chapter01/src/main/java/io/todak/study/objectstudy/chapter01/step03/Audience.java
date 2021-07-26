package io.todak.study.objectstudy.chapter01.step03;


import io.todak.study.objectstudy.chapter01.step02.Ticket;

public class Audience {

    /**
     * 한번 더 개선된 코드에서
     * Audience는 Bag을 직접 통제할 수 없다.
     * <p>
     * Bag은 이미 자율적인 객체로
     * Audience는 bag과 메시지를 주고 받는다.
     */

    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    /**
     * 인자로 전달받은 Ticket을 가방에 넣은 후,
     * 지불된 금액을 반환한다.
     */
    public Long buy(Ticket ticket) {
        return bag.hold(ticket);
    }


}
