package it.unisa.diem.oop.developed.groupxx;
import it.unisa.diem.oop.provided.DeviceFilter;

public class NotebookFilter implements DeviceFilter {
    @Override
    public boolean checkDevice(Device d) {
        return d instanceof Notebook;
    }
}
