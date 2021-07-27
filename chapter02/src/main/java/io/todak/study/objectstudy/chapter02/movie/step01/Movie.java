package io.todak.study.objectstudy.chapter02.movie.step01;

import io.todak.study.objectstudy.chapter02.money.Money;

import java.time.Duration;

public class Movie {

    private String title;
    private Duration runningTime;
    private Money fee;
    private DiscountPolicy discountPolicy;

    public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
        /**
         * 하나의 영화에 대해, 단 하나의 할인 정책만 설정할 수 있다.
         * 그러나, 할인 조건의 경우에는 여러 개를 적용할 수 있다.
         *
         * Movie와 DiscountPolicy의 생성자는 각각 이런 제약을 강제한다.
         */
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
