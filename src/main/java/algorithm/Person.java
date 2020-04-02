package algorithm;

import java.util.Date;

public class Person {
    private String name;
    private long birthTime;

    public Person(String name, Date birthTime) {
        this.name = name;
        this.birthTime = birthTime.getTime();
    }

    public long getBirthTime() {
        return birthTime;
    }

    public boolean isYounger(Person other) {
        return getBirthTime() < other.getBirthTime();
    }
}

