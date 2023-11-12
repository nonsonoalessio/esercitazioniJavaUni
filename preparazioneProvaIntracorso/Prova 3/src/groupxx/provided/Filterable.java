/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupxx.provided;

import groupxx.Sensor;
import groupxx.SensorKit;

import java.util.Comparator;

/**
 *
 * @author lucagreco
 */
public interface Filterable {
    
    SensorKit filter(SensorFilter sf, Comparator<Sensor> c);
    
}
