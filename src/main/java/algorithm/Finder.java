package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Finder {
    private final List<Person> people;

    public Finder(List<Person> people) {
        this.people = people;
    }

    public TwoPeopleBirthTimeDifference find(BirthDifferenceType birthDifferenceType) {
        List<TwoPeopleBirthTimeDifference> peopleWithBirthDifferences = getPeopleWithBirthDifferencesBetweenThem();

        final Optional<TwoPeopleBirthTimeDifference> twoPeopleBirthTimeDifference =
                peopleWithBirthDifferences.stream().reduce(birthDifferenceType.get());

        return twoPeopleBirthTimeDifference.orElseGet(TwoPeopleBirthTimeDifference::new);
    }

    private List<TwoPeopleBirthTimeDifference> getPeopleWithBirthDifferencesBetweenThem() {
        List<TwoPeopleBirthTimeDifference> peopleWithBirthDifferences = new ArrayList<>();

        for (int i = 0; i < people.size() - 1; i++) {
            for (int j = i + 1; j < people.size(); j++) {
                final Person currentPerson = people.get(i);
                final Person otherPerson = people.get(j);
                peopleWithBirthDifferences.add(TwoPeopleBirthTimeDifference.build(currentPerson, otherPerson));
            }
        }
        return peopleWithBirthDifferences;
    }

}
