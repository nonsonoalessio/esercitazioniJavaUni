package it.unisa.diem.oop.developed.groupxx;

import java.time.LocalDate;
import java.util.Comparator;

public class DeviceReleaseDateComparator implements Comparator<Device> {
    public int compare(Device o1, Device o2) {
        LocalDate date1 = o1.getReleaseDate();
        LocalDate date2 = o2.getReleaseDate();
        int differenzaDate = date1.compareTo(date2);

        // caso: o1 > o2 -> return 1
        if (differenzaDate > 0)
            return 1;

            // caso o1 < o2 -> return -1
        else if (differenzaDate < 0)
            return -1;

            // caso o1 == o2 -> return 0 but overrided
        else {
            if(o1.getSerialNumber().compareToIgnoreCase(o2.getSerialNumber()) == 0)
                return 0;
            else if (o1.getSerialNumber().compareToIgnoreCase(o2.getSerialNumber()) > 0)
                return 1;
            else
                return -1;
        }
    }
}
