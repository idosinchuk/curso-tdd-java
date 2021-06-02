package tirepressuremonitoringsystem;

public class Alarm {
    private static final double LOW_PRESSURE_THRESHOLD = 17;
    private static final double HIGH_PRESSURE_THRESHOLD = 21;
    private final Sensor sensor;
    private final Logger logger;
    private boolean alarmOn = false;

    public Alarm(Sensor sensor, Logger logger) {
        this.sensor = sensor;
        this.logger = logger;
    }

    public Alarm() {
        this(new RandomSensor(), new ConsoleLogger());
    }

    public void check() {
        double psiPressureValue = sensor.popNextPressurePsiValue();

        if (psiPressureValue < LOW_PRESSURE_THRESHOLD || HIGH_PRESSURE_THRESHOLD < psiPressureValue) {
            if (!isAlarmOn()) {
                alarmOn = true;
                logger.log("Alarm activated!");
            }
        } else {
            if (isAlarmOn()) {
                alarmOn = false;
                logger.log("Alarm deactivated!");
            }
        }
    }

    private boolean isAlarmOn() {
        return alarmOn;
    }
}
