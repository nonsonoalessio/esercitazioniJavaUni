package it.unisa.diem.oop.developed.groupxx;

import it.unisa.diem.oop.provided.*;

import java.util.Comparator;
import java.util.TreeSet;

public class DeviceStore implements Filterable {
    private String name;
    private TreeSet<Device> devices;
    private Comparator<Device> comparator;

    public DeviceStore(String name) {
        this.name = name;
        this.devices = new TreeSet<Device>();
        this.comparator = null;
    }

    public DeviceStore(String name, Comparator<Device> c) {
        this.name = name;
        this.devices = new TreeSet<Device>(c);
        this.comparator = c;
    }

    public String getName() {
        return name;
    }

    public void addDevice(Device d) {
        if (this.devices.contains(d))
            throw new DeviceInsertionException();
        this.devices.add(d);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" contains ").append(devices.size()).append(" items.\n").append("Printing\n");
        for (Device device : devices) //noinspection SingleStatementInBlock
        {
            sb.append("*****\n" + device.toString());
        }
        return sb.toString();
    }

    public DeviceStore filter(DeviceFilter d, Comparator<Device> c) {
        DeviceStore newStore;
        if (c == null)
            newStore = new DeviceStore(this.getName());
        else
            newStore = new DeviceStore(this.getName(), c);

        for (Device o : this.devices)
            if (d.checkDevice(o)) newStore.addDevice(o);

        return newStore;
    }
}
