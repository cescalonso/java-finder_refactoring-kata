package test;

import algorithm.F;
import algorithm.FT;
import algorithm.Finder;
import algorithm.Person;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class FinderTests {

    Person sue;
    Person greg;
    Person sarah;
    Person mike;

    @Before
    public void setup() {
        sue = new Person("Sue", new Date(50, 0, 1));
        greg = new Person("Greg", new Date(52, 5, 1));
        sarah = new Person("Sarah", new Date(82, 0, 1));
        mike = new Person("Mike", new Date(79, 0, 1));
    }

    @Test
    public void returns_empty_results_when_given_empty_list() {
        List<Person> list = new ArrayList<>();
        Finder finder = new Finder(list);

        F result = finder.find(FT.One);
		assertNull(result.person1);
		assertNull(result.person2);
    }

    @Test
    public void Returns_Empty_Results_When_Given_One_Person() {
        List<Person> list = new ArrayList<Person>();
        list.add(sue);

        Finder finder = new Finder(list);

        F result = finder.find(FT.One);

        assertEquals(null, result.person1);
        assertEquals(null, result.person2);
    }

    @Test
    public void Returns_Closest_Two_For_Two_People() {
        List<Person> list = new ArrayList<Person>();
        list.add(sue);
        list.add(greg);
        Finder finder = new Finder(list);

        F result = finder.find(FT.One);

        assertEquals(sue, result.person1);
        assertEquals(greg, result.person2);
    }

    @Test
    public void Returns_Furthest_Two_For_Two_People() {
        List<Person> list = new ArrayList<Person>();
        list.add(mike);
        list.add(greg);

        Finder finder = new Finder(list);

        F result = finder.find(FT.Two);

        assertEquals(greg, result.person1);
        assertEquals(mike, result.person2);
    }

    @Test
    public void Returns_Furthest_Two_For_Four_People() {
        List<Person> list = new ArrayList<Person>();
        list.add(sue);
        list.add(sarah);
        list.add(mike);
        list.add(greg);
        Finder finder = new Finder(list);

        F result = finder.find(FT.Two);

        assertEquals(sue, result.person1);
        assertEquals(sarah, result.person2);
    }

    @Test
    public void Returns_Closest_Two_For_Four_People() {
        List<Person> list = new ArrayList<Person>();
        list.add(sue);
        list.add(sarah);
        list.add(mike);
        list.add(greg);

        Finder finder = new Finder(list);

        F result = finder.find(FT.One);

        assertEquals(sue, result.person1);
        assertEquals(greg, result.person2);
    }

}
