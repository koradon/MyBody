package application.model.body;

import application.model.body.Body;

/**
 * Created by Michał on 26.03.2016.
 */
public class BodyParams {
    public static double calculateBMI(Body body){
        double bmi = body.getWeight()/(Math.pow(body.getHeight()/100,2));
        System.out.println("Your BMI is: " + bmi);
        return bmi;
    }

    public static double waistHipRatio(Body body){
        double wHR = body.getWaistCircuit()/body.getHipsCircuit();
        System.out.println("Your WHR is: " + wHR);
        return wHR;
    }

    public static void pomiarGrubościFałdowTluszczowych(Body body){

    }
}
