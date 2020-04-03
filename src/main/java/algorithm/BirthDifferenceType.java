package algorithm;

import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

public enum BirthDifferenceType implements Supplier<BinaryOperator<TwoPeopleBirthTimeDifference>> {
    CLOSEST(BinaryOperator.minBy(Comparator.comparing(TwoPeopleBirthTimeDifference::getBirthTimeDifference))),
    FURTHEST(BinaryOperator.maxBy(Comparator.comparing(TwoPeopleBirthTimeDifference::getBirthTimeDifference)));

    private final BinaryOperator<TwoPeopleBirthTimeDifference> birthTimeDifferenceBinaryOperator;

    BirthDifferenceType(BinaryOperator<TwoPeopleBirthTimeDifference> birthTimeDifferenceBinaryOperator) {

        this.birthTimeDifferenceBinaryOperator = birthTimeDifferenceBinaryOperator;
    }

    @Override
    public BinaryOperator<TwoPeopleBirthTimeDifference> get() {
        return birthTimeDifferenceBinaryOperator;
    }
}
