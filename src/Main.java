import application.model.body.Body;
import application.model.body.BodyHistory;
import application.model.database.SQLiteDatabase;
import application.model.database.User;

import java.util.List;


/**
 * Created by Michał on 17.03.2016.
 */
public class Main {
    public static void main(String args[]){

        SQLiteDatabase database = new SQLiteDatabase();
        Body body1 = new Body(80,173,20,100,30,80,85,90,40,35);
        Body body2 = new Body(83,173,20,100,30,80,90,95,40,35);

        database.createTable();
        //database.insertUser("michal", "ppp", "Michał", "S", "male", "21/06/1988");
        List<User> users = database.selectAllUsers();
        System.out.println(users.toString());
        database.insertNewUserBodyData(0, body1);
        database.insertNewUserBodyData(0, body2);
        List<Body> bodyList = database.selectAllUserBodyEntries(0);
        System.out.println(bodyList.toString());
        BodyHistory bodyHistory = new BodyHistory(bodyList);

        bodyHistory.printBH();


        //User u1 = new User(1, "michal", "pass", "Michał", "Sipa", "male", "1988/06/21" );
        //User u2 = new User(2, "doro", "pass", "Dorota", "Dziendziel", "female", "1992/11/22");

        //System.out.println(u1);
        //System.out.println(u2);
    }


}
