package io.todak.study.objectstudy.chapter04.movie.step02;

import io.todak.study.objectstudy.chapter04.money.Money;

public class ReservationAgency {
    public Reservation reserve(Screening screening, Customer customer, int audienceCount) {
        Money fee = screening.calculateFee(audienceCount);
        return new Reservation(customer, screening, fee, audienceCount);
    }
}
