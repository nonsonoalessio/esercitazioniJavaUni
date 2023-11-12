package it.unisa.diem.oop.developed.groupxx;

public class DeviceInsertionException extends RuntimeException{
    public DeviceInsertionException(){
        super("non puoi inserire un altro device");
    }
    public DeviceInsertionException(String errorMessage){
        super(errorMessage);
    }
}
