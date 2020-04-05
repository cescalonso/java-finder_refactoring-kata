package algorithm;

import java.util.GregorianCalendar;

public class Person {
    private final String name;
    private long birthTime;

    public Person(String name, GregorianCalendar birthTime) {
        this.name = name;
        this.birthTime = birthTime.getTime().getTime();
    }

    public long getBirthTime() {
        return birthTime;
    }
}

