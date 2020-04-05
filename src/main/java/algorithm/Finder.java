package algorithm;

import java.util.List;
import java.util.Optional;

public class Finder {
    public Optional<TwoPeople> find(final List<Person> people, final BirthDifferenceCriterion birthDifferenceCriterion) {
        return birthDifferenceCriterion.apply(people);
    }
}
