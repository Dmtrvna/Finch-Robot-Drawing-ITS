package finchonline;

import java.util.Objects;

/**
 *
 * @author victo
 */
public class FinchSensorState {
    private int leftLineSensor = 0;
    private int rightLineSensor = 0;
    private int distance = 0;   
    
    public synchronized int getLeftLineSensor() {
        return leftLineSensor;
    }
    
    public synchronized void setLeftLineSensor(int value) {
        leftLineSensor = value;
    }
    
    public synchronized int getRightLineSensor() {
        return rightLineSensor;
    }
    
    public synchronized void setRightLineSensor(int value) {
        rightLineSensor = value;
    }  
    
    public synchronized int getDistance() {
        return distance;
    }
    
    public synchronized void setDistance(int value) {
        distance = value;
    } 
    
    public synchronized boolean isLeftLineSensorChanged(FinchSensorState value) {
        return leftLineSensor != value.leftLineSensor;
    }
    
    public synchronized boolean isRightLineSensorChanged(FinchSensorState value) {
        return rightLineSensor != value.rightLineSensor;
    }
    
    public synchronized boolean isDistanceChanged(FinchSensorState value) {
        return distance != value.distance;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || !(obj instanceof FinchSensorState)) { 
            return false; 
        }  
        
        FinchSensorState f = (FinchSensorState) obj;
                
        return (getLeftLineSensor() == f.getLeftLineSensor()) && 
               (getRightLineSensor() == f.getRightLineSensor()) && 
               (getDistance() == f.getDistance());         
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(getLeftLineSensor(), getRightLineSensor(), getDistance());
    }
    
    @Override
    public String toString() {
        return "" + getLeftLineSensor() + " " + getRightLineSensor() + " " + getDistance();
    }
}
