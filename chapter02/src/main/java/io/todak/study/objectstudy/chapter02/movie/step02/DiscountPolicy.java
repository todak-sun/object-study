package io.todak.study.objectstudy.chapter02.movie.step02;

import io.todak.study.objectstudy.chapter02.money.Money;

public interface DiscountPolicy {
    
    Money calculateDiscountAmount(Screening screening);

}
