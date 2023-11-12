package groupxx;
import java.util.Comparator;

public class ManifacturingDateComparator implements Comparator<Sensor>{
    @Override
    public int compare(Sensor o1 ,  Sensor o2){
        return o1.getManifacturingDate().compareTo(o2.getManifacturingDate());
    }
}
