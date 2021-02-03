package unit_tests;

import tirepressuremonitoringsystem.Alarm;

public class AlarmStub extends Alarm {

    private Double pressure;
    private String message;

    public AlarmStub(Double pressure) {
        this.pressure = pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }
    
    public String getMessage() {
        return message;
    }

    @Override
    protected double getPsiPressureValue() {
        return this.pressure;
    }

    @Override
    protected void getPrintln(String s) {
        message = s;
    }
}
