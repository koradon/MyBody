package application.model.database;

import application.model.user.ExistingUser;
import application.model.body.Body;
import application.model.user.User;

import java.util.List;

/**
 * Created by Dorotka on 2016-04-11.
 */
public interface Database {
    void createNewDatabase(String fileName);
    boolean createTable();
    boolean insertNewUser(ExistingUser user);
    User findUser(User user);
    boolean insertNewUserBodyData(ExistingUser user, Body body);
    List<Body> selectAllUserBodyEntries(ExistingUser user);
}
