package io.todak.study.objectstudy.chapter02.movie.step01;

public interface DiscountCondition {

    /**
     * 인자로 제공된 screening이 할인이 가능한 경우 true를 반환하고
     * 할인이 불가능한 경우에는 false를 반환한다.
     */
    boolean isSatisfiedBy(Screening screening);

}
