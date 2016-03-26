import application.model.Body;
import application.model.BodyHistory;
import application.model.User;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Michał on 17.03.2016.
 */
public class Main {
    public static void main(String args[]){
        BodyHistory bh = new BodyHistory();
        Body body1 = new Body(1,"2016",80,173,20,100,30,80,80,90,40,35);
        Body body2 = new Body(2,"2016",80,173,20,100,30,80,80,90,40,35);
        bh.addActualBody(body1);
        bh.addActualBody(body2);

        bh.printBH();

        User u1 = new User(1, "michal", "pass", "Michał", "Sipa", "male", "1988/06/21" );
        User u2 = new User(2, "doro", "pass", "Dorota", "Dziendziel", "female", "1992/11/22");

        System.out.println(u1);
        System.out.println(u2);
    }


}
