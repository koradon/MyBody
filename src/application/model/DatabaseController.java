package application.model;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Dorotka on 2016-03-21.
 */
public class DatabaseController {
    public static void connectToDB(){
        Connection connection = null;

        try{
            String url = "jdbc:sqlite:myBodyDatabase.db";
            connection = DriverManager.getConnection(url);
            System.out.println("Connected to myBodyDatabase");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            try{
                if(connection != null){
                    connection.close();
                }
            }catch (SQLException e2){
                System.out.println(e2.getMessage());
            }
        }
    }

    public static void createNewDatabase(String fileName){
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

    public static void main(String[] args){
        connectToDB();
    }
}
