package it.unisa.diem.oop.developed.groupxx;
import it.unisa.diem.oop.provided.*;


public class Notebook extends Device implements Comparable<Device> {

    private final CPUType type;
    private final NBScreenType screenType;
    private final Boolean touchScreen;

    public Notebook(CPUType type, NBScreenType screenType, String serialNumber, int year, int month, int dayOfMonth, int RAMsize, int storageCapacity){
        super(serialNumber, year, month, dayOfMonth, RAMsize, storageCapacity);
        this.type = type;
        this.screenType = screenType;
        this.touchScreen = false;

    }
    public Notebook(CPUType type, NBScreenType screenType, boolean touchScreen, String serialNumber, int year, int month, int dayOfMonth, int RAMsize, int storageCapacity) {
        super(serialNumber, year, month, dayOfMonth, RAMsize, storageCapacity);
        this.type = type;
        this.screenType = screenType;
        this.touchScreen = touchScreen;
    }

    public CPUType getType(){
        return type;
    }
    public NBScreenType getScreenType(){
        return screenType;
    }
    public boolean hasTouchScreen(){
        return touchScreen;
    }
    @Override
    public String toString(){
        StringBuffer s= new StringBuffer();
        s.append(super.toString() + "CPU=" + type + "\nscreenType=" + screenType + "\n");
        if (hasTouchScreen())
            s.append("touchScreen available\n");
        String result = s.toString();
        return result;
    }

}

