package io.todak.study.objectstudy.chapter02.movie.step01;

import io.todak.study.objectstudy.chapter02.money.Money;

import java.time.Duration;

public class Movie {

    private String title;
    private Duration runningTime;
    private Money fee;
    private DiscountPolicy discountPolicy;

    public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    public Money getFee() {
        return fee;
    }

    public Money calculateMovieFee(Screening screening) {
        /**
         * discountPolicy에 calculateDiscountAmount 메시지를 전송해
         * 할인 요금을 반환 받는다.
         *
         * Moview는 기본 요금인 fee에서 반환된 할인 요금을 차감한다.
         */
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }

}
