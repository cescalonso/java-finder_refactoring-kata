package algorithm;

import java.util.ArrayList;
import java.util.List;

public class Finder {
    private final List<Person> people;

    public Finder(List<Person> people) {
        this.people = people;
    }

    public TwoPeopleBirthTimeDifference find(FT ft) {
        List<TwoPeopleBirthTimeDifference> peopleWithBirthDifferences = getPeopleWithBirthDifferencesBetweenThem();

        if (peopleWithBirthDifferences.isEmpty()) {
            return new TwoPeopleBirthTimeDifference();
        }

        TwoPeopleBirthTimeDifference answer = peopleWithBirthDifferences.get(0);
        for (TwoPeopleBirthTimeDifference result : peopleWithBirthDifferences) {
            if (ft == FT.CLOSEST) {
                if (result.birthTimeDifference < answer.birthTimeDifference) {
                    answer = result;
                }
            } else if (ft == FT.FURTHEST) {
                if (result.birthTimeDifference > answer.birthTimeDifference) {
                    answer = result;
                }
            }
        }

        return answer;
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
