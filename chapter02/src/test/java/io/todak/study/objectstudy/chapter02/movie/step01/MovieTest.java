package io.todak.study.objectstudy.chapter02.movie.step01;

import io.todak.study.objectstudy.chapter02.money.Money;
import io.todak.study.objectstudy.chapter02.movie.step01.pricing.AmountDiscountPolicy;
import io.todak.study.objectstudy.chapter02.movie.step01.pricing.PercentDiscountPolicy;
import io.todak.study.objectstudy.chapter02.movie.step01.pricing.PeriodCondition;
import io.todak.study.objectstudy.chapter02.movie.step01.pricing.SequenceCondition;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

class MovieTest {


    @Test
    void avatar_test() {
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

}