package application.view.windows.swing.addNewBodyToDatabase;

import application.model.body.Body;
import application.model.body.BodyHistory;

/**
 * Created by Michał on 17.03.2016.
 */
public class AddNewBodyToDatabaseController {

    private static BodyHistory bodyHistory = new BodyHistory();

    public static boolean addNewBodyToDatabase(Body body){
        try{
            if(bodyHistory.updateBody(body)){
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

    public static boolean addNewBodyToDatabase(double weight,
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

                    BodyHistory bodyHistory = new BodyHistory();

                    if(bodyHistory.updateBody(body)){
                        bodyHistory.printBH();

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
