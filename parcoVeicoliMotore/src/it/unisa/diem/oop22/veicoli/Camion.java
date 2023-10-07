// Written by: Giura Alessio Donato

package it.unisa.diem.oop22.veicoli;

public class Camion extends Veicolo {
    private int numeroAssi;

    public Camion(String numTelaio, String modello, String alimentazione, String targa, int numeroAssi) {
        super(numTelaio, modello, alimentazione, targa);
        this.numeroAssi = numeroAssi;
    }

    public int getNumeroAssi() {
        return numeroAssi;
    }

    @Override
    public boolean controllaTarga(){
        try{
            // formato targa: LL - NNN'NNN
            String tg = getTarga();
            if (Character.isDigit(tg.charAt(0))) throw new CustomExcpetions.InvalidPlateFormatException("Formato della targa non valido!");
            if (Character.isDigit(tg.charAt(1))) throw new CustomExcpetions.InvalidPlateFormatException("Formato della targa non valido!");

            if (Character.isLetter(tg.charAt(2))) throw new CustomExcpetions.InvalidPlateFormatException("Formato della targa non valido!");
            if (Character.isLetter(tg.charAt(3))) throw new CustomExcpetions.InvalidPlateFormatException("Formato della targa non valido!");
            if (Character.isLetter(tg.charAt(4))) throw new CustomExcpetions.InvalidPlateFormatException("Formato della targa non valido!");
            if (Character.isLetter(tg.charAt(5))) throw new CustomExcpetions.InvalidPlateFormatException("Formato della targa non valido!");
            if (Character.isLetter(tg.charAt(6))) throw new CustomExcpetions.InvalidPlateFormatException("Formato della targa non valido!");

        } catch (CustomExcpetions.InvalidPlateFormatException e) {
            return false;
        }
        return true;
    }

    @Override
    public String toString(){
        return "Telaio = " + getNumTelaio() + ", Modello = " + getModello() + ", Alimentazione = " + getAlimentazione() + ", Targa = " + getTarga() + ", Numero Assi = " + getNumeroAssi() + ".\n";
    }
}
