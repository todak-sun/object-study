package io.todak.study.objectstudy.chapter02.movie.step02;

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

    public void changeDiscountPolicy(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    public Money calculateMovieFee(Screening screening) {

        /**
         * 할인 정책이 설정되어 있지 않다면,
         * 영화에 설정된 기본 요금을 부과하도록 처리하는 조건문.
         *
         * 하지만, 할인 정책이 없는 경우를 예외 케이스로 취급하기에
         * 지금까지 일관성 있게 유지되던 협력의 방식이 무너진다.
         *
         * => 할인 금액이 0원이라는 사실을 결정하는 책임이
         * DiscountPolicy가 아니라, Movie로 이동했기 때문 => NoneDiscountPolicy 추가로 해결
         */
//        if (discountPolicy == null) {
//            return fee;
//        }


        /**
         * discountPolicy에 calculateDiscountAmount 메시지를 전송해
         * 할인 요금을 반환 받는다.
         *
         * Moview는 기본 요금인 fee에서 반환된 할인 요금을 차감한다.
         */
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }

}
