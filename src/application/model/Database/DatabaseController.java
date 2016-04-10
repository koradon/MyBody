package application.model.Database;

import application.model.body.Body;

import java.sql.*;
import java.util.*;

/**
 * Created by Dorotka on 2016-03-21.
 */
public class DatabaseController {
    private Connection connection = null;

    public DatabaseController() {
        this.connection = connectToDB();
    }

    public Connection connectToDB(){
        Connection connection = null;

        try{
            String url = "jdbc:sqlite:myBodyDatabase.db";
            connection = DriverManager.getConnection(url);
            System.out.println("Connected to myBodyDatabase");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            return connection;
        }

    }

    public void createNewDatabase(String fileName){
        String url = "jdbc:sqlite:myBodyDatabase.db" + fileName;

        try(Connection connection = DriverManager.getConnection(url)){
            if(connection != null){
                DatabaseMetaData metadata = connection.getMetaData();
                System.out.println("Database driver: " + metadata.getDriverName());
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
                "name varchar(255), " +
                "lastname varchar(255), " +
                "gender varchar(255))";
        String createBody = "CREATE TABLE IF NOT EXISTS body " +
                "(id_body INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "date varchar(255), " +
                "weight double, " +
                "hight double, " +
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

    public boolean insertUser(String username,
                              String name,
                              String lastname,
                              String gender){
        try{
            PreparedStatement prepStmt = connection.prepareStatement(
                    "insert into czytelnicy values (NULL, ?, ?, ?);");

            PreparedStatement stm =
                    connection.prepareStatement("INSERT INTO users " +
                            "values (NULL, ?, ?, ?, ?)");
            stm.setString(1, username);
            stm.setString(2, name);
            stm.setString(3, lastname);
            stm.setString(4, gender);
            stm.execute();
        } catch (SQLException e) {
            System.err.println("Error creating a user");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean insertBody(String date,
                              double weight,
                              double height,
                              double neck,
                              double chest,
                              double biceps,
                              double waist,
                              double abdomen,
                              double hips,
                              double thigh,
                              double calf){
        try {
            PreparedStatement stm =
                    connection.prepareStatement("INSERT INTO body " +
                            "values (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,");
            stm.setString(1, date);
            stm.setDouble(2, weight);
            stm.setDouble(3, height);
            stm.setDouble(4, neck);
            stm.setDouble(5, chest);
            stm.setDouble(6, biceps);
            stm.setDouble(7, waist);
            stm.setDouble(8, abdomen);
            stm.setDouble(9, hips);
            stm.setDouble(10, thigh);
            stm.setDouble(11, calf);
            stm.execute();

        } catch (SQLException e){
            System.err.println("Error creating a body");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean insertMeasurment(int idUser, int idBody){
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

    public List<User> selectUsers(){
        List<User> userList = new LinkedList<User>();

        try {
            Statement st = connection.createStatement();
            ResultSet result = st.executeQuery("SELECT * FROM users");
            int id;
            String username, name, lastname, gender;

            while(result.next()){
                id = result.getInt("id_user");
                username = result.getString("username");
                name = result.getString("name");
                lastname = result.getString("lastname");
                gender = result.getString("gender");
                userList.add(new User(id, username, name, lastname, gender));
            }
        } catch (SQLException e) {
            System.err.println("Error retreiving users list");
            e.printStackTrace();
            return null;
        }
        return userList;
    }

    public List<Body> selectBody(){
        List<Body> bodyList = new LinkedList<Body>();

        try {
            Statement st = connection.createStatement();
            ResultSet result = st.executeQuery("SELECT * FROM users");
            String date;
            int id, weight, height, neck, chest, biceps, waist,
                    abdomen, hips, thigh, calf;

            while(result.next()){
                id = result.getInt("id_body");
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
                bodyList.add(new Body(id, date, weight, height, neck, chest,
                        biceps, waist, abdomen, hips, thigh, calf));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bodyList;
    }

    public static void main(String[] args){
        DatabaseController dbc = new DatabaseController();
    }
}
