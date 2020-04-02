package algorithm;

import java.util.ArrayList;
import java.util.List;

public class Finder {
    private final List<Person> people;

    public Finder(List<Person> people) {
        this.people = people;
    }

    public TwoPeopleBirthdayDifference find(FT ft) {
        List<TwoPeopleBirthdayDifference> peopleWithBirthDifferences = getPeopleWithBirthDifferencesBetweenThem();

        if (peopleWithBirthDifferences.isEmpty()) {
            return new TwoPeopleBirthdayDifference();
        }

        TwoPeopleBirthdayDifference answer = peopleWithBirthDifferences.get(0);
        for (TwoPeopleBirthdayDifference result : peopleWithBirthDifferences) {
            if (ft == FT.CLOSEST) {
                if (result.difference < answer.difference) {
                    answer = result;
                }
            } else if (ft == FT.FURTHEST) {
                if (result.difference > answer.difference) {
                    answer = result;
                }
            }
        }

        return answer;
    }

    private List<TwoPeopleBirthdayDifference> getPeopleWithBirthDifferencesBetweenThem() {
        List<TwoPeopleBirthdayDifference> peopleWithBirthDifferences = new ArrayList<>();

        for (int i = 0; i < people.size() - 1; i++) {
            for (int j = i + 1; j < people.size(); j++) {
                final Person currentPerson = people.get(i);
                final Person otherPerson = people.get(j);
                peopleWithBirthDifferences.add(TwoPeopleBirthdayDifference.build(currentPerson, otherPerson));
            }
        }
        return peopleWithBirthDifferences;
    }

}
