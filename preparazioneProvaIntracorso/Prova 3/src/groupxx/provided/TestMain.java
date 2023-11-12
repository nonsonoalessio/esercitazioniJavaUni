/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupxx.provided;

import groupxx.Accelerometer;
import groupxx.I2CSensorFilter;
import groupxx.LSMinOperatingTemperatureFilter;
import groupxx.LightSensor;
import groupxx.ManifacturingDateComparator;
import groupxx.BadSensorPartNumberException;
import groupxx.Sensor;
import groupxx.SensorKit;
import groupxx.SourceVoltageFilter;
import groupxx.TemperatureSensor;
import groupxx.provided.SensorOutputType;
import groupxx.provided.LightSensorType;
import groupxx.provided.Range;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TestMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Sensor a1 = new Accelerometer("ADXL371", "Analog Devices", 7.63, new Range(1.1,3.6), SensorOutputType.I2C, LocalDate.of(2022, 3, 22), 200.0, 3, 3.2 );
        Sensor a2 = new Accelerometer("ADIS16209", "Analog Devices", 42.20, new Range(3.0,3.6), SensorOutputType.SPI, LocalDate.of(2022, 4, 25), 180.0, 3, 0.05 );
        Sensor a3 = new Accelerometer("ADXL206", "Analog Devices", 575.29, new Range(4.75,5.25), SensorOutputType.ANALOG, LocalDate.of(2022, 1, 13), 5, 2, 0.4 );
        
        Sensor t4 = new TemperatureSensor("ADT7320", "Analog Devices", 3.65, new Range(2.7,5.5), SensorOutputType.DIGITAL, LocalDate.of(2022,3, 13),0.0078, 0.25, 16);
        Sensor t5 = new TemperatureSensor("ADT7410", "Analog Devices", 1.67, new Range(2.7,5.5), SensorOutputType.I2C, LocalDate.of(2022, 1, 13),0.0078, 0.5, 16);
        Sensor t6 = new TemperatureSensor("AD8494", "Analog Devices", 2.78, new Range(2.7,36.0), SensorOutputType.ANALOG, LocalDate.of(2022, 3, 13), 1.0, 5.0);
        Sensor t7 = new TemperatureSensor("AD8497", "Analog Devices", 1.67, new Range(2.7,36.0), SensorOutputType.ANALOG, LocalDate.of(2022, 8, 13), 1.0, 5.0);
        
        Sensor l8 = new LightSensor("APDS9306065", "Broadcom Limited", 1.84, new Range(1.7,3.6), SensorOutputType.I2C, LocalDate.of(2022, 9, 13), 560, false, new Range(40.0,85.0), LightSensorType.AMBIENT);
        Sensor l9 = new LightSensor("VCNL3040", "Vishay Semiconductor", 2.26, new Range(2.5,3.6), SensorOutputType.I2C, LocalDate.of(2022, 7, 25), 850, true, new Range(25.0,85.0), LightSensorType.IR);
        Sensor l10 = new LightSensor("VCNL4200", "Vishay Semiconductor", 3.91, new Range(2.5,3.6), SensorOutputType.I2C, LocalDate.of(2022, 2, 25), 550, true, new Range(40.0,85.0), LightSensorType.AMBIENT);
        
        SensorKit ssc = new SensorKit("Sensor Kit");
       
        try {
            
            ssc.add(a1);
            ssc.add(a2);
            ssc.add(a3);
            ssc.add(t4);
            ssc.add(t5);
            ssc.add(t6);
            ssc.add(t7);
            ssc.add(l8);
            ssc.add(l9);
            ssc.add(l10);

        } catch (BadSensorPartNumberException ex) {
            Logger.getLogger(TestMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("--> TESTING SENSOR KIT <--");
        System.out.println(ssc);
        System.out.println();
        
        System.out.println("--> TESTING I2C FILTER with MANIFACTURING DATE ORDERING ASCENDENT <--");
        SensorKit ssc1 = ssc.filter(new I2CSensorFilter(), new ManifacturingDateComparator());
        System.out.println(ssc1);
        System.out.println();
        
        System.out.println("--> TESTING SOURCE VOLTAGE FILTER 30V <--");
        SensorKit ssc2 = ssc.filter(new SourceVoltageFilter(30.0), null);
        System.out.println(ssc2);
        System.out.println();
        
         System.out.println("--> TESTING MIN OPERATING FILTER 25°C <--");
        SensorKit ssc3 = ssc.filter(new LSMinOperatingTemperatureFilter(25.0), null);
        System.out.println(ssc3);
        System.out.println();
        
        
   
        
        
        

      
        
        
    }
    
}
