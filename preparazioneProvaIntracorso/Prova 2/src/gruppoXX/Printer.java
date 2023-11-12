package gruppoXX;

public class Printer extends NetworkDevice {
    public Printer(){
        super();
    }


    public void process(int sourceAddress, String message){
        String str ="Device " + super.getAddress() + ": Printer: Su richiesta di " + sourceAddress + ": " + message;
        System.out.println(str);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Device " + super.getAddress() + ": Printer"); // Dove trovo l indirizzo da inserire?
        String fin = str.toString();
        return fin;    }
}

