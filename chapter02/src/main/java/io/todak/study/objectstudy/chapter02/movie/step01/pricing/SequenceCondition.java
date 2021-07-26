package io.todak.study.objectstudy.chapter02.movie.step01.pricing;

import io.todak.study.objectstudy.chapter02.movie.step01.DiscountCondition;
import io.todak.study.objectstudy.chapter02.movie.step01.Screening;

public class SequenceCondition implements DiscountCondition {

    /**
     * 할인 여부를 판단하기위해 사용할 순번(sequence)을
     * 인스턴스 변수로 포함한다.
     */
    private int sequence;

    public SequenceCondition(int sequence) {
        this.sequence = sequence;
    }

    /**
     * 상영 순번과 일치할 경우 할인 가능한 것으로 판단해서 true,
     * 그렇지 않은 경우 false 반환.
     */
    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return screening.isSequence(sequence);
    }
}
