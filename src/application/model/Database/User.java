package application.model.Database;

/**
 * Created by Dorotka on 2016-03-21.
 */
public class User {
    private int id;
    private String username;
    private String name;
    private String lastName;
    private String gender;

    public User(int id,
                String username,
                String name,
                String lastName,
                String gender) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String toString(){
        return "["+id+"] - "+username;
    }
}
