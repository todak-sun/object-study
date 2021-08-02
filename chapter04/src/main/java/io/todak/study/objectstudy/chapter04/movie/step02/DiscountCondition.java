package io.todak.study.objectstudy.chapter04.movie.step02;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class DiscountCondition {
    private DiscountConditionType type;

    private int sequence;

    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    public DiscountCondition(int sequence){
        this.type = DiscountConditionType.SEQUENCE;
        this.sequence = sequence;
    }

    public DiscountCondition(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime){
        this.type = DiscountConditionType.PERIOD;
        this.dayOfWeek= dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public DiscountConditionType getType() {
        return type;
    }

    /**
     * 할인 조건에는 순번 조건과 기간 조건의 두 가지 종류가 존재한다.
     * DiscountCondition은
     * 순번 조건일 경우 sequence를 이용해서 할인 여부를 결정,
     * 기간 조건일 경우에는 dayOfWeek, startTime, endTime을 이용해 할인 여부를 결정한다.
     *
     * 따라서, 다음과 같이 두 가지 할인 조건을 판단할 수 있게
     * 두 개의 isDiscountable 메서드가 필요해진다.
     *
     */
    public boolean isDiscountable(DayOfWeek dayOfWeek, LocalTime time) {
        if (type != DiscountConditionType.PERIOD) {
            throw new IllegalArgumentException();
        }

        return this.dayOfWeek.equals(dayOfWeek) &&
                this.startTime.compareTo(time) <= 0 &&
                this.endTime.compareTo(time) >= 0;
    }

    public boolean isDiscountable(int sequence) {
        if (type != DiscountConditionType.SEQUENCE) {
            throw new IllegalArgumentException();
        }

        return this.sequence == sequence;
    }
}
