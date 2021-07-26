package io.todak.study.objectstudy.chapter02.movie.step01.pricing;

import io.todak.study.objectstudy.chapter02.money.Money;
import io.todak.study.objectstudy.chapter02.movie.step01.DiscountCondition;
import io.todak.study.objectstudy.chapter02.movie.step01.DiscountPolicy;
import io.todak.study.objectstudy.chapter02.movie.step01.Screening;

public class AmountDiscountPolicy extends DiscountPolicy {

    /**
     * 할인 조건을 만족할 경우, 일정한 금액을 할인해주는 금액 할인 정책.
     */

    private Money discountAmount;

    public AmountDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
        super(conditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return discountAmount;
    }

}
