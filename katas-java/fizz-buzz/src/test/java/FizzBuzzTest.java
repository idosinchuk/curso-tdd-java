import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class FizzBuzzTest {

    private static String elementAt(int position) {
        return FizzBuzz.generate().get(position - 1);
    }

    @Test
    void creates_a_list_with_numbers_from_1_to_100() {
        assertThat(FizzBuzz.generate(), Matchers.hasSize(100));
    }

    @Test
    void contains_numbers_as_strings() {
        assertThat(elementAt(1), is("1"));
        assertThat(elementAt(2), is("2"));
        assertThat(elementAt(4), is("4"));
    }

    @Test
    void numbers_multiples_of_three_are_replaced_with_fizz() {
        assertThat(elementAt(3), is("Fizz"));
        assertThat(elementAt(6), is("Fizz"));
        assertThat(elementAt(9), is("Fizz"));
    }

    @Test
    void numbers_multiples_of_five_are_replaced_with_buzz() {
        assertThat(elementAt(5), is("Buzz"));
        assertThat(elementAt(10), is("Buzz"));
        assertThat(elementAt(20), is("Buzz"));
    }

    @Test
    void numbers_multiples_of_three_and_five_are_replaced_with_fizzbuzz() {
        assertThat(elementAt(15), is("FizzBuzz"));
        assertThat(elementAt(30), is("FizzBuzz"));
        assertThat(elementAt(45), is("FizzBuzz"));
    }

    @Test
    void numbers_containing_a_three_are_replaced_with_fizz() {
        assertThat(elementAt(13), is("Fizz"));
        assertThat(elementAt(23), is("Fizz"));
        assertThat(elementAt(31), is("Fizz"));
    }

    @Test
    void numbers_containing_a_five_are_replaced_with_buzz() {
        assertThat(elementAt(52), is("Buzz"));
        assertThat(elementAt(56), is("Buzz"));
        assertThat(elementAt(58), is("Buzz"));
    }

    @Test
    void numbers_containing_a_three_and_five_are_replaced_with_fizzbuzz() {
        assertThat(elementAt(35), is("FizzBuzz"));
        assertThat(elementAt(53), is("FizzBuzz"));
    }
}