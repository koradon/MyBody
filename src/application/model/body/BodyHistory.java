package application.model.body;

import application.model.body.observerInterfaces.BodyObserver;
import application.model.body.observerInterfaces.SubjectOfInterest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michał on 17.03.2016.
 */
public class BodyHistory implements SubjectOfInterest {
    private List<BodyObserver> bodyObservers = new ArrayList<BodyObserver>();
    private ArrayList<Body> bodyHistory = new ArrayList<>();
    private Body actualBody;

    public BodyHistory(ArrayList<Body> bodyHistory) {
        this.bodyHistory = bodyHistory;
    }

    public BodyHistory() {
    }

    public boolean addActualBody(Body body){
        try{
            bodyHistory.add(body);
            actualBody = bodyHistory.get(bodyHistory.size()-1);
            notifyBodyObservers();
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    @Override
    public void addObserver(BodyObserver o) {
        bodyObservers.add(o);
    }

    @Override
    public void removeBodyObserver(BodyObserver o) {
        int i = bodyObservers.indexOf(o);
        if(i>0) {
            bodyObservers.remove(o);
        }
    }

    @Override
    public void notifyBodyObservers() {
        for(int i=0; i<=bodyObservers.size(); i++){
            BodyObserver bObs = bodyObservers.get(i);
            bObs.update(actualBody);
        }
    }

    public ArrayList<Body> getBodyHistory() {
        return bodyHistory;
    }

    public void printBH(){
        for(Body body : bodyHistory){
            System.out.println(body.getWeight());
        }
    }



}
