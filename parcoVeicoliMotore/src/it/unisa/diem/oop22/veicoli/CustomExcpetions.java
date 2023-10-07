package it.unisa.diem.oop22.veicoli;

public class CustomExcpetions extends Exception {

    public static class InvalidPlateFormatException extends Exception {
        public InvalidPlateFormatException (String message){
            super(message);
        }
    }
}
