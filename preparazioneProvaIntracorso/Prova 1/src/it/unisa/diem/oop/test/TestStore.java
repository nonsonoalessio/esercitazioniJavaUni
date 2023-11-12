package it.unisa.diem.oop.test;


import it.unisa.diem.oop.developed.groupxx.Smartphone;
import it.unisa.diem.oop.developed.groupxx.DeviceStore;
import it.unisa.diem.oop.developed.groupxx.Notebook;
import it.unisa.diem.oop.developed.groupxx.Device;
import it.unisa.diem.oop.provided.NBScreenType;
import it.unisa.diem.oop.provided.MobileCPUType;
import it.unisa.diem.oop.provided.CPUType;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lucagreco
 */
public class TestStore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        
        Device d1 = new Notebook(CPUType.i3_10110U, NBScreenType.FHD_13inch, "CY2WWN23", 2017,6, 30, 8, 128);
        
        Device d2 = new Notebook(CPUType.i5_1135G7, NBScreenType.FHD_15inch, true, "CY2WPN23", 2018,7,3, 8, 256);
        
        Device d3 = new Notebook(CPUType.i7_1165G7, NBScreenType.UHD_13inch, "CZ2WTN40", 2019,6,30, 16, 512);
        
        Device d4 = new Notebook(CPUType.i9_10885H, NBScreenType.UHD_15inch, true, "CZ3WTN40", 2020,7,20, 16, 512 );
        
        
        Device d5 = new Smartphone(MobileCPUType.kirin_820, (float) 6.7, "DWW2HJ40", 2018,6,15, 2, 64);
        
        Device d6 = new Smartphone(MobileCPUType.kirin_9000, (float) 6.7, "DWW2HJ39", 2019, 5, 20, 4, 64);
        
        DeviceStore store = new DeviceStore("MyStore");
        
        store.addDevice(d1);
        store.addDevice(d2);
        store.addDevice(d3);
        store.addDevice(d4);
        store.addDevice(d5);
        store.addDevice(d6);
        
        
        System.out.println(store);
        
        
    }
    
}
