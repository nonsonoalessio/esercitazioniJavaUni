package gruppoXX;

public class FileServer extends NetworkDevice {

    public FileServer(){
        super();
}

    public void process(int sourceAddress, String message){
        if (super.getConnection() != null){
            System.out.println("Device " + super.getAddress() + ": File Server: Su richiesta di " + sourceAddress + ": " + message);
            getConnection().accept(this, this.getAddress(), sourceAddress, message);
        } else{
            throw new NetworkException("Interfaccia non connessa!");
        }
}

public String toString(){
    return "Device " + super.getAddress() + ": File server";
}


}

