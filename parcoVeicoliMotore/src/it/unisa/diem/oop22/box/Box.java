package it.unisa.diem.oop22.box;

import it.unisa.diem.oop22.veicoli.*;
import it.unisa.diem.oop22.box.BoxCustExceptions.*;

public abstract class Box {
    public final int maxPosti;
    private final String nome;

    public Box(int maxPosti, String nome) {
        this.maxPosti = maxPosti;
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }
    public abstract void entra(Veicolo v) throws AutorimessaPienaException, TargaNonValidaException;

    public abstract Veicolo esce() throws AutorimessaVuotaException;
    @Override
    public String toString(){
        return "Nome box=" + getNome() + ", Capienza= " + maxPosti + "\n";
    }
}
