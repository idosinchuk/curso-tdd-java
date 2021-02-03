package unit_tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AlarmTest {

    private static final String ALARM_ACTIVATED = "Alarm activated!";
    private static final String ALARM_DEACTIVATED = "Alarm deactivated!";

    @Test
    void when_pressure_is_low_then_activate_alarm() {
        Double pressure = 16.0;

        AlarmStub alarmStub = new AlarmStub(pressure);
        alarmStub.check();

        Assertions.assertEquals((ALARM_ACTIVATED), alarmStub.getMessage());
    }

    @Test
    void when_pressure_is_high_then_activate_alarm() {
        Double pressure = 22.0;

        AlarmStub alarmStub = new AlarmStub(pressure);
        alarmStub.check();

        Assertions.assertEquals((ALARM_ACTIVATED), alarmStub.getMessage());
    }

    @Test
    void when_pressure_is_correct_then_deactivate_alarm() {
        Double pressure = 16.0;

        AlarmStub alarmStub = new AlarmStub(pressure);
        alarmStub.check();

        alarmStub.setPressure(19.0);
        alarmStub.check();

        Assertions.assertEquals((ALARM_DEACTIVATED), alarmStub.getMessage());
    }

}

