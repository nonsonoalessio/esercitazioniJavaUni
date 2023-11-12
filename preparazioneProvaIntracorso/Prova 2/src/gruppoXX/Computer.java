package gruppoXX;

public class Computer extends NetworkDevice{
    private final String name;
    public Computer(String name){
        super();
        this.name = name;
    }

    public String getName(){return this.name;}

    @Override
    public void process(int sourceAddress, String message){
        System.out.printf("%s ha ricevuto da %d: Dati risposta: %s\n", this, sourceAddress, message);
    }

    public void remoteFileAccessRequest(int serverAddress, String fileName){
        if (this.getConnection() == null)
            throw new NetworkException();
        this.getConnection().accept(this, this.getAddress(), serverAddress, "Accesso a " + fileName);

    }
    public void remotePrintRequest(int serverAddress, String fileName){
        if (this.getConnection() == null)
            throw new NetworkException();
        this.getConnection().accept(this, this.getAddress(), serverAddress, "Stampa di " + fileName);
    }

    @Override
    public String toString(){
        return super.toString() + ": Computer " + getName();
    }
}
