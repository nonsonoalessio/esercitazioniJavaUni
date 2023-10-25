package it.unisa.diem.oop22.box;
import it.unisa.diem.oop22.box.BoxCustExceptions.AutorimessaPienaException;
import it.unisa.diem.oop22.box.BoxCustExceptions.AutorimessaVuotaException;
import it.unisa.diem.oop22.box.BoxCustExceptions.TargaNonValidaException;
import it.unisa.diem.oop22.veicoli.*;

public class Autorimessa extends Box{
    private Veicolo[] veicoli;
    private int testa;
    private int coda;
    private int riemp;

    public Autorimessa(int maxPosti, String nome) {
        super(maxPosti, nome);
        this.veicoli = new Veicolo[maxPosti];
        this.testa = 0;
        this.coda = 0;
        this.riemp = 0;
    }

    private boolean autorimessaPiena(){ return riemp == maxPosti; }
    private boolean autorimessaVuota(){ return riemp == 0; }
    @Override
    public void entra(Veicolo v) throws AutorimessaPienaException, TargaNonValidaException {
        if (!v.controllaTarga())
            throw new TargaNonValidaException();
        if (autorimessaPiena())
            throw new AutorimessaPienaException();
        else {
            riemp++;
            veicoli[coda] = v;
            coda = (coda + 1) % maxPosti;
        }
    }
    @Override
    public Veicolo esce() throws AutorimessaVuotaException {
        if(autorimessaVuota())
            throw new AutorimessaVuotaException();
        Veicolo v = veicoli[testa];
        veicoli[testa] = null;
        testa = (testa + 1) % maxPosti;
        riemp--;
        return v;
    }

    @Override
    public String toString(){
        String s = "";
        s = s + super.toString() + "\n";
        for(Veicolo i : veicoli){
            if(i != null)
                s = s + i.toString();
        }
        return s;
    }
}


