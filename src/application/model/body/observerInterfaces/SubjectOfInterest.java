package application.model.body.observerInterfaces;

/**
 * Created by Michał on 26.03.2016.
 */
public interface SubjectOfInterest {
    public void addObserver(BodyObserver o);
    public void removeBodyObserver(BodyObserver o);
    public void notifyBodyObservers();
}
