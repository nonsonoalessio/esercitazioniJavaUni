package groupxx;
import java.time.LocalDate;
import groupxx.provided.*;

public class TemperatureSensor extends Sensor{
    private final double tempResolution;
    private final double tempError;
    private final int bits;

    private final double outputSensitivity;

    // Sensori che prevedono output digitale / Da completare il lancio dell'eccezione
    public TemperatureSensor (String partNumber, String manufacturer, double price, Range<Double> vs, SensorOutputType sot, LocalDate manifacturingDate, double tempResolution, double tempError, int bits) {
        super(partNumber, manufacturer, price, vs, sot, manifacturingDate);
        this.tempResolution = tempResolution;
        this.tempError = tempError;
        this.bits = bits;

        // set 0 to analog sensor related attributes
        this.outputSensitivity = 0;


        if (!(sot == SensorOutputType.DIGITAL || sot == SensorOutputType.I2C))
            throw new BadArgumentsForSensorTypeException();
    }

    // Sensori che prevedono output analogico / Da completare il lancio dell'eccezione
    public TemperatureSensor(String partNumber, String manufacturer, double price, Range<Double> vs, SensorOutputType sot, LocalDate manifacturingDate, double tempError, double outputSensitivity){
        super(partNumber, manufacturer,price,vs,sot,manifacturingDate);
        this.tempError = tempError;
        this.outputSensitivity = outputSensitivity;

        // set 0 to digital sensor related attributes
        this.tempResolution = 0;
        this.bits = 0;

        if (!(sot == SensorOutputType.ANALOG))
            throw new BadArgumentsForSensorTypeException();
    }
    public double getTempResolution(){
        return this.tempResolution;
    }
    public double getTempError() {
        return this.tempError;
    }
    public double getOutputSensitivity(){
        return this.outputSensitivity;
    }

    public int getBits(){
        return this.bits;
    }

    public boolean hasValidPartNumber() {
        // lunghezza non corrisponde
        if (super.getPartNumber() == null)
            return false;
        // i primi due caratteri non sono AD
        else if (!(super.getPartNumber().charAt(0) == 'A' && super.getPartNumber().charAt(1) =='D'))
            return false;
        // il terzo simbolo deve essere T o numero
        else{
            // caso: partNumber più lungo, terza lettera T + tutte cifre
            if (super.getPartNumber().length() == 7 && super.getPartNumber().charAt(2) == 'T') {
                for(int i = 3; i < 7; i++){
                    if (!(Character.isDigit(super.getPartNumber().charAt(i))))
                        return false;
                }
            } else if(super.getPartNumber().length() == 7 && super.getPartNumber().charAt(2) != 'T')
                return false;
            else if (super.getPartNumber().length() == 6) {
                for(int i = 2; i < 6; i++){
                    if(!(Character.isDigit(super.getPartNumber().charAt(i))))
                        return false;
                }
            } else
                return false;
        }
        return true;
    }

    // ToString() da completare
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();


        if (this.getSot() == SensorOutputType.ANALOG){
            str.append("***Analog Temperature Sensor***\n");
            str.append("Temperature Error (Deg)= ").append(this.tempError).append("\n");
            str.append("OutputSensitivity(mv/*C)= ").append(this.outputSensitivity).append("\n");
        }

        else {
            str.append("***Digital Temperature Sensor***\n");
            str.append("Temperature resolution(*/LSB)= ").append(this.tempResolution).append("\n");
            str.append("Temperature Error (Deg)= ").append(this.tempError).append("\n");
            str.append("Bits= ").append(this.bits).append("\n");
        }

        str.append(super.toString());

        str.append("\n");

        return str.toString();
    }
}

