package io.todak.study.objectstudy.chapter02.movie.step02;

import io.todak.study.objectstudy.chapter02.money.Money;
import io.todak.study.objectstudy.chapter02.movie.step02.pricing.*;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTest {

    @Test
    void star_wars_test() {
        new Movie("스타워즈",
                Duration.ofMinutes(120),
                Money.wons(12000),
                new NoneDiscountPolicy());
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
    void change_discount_policy() {
        //given
        Movie startWards = new Movie("스타워즈",
                Duration.ofMinutes(120),
                Money.wons(12000),
                new NoneDiscountPolicy());

        //when
        Screening beforeScreening = new Screening(startWards, 1, LocalDateTime.now());
        Money beforeMoney = startWards.calculateMovieFee(beforeScreening);

        //then
        assertEquals(beforeMoney, Money.wons(12000)); // NoneDiscountPolicy 이므로, 영화 금액과 같음.


        //given
        startWards.changeDiscountPolicy(new AmountDiscountPolicy(Money.wons(2000),
                new SequenceCondition(1)));

        //when
        Screening afterScreening = new Screening(startWards, 1, LocalDateTime.now());
        Money afterMoney = startWards.calculateMovieFee(afterScreening);

        //then
        assertEquals(afterMoney, Money.wons(10000));


    }


}
