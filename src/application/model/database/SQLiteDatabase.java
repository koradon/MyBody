package application.model.database;

import application.model.user.ExistingUser;
import application.model.body.Body;
import application.model.user.User;

import java.sql.*;
import java.util.*;

/**
 * Created by Dorotka on 2016-03-21.
 */
public class SQLiteDatabase implements Database {
    private Connection connection = null;
    private String sqlDatabaseUrl = "jdbc:sqlite:myBodyDatabase.db";

    public SQLiteDatabase() {
        this.connection = connectToDB();
    }

    public Connection connectToDB(){
        Connection connection = null;

        try{
            connection = DriverManager.getConnection(sqlDatabaseUrl);
            System.out.println("Connected to myBodyDatabase");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            return connection;
        }

    }

    public void createNewDatabase(String fileName){
        String sqlDatabaseUrl = "jdbc:sqlite:";
        if(fileName.endsWith(".db")){
            sqlDatabaseUrl = sqlDatabaseUrl+fileName;
        }else{
            sqlDatabaseUrl = sqlDatabaseUrl + fileName + ".db";
        }

        try(Connection connection = DriverManager.getConnection(sqlDatabaseUrl)){
            if(connection != null){
                DatabaseMetaData metadata = connection.getMetaData();
                System.out.println("database driver: " + metadata.getDriverName());
                System.out.println("Created database");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public boolean createTable(){
        String createUsers = "CREATE TABLE IF NOT EXISTS users " +
                "(id_user INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "username varchar(255), " +
                "pass varchar(255), " +
                "name varchar(255), " +
                "lastname varchar(255), " +
                "gender varchar(255)," +
                "dateOfBirth varchar(255))";
        String createBody = "CREATE TABLE IF NOT EXISTS body " +
                "(id_body INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "id_user integer, " +
                "date varchar(255), " +
                "weight double, " +
                "height double, " +
                "neck double, " +
                "chest double, " +
                "biceps double, " +
                "waist double, " +
                "abdomen double, " +
                "hips double, " +
                "thigh double, " +
                "calf double)";
        String createMeasurment = "CREATE TABLE IF NOT EXISTS measurment " +
                "(id_measurment INTEGER PRIMARY KEY AUTOINCREMENT," +
                "id_user int, " +
                "id_body int)";

        try (Connection connection = connectToDB();
             Statement stm = connection.createStatement()){
            stm.execute(createUsers);
            stm.execute(createBody);
            stm.execute(createMeasurment);
        } catch (SQLException e) {
            System.err.println("Error creating the tables");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean insertNewUser(ExistingUser user){
        try{
            PreparedStatement stm =
                    connection.prepareStatement("INSERT INTO users " +
                            "values (NULL, ?, ?, ?, ?, ?, ?)");
            stm.setString(1, user.getUsername());
            stm.setString(2, user.getPassword());
            stm.setString(3, user.getName());
            stm.setString(4, user.getLastName());
            stm.setString(5, user.getGender());
            stm.setString(6, user.getDateOfBirth());
            stm.execute();
        } catch (SQLException e) {
            System.err.println("Error creating a user");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public ExistingUser findUser(User searchedUser){
        int id;
        ExistingUser existingUser;
        String username, pass, name, lastname, gender, dateOfBirth;

        try{
            PreparedStatement stm =
                    connection.prepareStatement("SELECT " +
                            "id_user, username, pass, name, lastname, gender, dateOfBirth " +
                            "FROM users " +
                            "WHERE username=? and pass=?");
            stm.setString(1, searchedUser.getUsername());
            stm.setString(2, searchedUser.getPassword());

            ResultSet result = stm.executeQuery();
            while(result.next()) {
                id = result.getInt("id_user");
                username = result.getString("username");
                pass = result.getString("pass");
                name = result.getString("name");
                lastname = result.getString("lastname");
                gender = result.getString("gender");
                dateOfBirth = result.getString("dateOfBirth");

                existingUser = new ExistingUser(id, username, pass, name, lastname, gender, dateOfBirth);
                return existingUser;
            }

            return null;

        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public boolean insertNewUserBodyData(ExistingUser user, Body body){
        try {
            PreparedStatement stm =
                    connection.prepareStatement("INSERT INTO body " +
                            "values (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stm.setInt(1, user.getId());
            stm.setString(2, body.getDate());
            stm.setDouble(3, body.getWeight());
            stm.setDouble(4, body.getHeight());
            stm.setDouble(5, body.getNeckCircuit());
            stm.setDouble(6, body.getChestCircuit());
            stm.setDouble(7, body.getBicepsCircuit());
            stm.setDouble(8, body.getWaistCircuit());
            stm.setDouble(9, body.getAbdomenCircuit());
            stm.setDouble(10, body.getHipsCircuit());
            stm.setDouble(11, body.getThighCircuit());
            stm.setDouble(12, body.getCalfCircuit());
            stm.execute();

        } catch (SQLException e){
            System.err.println("Error creating a body");
            e.printStackTrace();
            return false;
        }
        return true;
    }


    // niepotrzebne wykasować
    /*
    public boolean insertNewUserBodyMeasurment(int idUser, int idBody){
        try {
            PreparedStatement stm =
                    connection.prepareStatement("INSERT INTO measurment " +
                            "VALUES (NULL, ?, ?)");
            stm.setInt(1, idUser);
            stm.setInt(2, idBody);
            stm.execute();
        } catch (SQLException e){
            System.err.println("Error creating measurment");
            return false;
        }
        return true;
    }
    */

    public List<ExistingUser> selectAllUsers(){
        List<ExistingUser> userList = new LinkedList<ExistingUser>();

        try {
            Statement st = connection.createStatement();
            ResultSet result = st.executeQuery("SELECT * FROM users");
            int id;
            String username, pass, name, lastname, gender, dateOfBirth;

            while(result.next()){
                id = result.getInt("id_user");
                username = result.getString("username");
                pass = result.getString("pass");
                name = result.getString("name");
                lastname = result.getString("lastname");
                gender = result.getString("gender");
                dateOfBirth = result.getString("dateOfBirth");
                userList.add(new ExistingUser(id, username, pass, name, lastname, gender, dateOfBirth));
            }
        } catch (SQLException e) {
            System.err.println("Error retreiving users list");
            e.printStackTrace();
            return null;
        }
        return userList;
    }

    /*
    Only for testing
     */
    public List<Body> selectAllBodyEntries(){
        List<Body> bodyList = new LinkedList<Body>();

        try {
            Statement st = connection.createStatement();
            ResultSet result = st.executeQuery("SELECT * FROM body");
            String date;
            int id, id_user, weight, height, neck, chest, biceps, waist,
                    abdomen, hips, thigh, calf;

            while(result.next()){
                //id = result.getInt("id_body");
                //id_user = result.getInt("id_user");
                date = result.getString("date");
                weight = result.getInt("weight");
                height = result.getInt("height");
                neck = result.getInt("neck");
                chest = result.getInt("chest");
                biceps = result.getInt("biceps");
                waist = result.getInt("waist");
                abdomen = result.getInt("abdomen");
                hips = result.getInt("hips");
                thigh = result.getInt("thigh");
                calf = result.getInt("calf");
                bodyList.add(new Body(date, weight, height, neck, chest,
                        biceps, waist, abdomen, hips, thigh, calf));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bodyList;
    }

    public List<Body> selectAllUserBodyEntries(ExistingUser user){
        List<Body> bodyList = new LinkedList<Body>();

        try {
            Statement st = connection.createStatement();
            ResultSet result = st.executeQuery("SELECT * FROM body WHERE id_user=" + user.getId());
            String date;
            int weight, height, neck, chest, biceps, waist,
                    abdomen, hips, thigh, calf;

            while(result.next()){
                //id = result.getInt("id_body");
                //id_user = result.getInt("id_user");
                date = result.getString("date");
                weight = result.getInt("weight");
                height = result.getInt("height");
                neck = result.getInt("neck");
                chest = result.getInt("chest");
                biceps = result.getInt("biceps");
                waist = result.getInt("waist");
                abdomen = result.getInt("abdomen");
                hips = result.getInt("hips");
                thigh = result.getInt("thigh");
                calf = result.getInt("calf");
                bodyList.add(new Body(date, weight, height, neck, chest,
                        biceps, waist, abdomen, hips, thigh, calf));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bodyList;
    }

    public static void main(String[] args){
        SQLiteDatabase dbc = new SQLiteDatabase();
    }
}
