package application.model.user;

/**
 * Created by Michał on 14.04.2016.
 */
public class NotLoggedUser implements User{
    private String username;
    private String password;

    public NotLoggedUser() {}

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = hashPassword(password);
    }

    private String hashPassword(String password){
        return password;
    }
}
