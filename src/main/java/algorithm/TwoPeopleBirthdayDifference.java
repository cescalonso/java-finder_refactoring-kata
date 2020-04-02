package algorithm;
public class TwoPeopleBirthdayDifference {
	public Person younger;
	public Person older;
	public long difference;

	public TwoPeopleBirthdayDifference(Person younger, Person older) {
		this.younger = younger;
		this.older = older;
		this.difference = older.getBirthTime() - younger.getBirthTime();
	}

	public TwoPeopleBirthdayDifference() {
	}

	public static TwoPeopleBirthdayDifference build(Person person1, Person person2){
		if (person1.isYounger(person2)) {
			return new TwoPeopleBirthdayDifference(person1, person2);
		}
		return new TwoPeopleBirthdayDifference(person2, person1);
	}
}
