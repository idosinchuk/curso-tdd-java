import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.IntStream.rangeClosed;

public class FizzBuzz {

    private static final List<Function<Integer, String>> rules = List.of(
            i -> isFizz(i) ? "Fizz" : "",
            i -> isBuzz(i) ? "Buzz" : ""
    );

    public static List<String> generate() {
        return rangeClosed(1, 100)
                .mapToObj(FizzBuzz::transform)
                .collect(Collectors.toList());
    }

    private static String transform(int i) {
        var value = rules.stream()
                .map(f -> f.apply(i))
                .collect(Collectors.joining());
        return value.isEmpty() ? Integer.toString(i) : value;
    }

    private static boolean isFizz(int i) {
        return i % 3 == 0 || Integer.toString(i).contains("3");
    }

    private static boolean isBuzz(int i) {
        return i % 5 == 0 || Integer.toString(i).contains("5");
    }
}
