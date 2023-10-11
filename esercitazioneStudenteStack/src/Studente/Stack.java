package Studente;

import Exceptions.EmptyStackException;
import Exceptions.FullStackException;

@SuppressWarnings("FieldMayBeFinal")
public class Stack {
    private Studente[] studenti;
    private int count;
    private final int dim;


    public Stack() {
        studenti = new Studente[50];
        count = 0;
        dim = 50;
    }
    public Stack(int n) {
        studenti = new Studente[n];
        this.dim = n;
        this.count = 0;
    }
    public void push(Studente s) throws FullStackException{
        if (isFull()){
            throw new FullStackException();
        }
        studenti[count] = s;
        count++;
    }

    public Studente top() throws EmptyStackException{
        if (isEmpty()){
            throw new EmptyStackException("stack vuoto!");
        }
        return studenti[count];
    }
    public Studente pop() throws EmptyStackException{
        if (isEmpty()){
            throw new EmptyStackException("stack vuoto!");
        }
        Studente s = studenti[count];
        studenti[count] = null;
        count--;
        return s;
    }
    public  boolean isEmpty(){return this.count == 0;}
    public  boolean isFull(){return this.count == dim;}
}
