package io.todak.study.objectstudy.chapter02.movie.step01;

import io.todak.study.objectstudy.chapter02.money.Money;

import java.time.LocalDateTime;

public class Screening {

    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreend;

    public Screening(Movie movie, int sequence, LocalDateTime whenScreend) {
        this.movie = movie;
        this.sequence = sequence;
        this.whenScreend = whenScreend;
    }

    public LocalDateTime getStartTime() {
        return whenScreend;
    }

    public boolean isSequence(int sequence) {
        return this.sequence == sequence;
    }

    public Money getMovieFee() {
        return movie.getFee();
    }

    /**
     *
     * 영화를 예매한 후
     * 예매 정보를 담고 있는 Reservation의 인스턴스를 생성해 반환한다.
     *
     * customer는 예매자
     * audienceCount는 인원수다.
     *
     */
    public Reservation reserve(Customer customer, int audienceCount){
        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
    }


    private Money calculateFee(int audienceCount) {
        /**
         * movie.calcuateMovieFee 메서드의 반환 값은
         * 1인 당 예매 요금이다.
         *
         * 따라서, Screening은 전체 요금을 구하기 위해
         * calculateMovieFee 메서드의 반환 값에 인원 수인 audienceCount를 곱한다.
         */
        return movie.calculateMovieFee(this).times(audienceCount);
    }

}
