package developed;

public class AereoAMotore extends Aeromobile {
    private final int numRotori;
    public AereoAMotore(String codice, int numRotori){
        super(codice);
        this.numRotori = numRotori;
    }

    public AereoAMotore(String codice, int numRotori, int numeroProgressivo){
        super(codice, numeroProgressivo);
        this.numRotori = numRotori;
    }

    public int getNumRotori() {
        return numRotori;
    }

    @Override
    public String toString() {
        return super.toString() + " - Tipo = Aereo a Motore - Numero rotori = " + numRotori + "\n";
    }
}
