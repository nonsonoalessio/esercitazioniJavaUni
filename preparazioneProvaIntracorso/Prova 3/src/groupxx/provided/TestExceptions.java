/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupxx.provided;

import groupxx.Accelerometer;
import groupxx.BadSensorPartNumberException;
import groupxx.Sensor;
import groupxx.SensorKit;
import groupxx.TemperatureSensor;
import groupxx.provided.SensorOutputType;
import groupxx.provided.Range;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucagreco
 */
public class TestExceptions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        Sensor a1 = new Accelerometer("ADXL371", "Analog Devices", 7.63, new Range(1.1,3.6), SensorOutputType.I2C, LocalDate.of(2022, 3, 22), 200.0, 3, 3.2 );
        Sensor a2 = new Accelerometer("ADS16209", "Analog Devices", 42.20, new Range(3.0,3.6), SensorOutputType.SPI, LocalDate.of(2022, 4, 25), 180.0, 3, 0.05 );
        Sensor a3 = new Accelerometer("ADXL206", "Analog Devices", 575.29, new Range(4.75,5.25), SensorOutputType.ANALOG, LocalDate.of(2022, 1, 13), 5, 2, 0.4 );
        
        SensorKit ssc = new SensorKit("Sensor Shopping Cart");

        try {
            ssc.add(a1);
            ssc.add(a2);
            ssc.add(a3);
        } catch (BadSensorPartNumberException ex) {
            ex.printStackTrace();
        }

        try {
            Sensor t5 = new TemperatureSensor("ADT7410", "Analog Devices", 1.67, new Range(2.7, 5.5), SensorOutputType.ANALOG, LocalDate.of(2022, 1, 13), 0.0078, 0.5, 16);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try {
            Sensor t6 = new TemperatureSensor("AD8494", "Analog Devices", 2.78, new Range(2.7, 36.0), SensorOutputType.PWM, LocalDate.of(2022, 3, 13), 1.0, 5.0);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    
}
