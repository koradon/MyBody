package application.model.body;

import application.model.body.Body;

import java.util.ArrayList;

/**
 * Created by Michał on 17.03.2016.
 */
public class BodyHistory {
    private ArrayList<Body> bodyHistory = new ArrayList<>();

    public BodyHistory(ArrayList<Body> bodyHistory) {
        this.bodyHistory = bodyHistory;
    }

    public BodyHistory() {
    }

    public ArrayList<Body> getBodyHistory() {
        return bodyHistory;
    }

    public boolean updateBody(Body body){
        try{
            bodyHistory.add(body);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    public void printBH(){
        for(Body body : bodyHistory){
            System.out.println(body.getWeight());
        }
    }


}
