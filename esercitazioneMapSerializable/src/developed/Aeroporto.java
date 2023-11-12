package developed;

import java.io.*;
import java.util.Comparator;
import java.util.TreeMap;
import java.util.Map;
import java.util.TreeSet;

public class Aeroporto implements Serializable {
    private final CodeChecker checker;
    private final TreeMap<String, Aeromobile> aeroplani;
    public Aeroporto(CodeChecker checker){
        this.checker = checker;
        this.aeroplani = new TreeMap<String, Aeromobile>();
    }

    public boolean inserisci(Aeromobile a) {
        if(this.checker instanceof CodeCheckIT || this.checker instanceof CodeCheckEN) {
            if (this.checker.check(a.getCodice())) {
                this.aeroplani.put(a.getCodice(), a);
                return true;
            } else return false;
        } else {
            this.aeroplani.put(a.getCodice(), a);
            return true;
        }
    }

    public Aeromobile cerca(String codice) {
        // return shallow copy
        try {
            Aeromobile a = aeroplani.get(codice);
            if (a == null)
                return null;
            else {
                return (Aeromobile) a.clone();
            }
        } catch (CloneNotSupportedException e){
            return null;
        }
    }

    public Aeromobile rimuovi(String codice){
        return this.aeroplani.remove(codice);
    }

    public int elementi(){
        return this.aeroplani.size();
    }



    @Override
    public String toString() {
        Map<String, Aeromobile> sortedByProgNum = sortByProgrNum(this.aeroplani);
        StringBuilder sb = new StringBuilder();
        for (Aeromobile i : sortedByProgNum.values()){
            sb.append(i.toString());
        }
        return sb.toString();
    }

    public void salvaDOS(String nomefile) throws IOException {
        try(DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(nomefile+".bin")))){
            if (this.checker instanceof CodeCheckIT)
                dos.writeUTF("IT");
            else
                dos.writeUTF("EN");
            for(Map.Entry<String, Aeromobile> i : this.aeroplani.entrySet()){
                Aeromobile a = i.getValue();

                if(a instanceof Aliante) {
                    dos.writeUTF("Aliante");
                    dos.writeDouble(((Aliante) a).getEfficienza());
                }
                else {
                    dos.writeUTF("Aereo a motore");
                    dos.write(((AereoAMotore) a).getNumRotori());
                }

                // codice - numeroSequenziale
                dos.writeUTF(i.getKey());

                dos.write(a.getNumeroSequenziale());
            }
        }
        // non è necessario il blocco finally avendo usato try with resources
    }
    public static Aeroporto leggiDIS(String nomefile) throws IOException {
        Aeroporto a = null;
        try(DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(nomefile + ".bin")))){
            String temp = dis.readUTF();
            if (temp.equals("EN"))
                a = new Aeroporto(new CodeCheckEN());
            else
                a = new Aeroporto(new CodeCheckIT());
            while(true) {
                temp = dis.readUTF();
                if (temp.equals("Aliante")) {
                    double eff = dis.readDouble();
                    String codice = dis.readUTF();
                    int numSeq = dis.read();
                    a.aeroplani.put(codice, new Aliante(codice, eff, numSeq));
                } else {
                    int rotori = dis.read();
                    String codice = dis.readUTF();
                    int numSeq = dis.read();
                    a.aeroplani.put(codice, new AereoAMotore(codice, rotori, numSeq));
                }
                dis.close();
            }
        } catch (EOFException e) {
            System.out.println("Caricamento completato.\n");
        }
        return a;
    }
    public void salvaOBJ(String nomefile) throws IOException {
        try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(nomefile + ".bin")))){
            oos.writeObject(this);
        }
    }
    public static Aeroporto leggiOBJ(String nomefile) throws IOException, ClassNotFoundException{
        Aeroporto a = null;
        try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(nomefile + ".bin")))){
            a = (Aeroporto) ois.readObject();
        }
        return a;
    }

    public static <K, V extends Comparable<V>> Map<K, V> sortByProgrNum(final Map<K, V> map){
        Comparator<K> valueComparator = new Comparator<K>() {
            @Override
            public int compare(K o1, K o2) {
                return map.get(o1).compareTo(map.get(o2));
            }
        };
        Map<K, V> sortedByProgrNum = new TreeMap<K, V>(valueComparator);
        sortedByProgrNum.putAll(map);
        return sortedByProgrNum;
    }
}
