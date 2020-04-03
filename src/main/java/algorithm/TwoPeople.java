package algorithm;

public class TwoPeople {
    private Person younger;
    private Person older;

    public TwoPeople(Person younger, Person older) {
        this.younger = younger;
        this.older = older;
    }

    public TwoPeople() {
    }

    public Person getYounger() {
        return younger;
    }

    public Person getOlder() {
        return older;
    }
}
