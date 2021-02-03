package tirepressuremonitoringsystem;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Alarm {
    private static final double LOW_PRESSURE_THRESHOLD = 17;
    private static final double HIGH_PRESSURE_THRESHOLD = 21;

    private final Sensor sensor = new Sensor();

    Logger logger = Logger.getLogger(
            Alarm.class.getName());

    private boolean alarmOn = false;

    public void check() {
        double psiPressureValue = getPsiPressureValue();

        if (psiPressureValue < LOW_PRESSURE_THRESHOLD || HIGH_PRESSURE_THRESHOLD < psiPressureValue) {
            if (!isAlarmOn()) {
                alarmOn = true;
                getPrintln("Alarm activated!");
            }
        } else {
            if (isAlarmOn()) {
                alarmOn = false;
                getPrintln("Alarm deactivated!");
            }
        }
    }

    protected void getPrintln(String message) {
        logger.log(Level.INFO, message);
    }

    protected double getPsiPressureValue() {
        return sensor.popNextPressurePsiValue();
    }

    private boolean isAlarmOn() {
        return alarmOn;
    }
}
