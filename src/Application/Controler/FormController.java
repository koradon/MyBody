package application.controler;

import application.model.Body;
import application.model.BodyHistory;

/**
 * Created by Michał on 17.03.2016.
 */
public class FormController {

    private static BodyHistory bodyHistory = new BodyHistory();


    public static boolean saveBodyData(Body body){
        try{
            if(bodyHistory.addActualBody(body)){
                bodyHistory.printBH();
                return true;
            }else{
                System.out.println("Failed to save data!");
                return false;
            }

        }catch (Exception e){
            return false;
        }

    }

    public static boolean saveBodyData(double weight,
                                        double hight,
                                        double neckCircuit,
                                        double chestCircuit,
                                        double bicepsCircuit,
                                        double waistCircuit,
                                        double abdomenCircuit,
                                        double hipsCircuit,
                                        double thighCircuit,
                                        double calfCircuit){

                try{
                    Body body = new Body(weight,
                            hight,
                            neckCircuit,
                            chestCircuit,
                            bicepsCircuit,
                            waistCircuit,
                            abdomenCircuit,
                            hipsCircuit,
                            thighCircuit,
                            calfCircuit);

                    BodyHistory bh = new BodyHistory();

                    if(bh.addActualBody(body)){
                        bh.printBH();
                        return true;
                    }else{
                        return false;
                    }
                }catch (Exception e){
                    return false;
                }

            }

    public static BodyHistory getBodyHistory(){
        return bodyHistory;
    }
}
