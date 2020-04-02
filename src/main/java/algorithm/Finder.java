package algorithm;
import java.util.ArrayList;
import java.util.List;

public class Finder {
	private final List<Person> people;

	public Finder(List<Person> p) {
		people = p;
	}

	public F find(FT ft) {
		List<F> tr = new ArrayList<>();

		for (int i = 0; i < people.size() - 1; i++) {
			for (int j = i + 1; j < people.size(); j++) {
				F r = new F();
				if (people.get(i).getBirthDate().getTime() < people.get(j).getBirthDate().getTime()) {
					r.person1 = people.get(i);
					r.person2 = people.get(j);
				} else {
					r.person1 = people.get(j);
					r.person2 = people.get(i);
				}
				r.difference = r.person2.getBirthDate().getTime() - r.person1.getBirthDate().getTime();
				tr.add(r);
			}
		}

		if (tr.isEmpty()) {
			return new F();
		}

		F answer = tr.get(0);
		for (F result : tr) {
			switch (ft) {
				case One :
					if (result.difference < answer.difference) {
						answer = result;
					}
					break;

				case Two :
					if (result.difference > answer.difference) {
						answer = result;
					}
					break;
			}
		}

		return answer;
	}
}
