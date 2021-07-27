package io.todak.study.objectstudy.chapter02.movie.step02.pricing;

import io.todak.study.objectstudy.chapter02.money.Money;
import io.todak.study.objectstudy.chapter02.movie.step02.DiscountCondition;
import io.todak.study.objectstudy.chapter02.movie.step02.DefulatDiscountPolicy;
import io.todak.study.objectstudy.chapter02.movie.step02.Screening;

public class AmountDiscountPolicy extends DefulatDiscountPolicy {

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
