package application.model.database;

import application.model.body.Body;

import java.util.List;

/**
 * Created by Dorotka on 2016-04-11.
 */
public interface Database {
    public void createNewDatabase(String fileName);
    public boolean createTable();
    public boolean insertUser(User user);
    public boolean findUserLogons(User user);
    public boolean insertNewUserBodyData(User user, Body body);
    public List<Body> selectAllUserBodyEntries(User user);
}
