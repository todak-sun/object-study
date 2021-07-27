package io.todak.study.objectstudy.chapter02.movie.step02.pricing;

import io.todak.study.objectstudy.chapter02.money.Money;
import io.todak.study.objectstudy.chapter02.movie.step02.DiscountCondition;
import io.todak.study.objectstudy.chapter02.movie.step02.DefulatDiscountPolicy;
import io.todak.study.objectstudy.chapter02.movie.step02.Screening;

public class PercentDiscountPolicy extends DefulatDiscountPolicy {

    /**
     * 일정 비율을 차감한다.
     */

    private double percent;

    public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
        super(conditions);
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(percent);
    }
}
