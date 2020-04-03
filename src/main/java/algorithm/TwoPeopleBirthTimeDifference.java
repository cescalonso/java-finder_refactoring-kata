package algorithm;
public class TwoPeopleBirthTimeDifference {
	public Person younger;
	public Person older;
	public long birthTimeDifference;

	public TwoPeopleBirthTimeDifference(Person younger, Person older) {
		this.younger = younger;
		this.older = older;
		this.birthTimeDifference = older.getBirthTime() - younger.getBirthTime();
	}

	public long getBirthTimeDifference() {
		return birthTimeDifference;
	}

	public TwoPeopleBirthTimeDifference() {
	}

	public static TwoPeopleBirthTimeDifference build(Person person1, Person person2){
		if (person1.isYounger(person2)) {
			return new TwoPeopleBirthTimeDifference(person1, person2);
		}
		return new TwoPeopleBirthTimeDifference(person2, person1);
	}

}
