package io.todak.study.objectstudy.chapter04.movie.step01;

import io.todak.study.objectstudy.chapter04.money.Money;

/**
 * 데이터 클래스들을 조합해서 영화 예매 절차를 구현하는 클래스.
 */
public class ReservationAgency {

    public Reservation reserve(Screening screening, Customer customer, int audienceCount) {

        Movie movie = screening.getMovie();

        boolean discountable = false;

        /**
         * DiscountCondition을 순회하며, 할인 가능 여부를 확인하는 반복문
         */
        for (DiscountCondition condition : movie.getDiscountConditions()) {
            if (condition.getType() == DiscountConditionType.PERIOD) {
                discountable = screening.getWhenScreened().getDayOfWeek().equals(condition.getDayOfWeek()) &&
                        condition.getStartTime().compareTo(screening.getWhenScreened().toLocalTime()) <= 0 &&
                        condition.getEndTime().compareTo(screening.getWhenScreened().toLocalTime()) >= 0;
            } else {
                discountable = condition.getSequence() == screening.getSequence();
            }

            if (discountable) {
                break;
            }
        }

        /**
         * 적절한 할인 정책에 따라 예매 요금을 계산.
         */
        Money fee;
        if (discountable) {
            Money discountAmount = Money.ZERO;
            switch (movie.getMovieType()) {
                case AMOUNT_DISCOUNT:
                    discountAmount = movie.getDiscountAmount();
                    break;
                case PERCENT_DISCOUNT:
                    discountAmount = movie.getFee().times(movie.getDiscountPercent());
                    break;
                case NONE_DISCOUNT:
                    discountAmount = Money.ZERO;
                    break;
            }
            /**
             * 한 명의 예매 요금을 계산하기 위해 Movie의 getFee 메서드를 호출.
             * 계산된 결과를 Money 타입의 fee에 저장.
             *
             * fee의 타입을 변경하게 되면?
             * => getFee 메서드의 반환 타입 수정.
             * => getFee 메서드를 호출하는 ReservationAgency의 구현도 변경된 타입에 맞게 함께 수정
             * => getFee는 사실 인스턴스 변수 fee의 가시성을 private에서 public으로 변경하는 것이나 다름 없음.
             */
            fee = movie.getFee().minus(discountAmount).times(audienceCount);
        } else {
            fee = movie.getFee().times(audienceCount);
        }

        return new Reservation(customer, screening, fee, audienceCount);
    }
}
