package tirepressuremonitoringsystem;

import java.util.Random;

public class RandomSensor implements Sensor {
    public static final double OFFSET = 16;

    private static double samplePressure() {
        Random basicRandomNumbersGenerator = new Random();
        return 6 * basicRandomNumbersGenerator.nextDouble() * basicRandomNumbersGenerator.nextDouble();
    }

    @Override
    public double popNextPressurePsiValue() {
        double pressureTelemetryValue;
        pressureTelemetryValue = samplePressure();

        return OFFSET + pressureTelemetryValue;
    }
}
