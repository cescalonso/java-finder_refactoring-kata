package algorithm;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public enum BirthDifferenceCriterion {
    CLOSEST(people -> new TwoPeopleBirthTimeDifference(people.get(0), people.get(1))),
    FURTHEST(people -> new TwoPeopleBirthTimeDifference(people.get(0), people.get(people.size() - 1)));

    private Function<List<Person>, TwoPeopleBirthTimeDifference> twoPeopleBirthTimeDifferenceFunction;

    BirthDifferenceCriterion(Function<List<Person>, TwoPeopleBirthTimeDifference> twoPeopleBirthTimeDifferenceFunction) {
        this.twoPeopleBirthTimeDifferenceFunction = twoPeopleBirthTimeDifferenceFunction;
    }

    public Optional<TwoPeopleBirthTimeDifference> apply(List<Person> people) {
        if (people.size() < 2) {
            return Optional.empty();
        }
        people.sort(Comparator.comparing(Person::getBirthTime));
        return Optional.of(twoPeopleBirthTimeDifferenceFunction.apply(people));
    }
}
