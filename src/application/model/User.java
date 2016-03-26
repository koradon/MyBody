package application.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Dorotka on 2016-03-21.
 */
public class User {
    private int id;
    private String username;
    private String password;
    private String name;
    private String lastName;
    private String gender;
    private Date dateOfBirth;

    private int age;

    DateFormat df;

    public User(int id,
                String username,
                String password,
                String name,
                String lastName,
                String gender,
                String birthDate) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.df = new SimpleDateFormat("yyyy/mm/dd");

        try{
            this.dateOfBirth = df.parse(birthDate);
            this.age = getAge(dateOfBirth);
        } catch (ParseException e){
            e.printStackTrace();
            this.age = 25;
        }
        System.out.println();
    }

    private int getAge(Date dateOfBirth){
        Calendar today = Calendar.getInstance();
        Calendar birthDate = Calendar.getInstance();

        birthDate.setTime(dateOfBirth);

        if(birthDate.after(today)){
            System.out.println("You entered bad date of birth. " +
                    "Please correct it because it is used to calculate many body parameters");
        }

        age = today.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);
        System.out.println("Your age is: " + age);

        return age;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        return "["+id+"] - " + username + gender + age;
    }
}
