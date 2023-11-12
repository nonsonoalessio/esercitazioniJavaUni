/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupxx.provided;

/**
 *
 * @author lucagreco
 */
public class Range<T extends Number & Comparable> {
    
    private final T low;
    private final T high;

    public Range(T low, T high) {
        
        if (low.compareTo(high)>=0) throw new IllegalArgumentException("Bad range initialization.");
        
        this.low = low;
        this.high = high;
        
        
    }
    
    public boolean contains(T number) {

        return (number.compareTo(low)>=0 && number.compareTo(high)<=0);
  
    }

    public T getLow() {
        return low;
    }

    public T getHigh() {
        return high;
    }

    @Override
    public String toString() {
        return low + " ~ " + high;
    }
    
    
    
    
}
