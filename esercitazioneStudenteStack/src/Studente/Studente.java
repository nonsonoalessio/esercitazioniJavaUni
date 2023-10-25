package Studente;

@SuppressWarnings("FieldMayBeFinal")
public class Studente{
    private String nome;
    private String matricola;
    private double votoMedio;

    /*###########costruttori#########*/
    public  Studente(String nome, String matricola, double votoMedio) {
        this.nome = nome;
        this.matricola = matricola;
        this.votoMedio = votoMedio;
    }
    @Override
    public String toString() {
        return "nome: " + nome + " - matricola: " + matricola + " - votoMedio: " + votoMedio + ".\n\n" ;
    }
}
