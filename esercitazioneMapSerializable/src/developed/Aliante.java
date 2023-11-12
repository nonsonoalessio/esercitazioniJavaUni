package developed;

public class Aliante extends Aeromobile {
    private final double efficienza;
    public Aliante(String codice, double efficienza){
        super(codice);
        this.efficienza = efficienza;
    }

    public Aliante(String codice, double efficienza, int numeroProgressivo){
        super(codice, numeroProgressivo);
        this.efficienza = efficienza;
    }


    public double getEfficienza(){
        return this.efficienza;
    }

    @Override
    public String toString() {
        return super.toString() + " - Tipo = Aliante - Efficienza = " + efficienza + "\n";
    }

}
