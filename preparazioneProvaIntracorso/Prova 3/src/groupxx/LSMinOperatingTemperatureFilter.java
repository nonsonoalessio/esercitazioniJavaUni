package groupxx;
import groupxx.provided.SensorFilter;

public class LSMinOperatingTemperatureFilter implements SensorFilter {
    private final double minTemperature;
    public LSMinOperatingTemperatureFilter(double minTemperature){
        this.minTemperature = minTemperature;

    }


    public boolean checkSensor(Sensor s) {
        if (s instanceof LightSensor p){
            if (((LightSensor) s).getOperatingTemperature().getLow().equals(minTemperature))
                return true;
        }
        return false;
    }
}
