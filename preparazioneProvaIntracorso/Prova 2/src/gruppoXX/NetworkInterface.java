package gruppoXX;

public interface NetworkInterface {
    void accept(NetworkInterface sourceInterface, int sourceAddress, int destAddress, String message);
    void connect(NetworkInterface other);
}
