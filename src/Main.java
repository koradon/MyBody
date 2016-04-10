import application.model.body.Body;
import application.model.body.BodyHistory;


/**
 * Created by Michał on 17.03.2016.
 */
public class Main {
    public static void main(String args[]){
        BodyHistory bh = new BodyHistory();
        Body body1 = new Body(1,"2016",80,173,20,100,30,80,85,90,40,35);
        Body body2 = new Body(2,"2016",83,173,20,100,30,80,90,95,40,35);
        bh.updateBody(body1);
        bh.updateBody(body2);

        bh.printBH();

        //User u1 = new User(1, "michal", "pass", "Michał", "Sipa", "male", "1988/06/21" );
        //User u2 = new User(2, "doro", "pass", "Dorota", "Dziendziel", "female", "1992/11/22");

        //System.out.println(u1);
        //System.out.println(u2);
    }


}
