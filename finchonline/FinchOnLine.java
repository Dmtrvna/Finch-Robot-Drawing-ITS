package finchonline;

import BirdBrainJava.Finch;

/**
 *
 * @author victo
 */
public class FinchOnLine {
    public static void main(String[] args) {
        System.out.println("Hello");
        Finch myFinch = new Finch("A");
        System.out.println("BirdBrainJava.Finch has connected!");
        
        
        int speedValue = Constants.MAXSPEEDVALUE;
        int lSpeed = speedValue;
        int rSpeed = speedValue;
        boolean isFinchStopped = false;
        int currDistance = 0;
        
        FinchSensorState finchSensorState = new FinchSensorState();
        
         while (!isFinchStopped) {
            finchSensorState.setLeftLineSensor(myFinch.getLine("L"));
            finchSensorState.setRightLineSensor(myFinch.getLine("R"));
            finchSensorState.setDistance(myFinch.getDistance());
            System.out.println(finchSensorState); 
            
            currDistance = finchSensorState.getDistance();
            if (currDistance >= Constants.DISTANCEONE) {
                speedValue = Constants.MAXSPEEDVALUE;                
            } else if (currDistance < Constants.DISTANCEONE && currDistance > Constants.DISTANCETWO) {
                speedValue = Constants.MAXSPEEDVALUE / 2;
            } else {
                speedValue = 0;
            }
                
            
            if ( finchSensorState.getLeftLineSensor() >= Constants.FINCHLEFTRIGHTSENSORBLACKVALUE && 
                 finchSensorState.getRightLineSensor() >= Constants.FINCHLEFTRIGHTSENSORBLACKVALUE ) {
                // LR Sensors on white
                lSpeed = speedValue; 
                rSpeed = speedValue;
            } else if ( finchSensorState.getLeftLineSensor() < Constants.FINCHLEFTRIGHTSENSORBLACKVALUE && 
                        finchSensorState.getRightLineSensor() < Constants.FINCHLEFTRIGHTSENSORBLACKVALUE ) {
                // LR Sensors on black
                lSpeed = speedValue; 
                rSpeed = speedValue;
            } else if ( finchSensorState.getLeftLineSensor() < Constants.FINCHLEFTRIGHTSENSORBLACKVALUE && 
                        finchSensorState.getRightLineSensor() >= Constants.FINCHLEFTRIGHTSENSORBLACKVALUE ) {
                // L sensor black, R sensor white
                if (lSpeed - Constants.SPEEDCHANGEVALUE > 0) {
                    lSpeed = lSpeed - Constants.SPEEDCHANGEVALUE;
                    rSpeed = rSpeed + Constants.SPEEDCHANGEVALUE;
                }
            } else if ( finchSensorState.getLeftLineSensor() >= Constants.FINCHLEFTRIGHTSENSORBLACKVALUE && 
                        finchSensorState.getRightLineSensor() < Constants.FINCHLEFTRIGHTSENSORBLACKVALUE ) {
                // L sensor white, R sensor black
                if (rSpeed - Constants.SPEEDCHANGEVALUE > 0) {
                    lSpeed = lSpeed + Constants.SPEEDCHANGEVALUE;
                    rSpeed = rSpeed - Constants.SPEEDCHANGEVALUE;
                }
            }
             
            myFinch.setMotors(lSpeed, rSpeed);
            
            
            try {
                Thread.sleep(Constants.FINCHSENSORSUPDATELOOPPERIOD);
            }
            catch (InterruptedException e) {
                System.out.println("Sleep error!");            
            }            
         }
        
         myFinch.stopAll();
         myFinch.disconnect();
        
    }    
}
