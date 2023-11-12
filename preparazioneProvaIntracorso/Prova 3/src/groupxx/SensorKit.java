package groupxx;

import groupxx.provided.Filterable;
import groupxx.provided.SensorFilter;
import java.lang.Iterable;
import java.util.Iterator;
import java.util.Comparator;
import java.util.LinkedList;

public class SensorKit implements Filterable, Iterable<Sensor> {
    private final String name;
    private final LinkedList<Sensor> sensorList;

    public SensorKit(String name){
        this.name = name;
        this.sensorList = new LinkedList<>();
    }

    public void add(Sensor s) throws BadSensorPartNumberException{
        if(!s.hasValidPartNumber())
            throw new BadSensorPartNumberException();
        this.sensorList.add(s);
    }

    public void remove(Sensor s){
        if(!(this.sensorList == null))
            this.sensorList.remove(s);
    }

    public void sort(Comparator<Sensor> c){
        sensorList.sort(c);
    }

    public Iterator<Sensor> iterator(){
        return sensorList.iterator();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("This ").append(this.name).append(" contains ").append(this.sensorList.size()).append(" sensors.\n");
        for (Sensor s : sensorList)
            sb.append(s.toString());
        return sb.toString();
    }

    public SensorKit filter(SensorFilter f, Comparator<Sensor> c){
        SensorKit filteredKit = new SensorKit("Filtered Sensor Kit");
        for(Sensor s : this.sensorList) {
            if (f.checkSensor(s)) {
                try {
                    filteredKit.add(s);
                } catch(BadSensorPartNumberException e){
                    System.out.println("Sensore non aggiunto per BadPartNumber.\n");
                }
            }
        }

        if(c != null)
            filteredKit.sort(c);

        return filteredKit;
    }

}
