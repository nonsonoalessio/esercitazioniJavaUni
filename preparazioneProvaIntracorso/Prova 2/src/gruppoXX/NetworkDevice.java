package gruppoXX;


public abstract class NetworkDevice implements NetworkInterface {
    private final int address;
    public static int numberOfDevices = 0;
    private NetworkInterface connection;
    public NetworkDevice(){
        this.address = ++numberOfDevices;
        this.connection = null;
    }

    @Override
    public void accept(NetworkInterface sourceInterface, int sourceAddress, int destAddress, String message){
        // controllo se il messaggio è rivolto a questo device
        if(destAddress == this.address)
            process(sourceAddress, message);
    }
    @Override
    public void connect(NetworkInterface other){
        this.connection = other;
    }
    @Override
    public boolean equals(Object other){
        if(other == null) return false;
        else if(!(other instanceof NetworkDevice)) return false;
        else{
            return this.getAddress() == ((NetworkDevice) other).getAddress();
        }
    }
    public int getAddress(){return this.address;}
    public NetworkInterface getConnection(){return this.connection;}
    public int hashCode(){
        return 31 * this.getAddress();
    }

    public abstract void process(int sourceAddress, String message);

    @Override
    public String toString(){
        return "Device " + this.address;
    }
}