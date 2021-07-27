package io.todak.study.objectstudy.chapter02.movie.step02;

import io.todak.study.objectstudy.chapter02.money.Money;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DefulatDiscountPolicy implements DiscountPolicy {

    /**
     * 부모 클래스인 DiscountPolicy 안에 중복되는 코드를 두고,
     * AmountDiscountPolicy와
     * PercentDiscountPolicy가 이 클래스를 상속받는다.
     */

    private List<DiscountCondition> conditions = new ArrayList<>();

    public DefulatDiscountPolicy(DiscountCondition... conditions) {
        /**
         * DiscountCondition의 리스트를
         * 인스턴스 변수로 가지기 때문에
         * 하나의 할인 정책은 여러 개의 할인 조건을 포함할 수 있다.
         */
        this.conditions = Arrays.asList(conditions);
    }

    @Override
    public Money calculateDiscountAmount(Screening screening) {
        for (DiscountCondition condition : conditions) {
            if (condition.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening);
            }
        }

        return Money.ZERO;
    }

    /**
     * DiscountPolicy는 할인 여부와 요금 계산에 필요한
     * 전체적인 흐름은 정의하지만
     * <p>
     * 실제로 요금을 계산하는 부분은 추상 메서드인 getDiscountAmount 메서드에
     * 위임한다.
     * <p>
     * 이처럼 부모 클래스에 기본적인 알고리즘의 흐름을 구현하고
     * 중간에 필요한 처리를 자식 클래스에 위임하는 디자인 패턴을 Template Method 패턴이라 한다.
     */
    abstract protected Money getDiscountAmount(Screening screening);

}
