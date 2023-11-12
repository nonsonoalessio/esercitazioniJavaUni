package gruppoXX;

public class NetworkException extends RuntimeException {
    public NetworkException(){
        super("Errore rilevato");
    }
    public NetworkException(String errorMessage){
        super(errorMessage);
    }

}
