import application.model.body.Body;
import application.model.body.BodyHistory;

/**
 * Created by Michał on 17.03.2016.
 */
public class Main {
    public static void main(String args[]){
        BodyHistory bh = new BodyHistory();
        Body body1 = new Body(80,172,20,100,30,80,80,90,60,30);
        Body body2 = new Body(81,172,20,100,30,80,80,90,60,30);
        bh.updateBody(body1);
        bh.updateBody(body2);

        bh.printBH();
    }
}
