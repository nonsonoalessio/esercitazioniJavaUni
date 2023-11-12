package it.unisa.diem.oop.developed.groupxx;
import it.unisa.diem.oop.provided.*;

public class Smartphone extends Device {
    private final MobileCPUType cpu;
    private final float screenSizeInch;
    public Smartphone(MobileCPUType cpu, float screenSizeInch, String serialNumber, int year, int month, int dayOfMonth, int RAMsize, int storageCapacity){
        super(serialNumber, year, month, dayOfMonth, RAMsize, storageCapacity);
        this.cpu = cpu;
        this.screenSizeInch = screenSizeInch;
    }
    public float getScreenSizeInch(){return screenSizeInch;}

    public MobileCPUType getCpu(){return cpu;}

    public boolean hasTouchScreen(){return true;}

    @Override
    public String toString(){
        StringBuffer s = new StringBuffer();
        s.append(super.toString() + "CPU= " + cpu + "\nscreenSizeInch= " + screenSizeInch + "\n");
        String result = s.toString();
        return result;
    }
}
