package test;

import algorithm.BirthDifferenceCriterion;
import algorithm.Finder;
import algorithm.Person;
import algorithm.TwoPeople;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

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
        Finder finder = new Finder();

        TwoPeople result = finder.find(list, BirthDifferenceCriterion.CLOSEST);
        assertNull(result.getYounger());
        assertNull(result.getOlder());
    }

    @Test
    public void returns_empty_results_when_given_one_person() {
        List<Person> list = Collections.singletonList(sue);

        Finder finder = new Finder();

        TwoPeople result = finder.find(list, BirthDifferenceCriterion.CLOSEST);

        assertNull(result.getYounger());
        assertNull(result.getOlder());
    }

    @Test
    public void returns_closest_two_for_two_people() {
        List<Person> list = Arrays.asList(sue, greg);

        Finder finder = new Finder();

        TwoPeople result = finder.find(list, BirthDifferenceCriterion.CLOSEST);

        assertEquals(sue, result.getYounger());
        assertEquals(greg, result.getOlder());
    }

    @Test
    public void returns_furthest_two_for_two_people() {
        List<Person> list = Arrays.asList(mike, greg);

        Finder finder = new Finder();

        TwoPeople result = finder.find(list, BirthDifferenceCriterion.FURTHEST);

        assertEquals(greg, result.getYounger());
        assertEquals(mike, result.getOlder());
    }

    @Test
    public void returns_furthest_two_for_four_people() {
        List<Person> list = Arrays.asList(sue, sarah, mike, greg);

        Finder finder = new Finder();

        TwoPeople result = finder.find(list, BirthDifferenceCriterion.FURTHEST);

        assertEquals(sue, result.getYounger());
        assertEquals(sarah, result.getOlder());
    }

    @Test
    public void Returns_Closest_Two_For_Four_People() {
        List<Person> list = new ArrayList<Person>();
        list.add(sue);
        list.add(sarah);
        list.add(mike);
        list.add(greg);

        Finder finder = new Finder();

        TwoPeople result = finder.find(list, BirthDifferenceCriterion.CLOSEST);

        assertEquals(sue, result.getYounger());
        assertEquals(greg, result.getOlder());
    }

}
