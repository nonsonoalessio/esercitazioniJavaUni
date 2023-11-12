package groupxx;

import groupxx.provided.SensorFilter;
import groupxx.provided.SensorOutputType;

public class I2CSensorFilter implements SensorFilter {
    public boolean checkSensor(Sensor s){
        if (s.getSot() == SensorOutputType.I2C)
            return true;
        return false;

    }
}
