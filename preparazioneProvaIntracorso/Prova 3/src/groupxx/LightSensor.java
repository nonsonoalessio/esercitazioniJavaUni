package groupxx;
import groupxx.provided.*;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class LightSensor extends Sensor {
    private final double waveLenght;
    private final boolean proximityDetection;
    private final LightSensorType lst;
    private final Range<Double> OperatingTemperature;
    public LightSensor( String partNumber, String manufacturer, double price, Range<Double> vs, SensorOutputType sot, LocalDate manifacturingDate, double wavelength, boolean proximityDetection, Range<Double> operatingTemperature, LightSensorType lst){
        super(partNumber, manufacturer, price, vs, sot, manifacturingDate);
        this.waveLenght = wavelength;
        this.proximityDetection = proximityDetection;
        this.lst = lst;
        this.OperatingTemperature =operatingTemperature;
    }
    public LightSensor( String partNumber, String manufacturer, double price, Range<Double> vs, SensorOutputType sot, LocalDate manifacturingDate, double wavelength, Range<Double> operatingTemperature){
        super(partNumber, manufacturer, price, vs, sot, manifacturingDate);
        this.waveLenght = wavelength;
        this.proximityDetection = false;
        this.lst = null;
        this.OperatingTemperature = operatingTemperature;
    }
    public double getWaveLenght(){
        return waveLenght;
    }
    public boolean HasProximityDetection(){
        return proximityDetection;
    }
    public Range<Double> getOperatingTemperature(){
        return OperatingTemperature;
    }
    public LightSensorType getLst (){
        return lst;
    }
    @Override
    public boolean hasValidPartNumber(){
        Pattern apdsPattern = Pattern.compile("^APDS\\d{7}$");
        Pattern vcnlPattern = Pattern.compile("^VCNL\\d{4}$");
        String partNumber = getPartNumber();

        return apdsPattern.matcher(partNumber).matches() || vcnlPattern.matcher(partNumber).matches();

    }
    @Override
    public String toString(){
        return "****Light Sensor***\n" +
                "Wavelenght(nm)= " + waveLenght +
                "\nProximity Detection= " + proximityDetection +
                "\nOperating Temperature= " + OperatingTemperature.getLow() + " ~ " +  OperatingTemperature.getHigh() +
                "\nLight Sensor Type= " + lst + "\n" + super.toString() + "\n";
    }
}

