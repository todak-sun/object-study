package io.todak.study.objectstudy.chapter02.money;

import java.math.BigDecimal;

public class Money {

    /**
     * Money타입과 같은 객체를 활용하면 좋은 점
     *
     * 1. 금액과 관련되어 있다는 의미를 전달할 수 있다.
     * 2. 금액과 관련된 로직이 서로 다른 곳에 중복되어 구현되는 것을 막을 수 있다.
     * 3. 도메인의 의미를 풍부하게 표현할 수 있다.
     */

    public static final Money ZERO = Money.wons(0);

    private final BigDecimal amount;

    public static Money wons(long amount) {
        return new Money(BigDecimal.valueOf(amount));
    }

    public static Money wons(double amount) {
        return new Money(BigDecimal.valueOf(amount));
    }

    Money(BigDecimal amount) {
        this.amount = amount;
    }

    public Money plus(Money amount) {
        return new Money(this.amount.add(amount.amount));
    }

    public Money minus(Money amount) {
        return new Money(this.amount.subtract(amount.amount));
    }

    public Money times(double percent) {
        return new Money(this.amount.multiply(BigDecimal.valueOf(percent)));
    }

    public boolean isLessThen(Money other){
        return amount.compareTo(other.amount) < 0;
    }

    public boolean isGreaterThanOrEqual(Money other) {
        return amount.compareTo(other.amount) >= 0;
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                '}';
    }
}
