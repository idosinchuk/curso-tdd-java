package unit_tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tirepressuremonitoringsystem.Alarm;
import tirepressuremonitoringsystem.Logger;
import tirepressuremonitoringsystem.Sensor;

import static org.mockito.Mockito.*;

class AlarmTest {

    private Sensor sensor;
    private Logger logger;
    private Alarm alarm;

    @BeforeEach
    void setUp() {
        sensor = mock(Sensor.class);
        logger = mock(Logger.class);
        alarm = new Alarm(sensor, logger);
    }

    @Test
    void alarm_is_activated_when_sensor_value_is_below_threshold() {
        when(sensor.popNextPressurePsiValue()).thenReturn(15d);

        alarm.check();

        verify(logger).log("Alarm activated!");
    }

    @Test
    void alarm_is_activated_when_sensor_value_is_above_threshold() {
        when(sensor.popNextPressurePsiValue()).thenReturn(22d);

        alarm.check();

        verify(logger).log("Alarm activated!");
    }

    @Test
    void alarm_stays_inactive_when_value_is_in_threshold() {
        when(sensor.popNextPressurePsiValue()).thenReturn(20d);

        alarm.check();

        verifyNoMoreInteractions(logger);
    }

    @Test
    void alarm_stays_active_when_sensor_value_remains_out_of_threshold() {
        when(sensor.popNextPressurePsiValue()).thenReturn(15d, 25d);

        alarm.check();
        alarm.check();

        verify(logger, times(1)).log("Alarm activated!");
    }

    @Test
    void alarm_deactivates_after_value_goes_back_to_accepted_threshold() {
        when(sensor.popNextPressurePsiValue()).thenReturn(25d, 20d);

        alarm.check();
        alarm.check();

        verify(logger).log("Alarm deactivated!");
    }
}

