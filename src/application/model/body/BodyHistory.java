package application.model.body;

import application.model.body.Body;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Michał on 17.03.2016.
 */
public class BodyHistory {
    private List<Body> bodyHistory = new LinkedList<>();

    public BodyHistory(List<Body> bodyHistory) {
        this.bodyHistory = bodyHistory;
    }

    public BodyHistory() {
    }

    public List<Body> getBodyHistory() {
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
