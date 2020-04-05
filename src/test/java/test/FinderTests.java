package test;

import algorithm.BirthDifferenceCriterion;
import algorithm.Finder;
import algorithm.Person;
import algorithm.TwoPeople;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class FinderTests {

    Person sue;
    Person greg;
    Person sarah;
    Person mike;

    @Before
    public void setup() {
        sue = new Person("Sue", new GregorianCalendar(50 + 1900, 0, 1));
        greg = new Person("Greg", new GregorianCalendar(52 + 1900, 5, 1));
        sarah = new Person("Sarah", new GregorianCalendar(82 + 1900, 0, 1));
        mike = new Person("Mike", new GregorianCalendar(79 + 1900, 0, 1));
    }

    @Test
    public void returns_empty_results_when_given_empty_list() {
        List<Person> list = new ArrayList<>();
        Finder finder = new Finder();

        Optional<TwoPeople> result = finder.find(list, BirthDifferenceCriterion.CLOSEST);
        assertFalse(result.isPresent());
    }

    @Test
    public void returns_empty_results_when_given_one_person() {
        List<Person> list = Collections.singletonList(sue);

        Finder finder = new Finder();

        Optional<TwoPeople> result = finder.find(list, BirthDifferenceCriterion.CLOSEST);

        assertFalse(result.isPresent());
    }

    @Test
    public void returns_closest_two_for_two_people() {
        List<Person> list = Arrays.asList(sue, greg);

        Finder finder = new Finder();

        Optional<TwoPeople> result = finder.find(list, BirthDifferenceCriterion.CLOSEST);

        assertTrue(result.isPresent());
        result.ifPresent(twoPeople -> {
            assertEquals(sue, twoPeople.getYounger());
            assertEquals(greg, twoPeople.getOlder());
        });

    }

    @Test
    public void returns_furthest_two_for_two_people() {
        List<Person> list = Arrays.asList(mike, greg);

        Finder finder = new Finder();

        Optional<TwoPeople> result = finder.find(list, BirthDifferenceCriterion.FURTHEST);

        assertTrue(result.isPresent());
        result.ifPresent(twoPeople -> {
            assertEquals(greg, twoPeople.getYounger());
            assertEquals(mike, twoPeople.getOlder());
        });
    }

    @Test
    public void returns_furthest_two_for_four_people() {
        List<Person> list = Arrays.asList(sue, sarah, mike, greg);

        Finder finder = new Finder();

        Optional<TwoPeople> result = finder.find(list, BirthDifferenceCriterion.FURTHEST);

        assertTrue(result.isPresent());
        result.ifPresent(twoPeople -> {
            assertEquals(sue, twoPeople.getYounger());
            assertEquals(sarah, twoPeople.getOlder());
        });
    }

    @Test
    public void Returns_Closest_Two_For_Four_People() {
        List<Person> list = new ArrayList<Person>();
        list.add(sue);
        list.add(sarah);
        list.add(mike);
        list.add(greg);

        Finder finder = new Finder();

        Optional<TwoPeople> result = finder.find(list, BirthDifferenceCriterion.CLOSEST);

        assertTrue(result.isPresent());
        result.ifPresent(twoPeople -> {
            assertEquals(sue, twoPeople.getYounger());
            assertEquals(greg, twoPeople.getOlder());
        });

    }

}
