import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzz {

    private static final String FIZZ_BUZZ = "FizzBuzz";
    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";
    private static final String THREE = "3";
    private static final String FIVE = "5";

    public static List<String> generate() {
        return IntStream.rangeClosed(1, 100)
                .mapToObj(FizzBuzz::fizzBuzzed)
                .collect(Collectors.toList());
    }

    private static String fizzBuzzed(int number) {
        if (isFizz(number) && isBuzz(number)) return FIZZ_BUZZ;
        if (isFizz(number)) return FIZZ;
        if (isBuzz(number)) return BUZZ;
        return Integer.toString(number);
    }

    private static boolean isFizz(int number) {
        return number % Integer.valueOf(THREE) == 0 || Integer.toString(number).contains(THREE);
    }

    private static boolean isBuzz(int number) {
        return number % Integer.valueOf(FIVE) == 0 || Integer.toString(number).contains(FIVE);
    }
}
