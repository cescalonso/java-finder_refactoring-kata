package algorithm;

import java.util.List;

public class Finder {
    public TwoPeople find(final List<Person> people, final BirthDifferenceCriterion birthDifferenceCriterion) {
        return birthDifferenceCriterion.apply(people).orElseGet(TwoPeople::new);
    }
}
