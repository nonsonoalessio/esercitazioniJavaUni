package groupxx;
import groupxx.provided.Range;
import groupxx.provided.SensorOutputType;

import java.time.LocalDate;
import java.lang.Comparable;
public abstract class Sensor implements Comparable<Sensor> {
    private final String partNumber;
    private final LocalDate manifacturingDate;
    private final String manufacturer;
    private final double price;
    private final SensorOutputType sot;
    private final Range<Double> vs;

    public Sensor(String partNumber, String manufacturer, double price, Range<Double> vs, SensorOutputType sot, LocalDate manifacturingDate){
        this.partNumber = partNumber;
        this.manufacturer = manufacturer;
        this.price = price;
        this.vs = vs;
        this.sot = sot;
        this.manifacturingDate = manifacturingDate;
    }
    public Range<Double> getVs(){
        return vs;
    }
    public String getPartNumber() {
        return partNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public boolean equals (Object other){
        if (this.getClass()==other.getClass()){
            Sensor altro = (Sensor)other;
            return other != null || (altro.getManufacturer().equals(altro.getManufacturer()));
        }
        return false;
    }
    @Override
    public int hashCode(){
        return 31*this.partNumber.hashCode();
    }

    public final int compareTo(Sensor o){
        return this.getPartNumber().compareToIgnoreCase(o.getPartNumber());
    }
    public SensorOutputType getSot(){
        return sot;
    }
    public LocalDate getManifacturingDate(){
        return manifacturingDate;
    }
    public abstract boolean hasValidPartNumber();
    @Override
    public String toString(){
        return "Part number= " + partNumber +
                "\nManufacturer= " + manufacturer +
                "\nPrice ($)= " + price +
                "\nVoltage range= " + vs.getLow() + " ~ " + vs.getHigh() +
                "\nOutput Type= " + sot +
                "\nManifacturing date= " + manifacturingDate + "\n";
    }
}
