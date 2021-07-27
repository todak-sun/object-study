package io.todak.study.objectstudy.chapter02.movie.step01;

import io.todak.study.objectstudy.chapter02.money.Money;
import io.todak.study.objectstudy.chapter02.movie.step01.pricing.*;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

class MovieTest {


    @Test
    void avatar_test() {

        /**
         * Movie 클래스는 DiscountPolicy 클래스(추상 클래스)와 연결 되어 있다.
         * 하지만, 영화 요금을 계산하기 위해서는 추상 클래스가 아니라,
         * AmountDiscountPolicy, PercentDiscountPolicy의 인스턴스가 필요하다.
         *
         * 코드 수준에서의 Movie는 이 중 어떤 것에도 의존하고 있지만,
         * 인스턴스를 생성할 때 비로소 둘 중 어느것 하나에게 의존할 수 있게된다.
         *
         * => 코드의 의존성과, 실행 시점의 의존성은 서로 다르다.
         */
        Movie avatar = new Movie("아바타",
                Duration.ofMinutes(120),
                Money.wons(10000),
                new AmountDiscountPolicy(
                        Money.wons(800),
                        new SequenceCondition(1),
                        new SequenceCondition(10),
                        new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
                        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(20, 59))));

        Screening screening = new Screening(avatar, 10, LocalDateTime.now());

        Money money = avatar.calculateMovieFee(screening);

        System.out.println(money);

    }

    @Test
    void titanic_test() {
        Movie titanic = new Movie("타이타닉",
                Duration.ofMinutes(180),
                Money.wons(11000),
                new PercentDiscountPolicy(0.1,
                        new PeriodCondition(DayOfWeek.TUESDAY, LocalTime.of(14, 0), LocalTime.of(16, 59)),
                        new SequenceCondition(2),
                        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(13, 59))
                ));
    }

    @Test
    void start_wars_test() {
        Movie startWars = new Movie("스타워즈",
                Duration.ofMinutes(120),
                Money.wons(10000),
                new NoneDiscountPolicy());
    }

}