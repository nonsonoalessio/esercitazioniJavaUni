package gruppoXX;
import java.util.ArrayList;

public class NetworkHub implements NetworkInterface{
    private final String id;
    private final ArrayList<NetworkInterface> connectedInterfaces;
    public NetworkHub(String id){
        this.id = id;
        connectedInterfaces = new ArrayList<>();
    }
    public String getId(){return this.id;}

    public void printConnections(){
        StringBuilder sb = new StringBuilder();
        sb.append("Connessioni di: ");
        sb.append(this);
        sb.append("\n");
        for(NetworkInterface c : this.connectedInterfaces){
            sb.append(c);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    @Override
    public void accept(NetworkInterface sourceInterface, int sourceAddress, int destAddress, String message){
        System.out.printf("%s: da %d via %s per %d: %s\n", this, sourceAddress, sourceInterface, destAddress, message);
        for(NetworkInterface nd : connectedInterfaces){
            if(!nd.equals(sourceInterface))
                nd.accept(this, sourceAddress, destAddress, message);
        }
    }

    @Override
    public void connect(NetworkInterface other) {
        this.connectedInterfaces.add(other);
    }

    @Override
    public boolean equals(Object other) {
        // check if other is null
        if (other == null)
            return false;
        else if (!(other instanceof NetworkHub))
            return false;
        else {
            return this.getId().equals(((NetworkHub) other).getId());
        }
    }

    @Override
    public int hashCode(){
        int hash = 0;
        for(int i = 0; i < this.getId().length(); i++){
            hash = 31 * (int) this.getId().charAt(i) + hash;
        }
        return hash;
    }

    @Override
    public String toString(){
        return "Hub " + this.getId().toString();
    }
}
