package developed;

import java.io.Serializable;

public abstract class Aeromobile implements Cloneable, Serializable, Comparable<Aeromobile> {
    public static int seqnmbr = 0;
    private final String codice;
    private final int numeroSequenziale;
    public Aeromobile(String codice){
        this.codice = codice;
        this.numeroSequenziale = ++seqnmbr;
    }

    public Aeromobile(String codice, int numeroSequenziale){
        this.codice = codice;
        this.numeroSequenziale = numeroSequenziale;
    }

    public String getCodice() {
        return codice;
    }

    public int getNumeroSequenziale() {
        return numeroSequenziale;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Aeromobile n. " + numeroSequenziale + " - Codice = " + codice;
    }

    @Override
    public int compareTo(Aeromobile other){
        if (this.numeroSequenziale == other.getNumeroSequenziale())
            return 0;
        else return this.numeroSequenziale > other.getNumeroSequenziale() ? 1 : -1;
    }
}
