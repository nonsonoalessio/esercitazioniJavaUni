package groupxx;
import groupxx.provided.*;
import java.time.LocalDate;
import java.util.regex.Pattern;
public class Accelerometer extends Sensor {
    private final double g;
    private final  int sensingAxis;
    private final double bandwidth;

    public Accelerometer( String partNumber, String manufacturer, double price, Range<Double> vs, SensorOutputType sot, LocalDate manifacturingDate, double range, int sensingAxis, double bandwidth){
        super(partNumber, manufacturer,  price, vs,  sot,  manifacturingDate);
        this.g = range;
        this.sensingAxis = sensingAxis;
        this.bandwidth = bandwidth;
    }

    public Accelerometer(String partNumber, String manufacturer, double price, Range<Double> vs, SensorOutputType sot, LocalDate manifacturingDate, double range, double bandwidth){
        super(partNumber, manufacturer, price, vs, sot, manifacturingDate);
        this.g = range;
        this.sensingAxis = 3;
        this.bandwidth = bandwidth;
    }
    public double getRange(){
        return this.g;
    }

    public int getSensingAxis() {
        return this.sensingAxis;
    }

    public double getBandwidth() {
        return this.bandwidth;
    }
    @Override
    public boolean hasValidPartNumber(){
        Pattern adxlPattern = Pattern.compile("^ADXL\\d{3}$");
        Pattern adisPattern = Pattern.compile("^ADIS\\d{5}$");
        String partNumber = getPartNumber();

        return adxlPattern.matcher(partNumber).matches() || adisPattern.matcher(partNumber).matches();

    }
    @Override
    public String toString(){
        return "****Accelerometer***\n" +
                "Range (g)= " + getRange() +
                "\nNumber of Axis= " + sensingAxis +
                "\nBandwidth (kHz)= " + bandwidth + "\n" + super.toString() + "\n";
    }
}
