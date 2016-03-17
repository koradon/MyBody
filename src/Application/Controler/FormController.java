package Application.Controler;

import Application.Model.Body;
import Application.Model.BodyHistory;

/**
 * Created by Michał on 17.03.2016.
 */
public class FormController {
    public boolean saveBodyData(Body body){
        try{
            BodyHistory bh = new BodyHistory();
            if(bh.updateBody(body)){
                bh.printBH();
                return true;
            }else{
                System.out.println("Failed to save data!");
                return false;
            }

        }catch (Exception e){
            return false;
        }

    }

    public boolean saveBodyData(double weight,
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

            if(bh.updateBody(body)){
                bh.printBH();
                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            return false;
        }

    }

}
