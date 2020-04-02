package algorithm;
import java.util.ArrayList;
import java.util.List;

public class Finder {
	private final List<Person> people;

	public Finder(List<Person> people) {
		this.people = people;
	}

	public F find(FT ft) {
		List<F> tr = new ArrayList<>();

		for (int i = 0; i < people.size() - 1; i++) {
			for (int j = i + 1; j < people.size(); j++) {
				F r = new F();
				final Person currentPerson = people.get(i);
				final Person otherPerson = people.get(j);
				if (currentPerson.getBirthTime() < otherPerson.getBirthTime()) {
					r.person1 = currentPerson;
					r.person2 = otherPerson;
				} else {
					r.person1 = otherPerson;
					r.person2 = currentPerson;
				}
				r.difference = r.person2.getBirthTime() - r.person1.getBirthTime();
				tr.add(r);
			}
		}

		if (tr.isEmpty()) {
			return new F();
		}

		F answer = tr.get(0);
		for (F result : tr) {
			switch (ft) {
				case CLOSEST:
					if (result.difference < answer.difference) {
						answer = result;
					}
					break;

				case FURTHEST:
					if (result.difference > answer.difference) {
						answer = result;
					}
					break;
			}
		}

		return answer;
	}
}
