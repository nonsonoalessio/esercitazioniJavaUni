package it.unisa.diem.oop.developed.groupxx;
import it.unisa.diem.oop.provided.DeviceFilter;

public class HighStorageDeviceFilter implements DeviceFilter {
    private int minSize;
    public HighStorageDeviceFilter(int minSize){
        this.minSize = minSize;
    }

    @Override
    public boolean checkDevice(Device d) {
        return d.getStorageCapacity() >= this.minSize;
    }
}
