package io.todak.study.objectstudy.chapter02.movie.step01.pricing;

import io.todak.study.objectstudy.chapter02.money.Money;
import io.todak.study.objectstudy.chapter02.movie.step01.DiscountCondition;
import io.todak.study.objectstudy.chapter02.movie.step01.DiscountPolicy;
import io.todak.study.objectstudy.chapter02.movie.step01.Screening;

public class PercentDiscountPolicy extends DiscountPolicy {

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
