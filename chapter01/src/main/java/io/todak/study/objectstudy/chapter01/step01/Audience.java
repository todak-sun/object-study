package io.todak.study.objectstudy.chapter01.step01;

public class Audience {

    /**
     * 관람객 구현
     */

    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    public Bag getBag() {
        return bag;
    }
}
