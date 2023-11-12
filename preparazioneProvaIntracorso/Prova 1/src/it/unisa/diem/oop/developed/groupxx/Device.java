package it.unisa.diem.oop.developed.groupxx;

import java.time.LocalDate;
import java.util.Comparator;

public abstract class Device implements Comparable<Device> {
    private String serialNumber;
    private LocalDate releaseDate;
    private int RAMsize;
    private int storageCapacity;

    public Device(String serialNumber, int year, int month, int dayOfMonth, int RAMsize, int storageCapacity){
        this.serialNumber = serialNumber;
        this.releaseDate = LocalDate.of(year, month, dayOfMonth);
        this.RAMsize = RAMsize;
        this.storageCapacity = storageCapacity;
    }
    public String getSerialNumber(){
        return serialNumber;
    }
    public LocalDate getReleaseDate(){
        return releaseDate;
    }
    public int getRAMsize(){
        return RAMsize;
    }
    public int getStorageCapacity(){
        return storageCapacity;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        for(int i = 0; i < this.serialNumber.length(); i++)
            hash = hash * 31 + (int) serialNumber.charAt(i);
        return hash;
    }

    public boolean equals(Object other) {
        if (other == null)
            return false;
        else{
            if(!(other instanceof Device))
                return false;
            else
                return this.serialNumber.equalsIgnoreCase(((Device) other).serialNumber);
        }
    }
    public String toString(){
        StringBuilder str = new StringBuilder();
        if(this instanceof Smartphone)
            str.append("Smartphone\n");
        else if(this instanceof Notebook)
            str.append("Notebook\n");
        str.append("serialNumber= " + serialNumber + "\nreleaseDate= " + releaseDate + "\nRAMsize= " + RAMsize + "GB\nstorageCapacity= " + storageCapacity + "GB\n");
        return str.toString();
    }

    public abstract boolean hasTouchScreen();
    public final int compareTo(Device o){
        return this.serialNumber.compareToIgnoreCase(o.serialNumber);
    }
}
