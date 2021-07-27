package io.todak.study.objectstudy.chapter02.movie.step02.pricing;

import io.todak.study.objectstudy.chapter02.money.Money;
import io.todak.study.objectstudy.chapter02.movie.step02.DiscountPolicy;
import io.todak.study.objectstudy.chapter02.movie.step02.Screening;

public class NoneDiscountPolicy implements DiscountPolicy {

    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
