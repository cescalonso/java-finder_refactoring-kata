package algorithm;

import java.util.List;
import java.util.function.Function;

public enum BirthDifferenceType {
    CLOSEST(people -> new TwoPeopleBirthTimeDifference(people.get(0), people.get(1))),
    FURTHEST(people -> new TwoPeopleBirthTimeDifference(people.get(0), people.get(people.size() - 1)));
    
    private Function<List<Person>, TwoPeopleBirthTimeDifference> twoPeopleBirthTimeDifferenceFunction;

    BirthDifferenceType(Function<List<Person>, TwoPeopleBirthTimeDifference> twoPeopleBirthTimeDifferenceFunction) {
        this.twoPeopleBirthTimeDifferenceFunction = twoPeopleBirthTimeDifferenceFunction;
    }

    public TwoPeopleBirthTimeDifference apply(List<Person> people) {
        if (people.size() < 2) {
            throw new RuntimeException("It should be at least two people");
        }
        return twoPeopleBirthTimeDifferenceFunction.apply(people);
    }
}
