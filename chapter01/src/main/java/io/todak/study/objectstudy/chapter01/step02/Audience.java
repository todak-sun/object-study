package io.todak.study.objectstudy.chapter01.step02;


public class Audience {

    /**
     * 개선된 코드에서 Audience는
     * 자신의 가방 안에 초대장이 들어있는지를 스스로 확인한다.
     * <p>
     * 외부의 객체가 bag을 확인하도록 허용하지 않는다.
     * <p>
     * Audience가 bag을 직접 처리하기 때문에,
     * 외부에서는 더이상 Audience가 Bag을 소유하고 있다는 사실을 알 필요가 없다.
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
        if (bag.hasInvitation()) {
            bag.setTicket(ticket);
            return 0L;
        } else {
            bag.setTicket(ticket);
            bag.minusAmount(ticket.getFee());
            return ticket.getFee();
        }
    }


}
