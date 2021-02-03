import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FizzBuzzTest {

    FizzBuzz fizzBuzz;

    @BeforeEach
    void setUp() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    void return_fizz_when_number_is_multiple_of_3() {
        List<String> result = FizzBuzz.generate();

        Assertions.assertEquals("Fizz", result.get(5));
        Assertions.assertEquals("Fizz", result.get(98));
    }

    @Test
    void return_buzz_when_number_is_multiple_of_5() {
        List<String> result = FizzBuzz.generate();

        Assertions.assertEquals("Buzz", result.get(9));
        Assertions.assertEquals("Buzz", result.get(99));
    }

    @Test
    void return_fizzbuzz_when_number_is_multiple_of_3_and_5() {
        List<String> result = FizzBuzz.generate();

        Assertions.assertEquals("FizzBuzz", result.get(59));
        Assertions.assertEquals("FizzBuzz", result.get(89));
    }

    @Test
    void return_fizz_when_number_contains_3() {
        List<String> result = FizzBuzz.generate();

        Assertions.assertEquals("Fizz", result.get(12));
        Assertions.assertEquals("Fizz", result.get(30));
    }

    @Test
    void return_fizz_when_number_contains_5() {
        List<String> result = FizzBuzz.generate();

        Assertions.assertEquals("Buzz", result.get(54));
        Assertions.assertEquals("Buzz", result.get(94));
    }

    @Test
    void return_fizzbuzz_when_number_contains_3_and_5() {
        List<String> result = FizzBuzz.generate();

        Assertions.assertEquals("FizzBuzz", result.get(34));
        Assertions.assertEquals("FizzBuzz", result.get(52));
    }

}
