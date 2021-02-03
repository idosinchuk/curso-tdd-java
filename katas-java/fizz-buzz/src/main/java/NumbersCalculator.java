import java.util.ArrayList;
import java.util.List;

public class NumbersCalculator {

    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";
    private static final int NUMBER_THREE = 3;
    private static final int NUMBER_FIVE = 5;

    public List<String> getResults() {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= 100; ++i) {
            if (isFizz(i) && isBuzz(i)) {
                result.add(FIZZ + BUZZ);
            } else if (isFizz(i)) {
                result.add(FIZZ);
            } else if (isBuzz(i)) {
                result.add(BUZZ);
            } else {
                result.add(String.valueOf(i));
            }
        }
        return result;
    }

    private boolean isFizz(int i) {
        return isMultipleOf(i, NUMBER_THREE) || String.valueOf(i).contains(String.valueOf(NUMBER_THREE));
    }

    private boolean isBuzz(int i) {
        return isMultipleOf(i, NUMBER_FIVE) || String.valueOf(i).contains(String.valueOf(NUMBER_FIVE));
    }

    private boolean isMultipleOf(int i, int i2) {
        return i % i2 == 0;
    }
}
