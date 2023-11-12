package groupxx;

import groupxx.provided.SensorFilter;

public class SourceVoltageFilter implements SensorFilter {
    private final double vs;
    public SourceVoltageFilter(double vs){
        this.vs = vs;
    }
    @Override
    public boolean checkSensor(Sensor s) {
        return s.getVs().getHigh() >= this.vs && s.getVs().getLow() <= this.vs;
    }
}
