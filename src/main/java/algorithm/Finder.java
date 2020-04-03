package algorithm;

import java.util.Comparator;
import java.util.List;

public class Finder {
    public TwoPeopleBirthTimeDifference find(final List<Person> people, final BirthDifferenceType birthDifferenceCriterion) {
        if (people.size() < 2) {
            return new TwoPeopleBirthTimeDifference();
        }
        people.sort(Comparator.comparing(Person::getBirthTime));
        return birthDifferenceCriterion.apply(people);
    }
}
