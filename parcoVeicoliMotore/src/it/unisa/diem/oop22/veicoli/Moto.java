// Written by: Giura Alessio Donato

package it.unisa.diem.oop22.veicoli;

@SuppressWarnings("FieldMayBeFinal")
public class Moto extends Veicolo {
    private boolean guidaLibera;

    public Moto(String numTelaio, String modello, String alimentazione, String targa, boolean guidaLibera) {
        super(numTelaio, modello, alimentazione, targa);
        this.guidaLibera = guidaLibera;
    }

    public boolean getGuidaLibera(){
        return this.guidaLibera;
    }

    @Override
    public boolean controllaTarga(){
        boolean value = true;
        try{
            // formato targa: LL - NN'NNN
            String tg = getTarga();
            if (Character.isDigit(tg.charAt(0))) throw new CustomExcpetions.InvalidPlateFormatException("Formato della targa non valido!");
            if (Character.isDigit(tg.charAt(1))) throw new CustomExcpetions.InvalidPlateFormatException("Formato della targa non valido!");

            if (Character.isLetter(tg.charAt(2))) throw new CustomExcpetions.InvalidPlateFormatException("Formato della targa non valido!");
            if (Character.isLetter(tg.charAt(3))) throw new CustomExcpetions.InvalidPlateFormatException("Formato della targa non valido!");
            if (Character.isLetter(tg.charAt(4))) throw new CustomExcpetions.InvalidPlateFormatException("Formato della targa non valido!");
            if (Character.isLetter(tg.charAt(5))) throw new CustomExcpetions.InvalidPlateFormatException("Formato della targa non valido!");
            if (Character.isLetter(tg.charAt(6))) throw new CustomExcpetions.InvalidPlateFormatException("Formato della targa non valido!");
        } catch (CustomExcpetions.InvalidPlateFormatException e) {
            value = false;
        }
        return value;
    }

    @Override
    public String toString(){
        return "Telaio = " + getNumTelaio() + ", Modello = " + getModello() + ", Alimentazione = " + getAlimentazione() + ", Targa = " + getTarga() + ", Guida libera = " + getGuidaLibera() + ".\n";

    }
}
