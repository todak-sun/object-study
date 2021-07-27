package io.todak.study.objectstudy.chapter02.movie.step01.pricing;

import io.todak.study.objectstudy.chapter02.money.Money;
import io.todak.study.objectstudy.chapter02.movie.step01.DiscountPolicy;
import io.todak.study.objectstudy.chapter02.movie.step01.Screening;

public class NoneDiscountPolicy extends DiscountPolicy {

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }

}
