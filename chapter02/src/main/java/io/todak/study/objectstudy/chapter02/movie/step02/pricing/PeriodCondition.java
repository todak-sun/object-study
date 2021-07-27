package io.todak.study.objectstudy.chapter02.movie.step02.pricing;

import io.todak.study.objectstudy.chapter02.movie.step02.DiscountCondition;
import io.todak.study.objectstudy.chapter02.movie.step02.Screening;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class PeriodCondition implements DiscountCondition {

    /**
     * 조건에 사용할 요일
     */
    private DayOfWeek dayOfWeek;
    /**
     * 시작 시간
     */
    private LocalTime startTime;
    /**
     * 종료 시간
     */
    private LocalTime endTime;

    public PeriodCondition(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * Screening의 상영 요일이
     * dayOfWeek과 같고,
     * 상영 시작 시간이 startTime과 endTime 사이에 있을 경우에는 true를 반환.
     */
    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return screening.getStartTime().getDayOfWeek().equals(dayOfWeek)
                && startTime.compareTo(screening.getStartTime().toLocalTime()) <= 0
                && endTime.compareTo(screening.getStartTime().toLocalTime()) >= 0;
    }
}
