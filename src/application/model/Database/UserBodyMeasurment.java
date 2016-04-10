package application.model.database;

/**
 * Created by Dorotka on 2016-03-21.
 */
public class UserBodyMeasurment {
    private int idUser;
    private int idBody;

    public UserBodyMeasurment(int idUser,
                              int idBody) {
        this.idUser = idUser;
        this.idBody = idBody;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdBody() {
        return idBody;
    }

    public void setIdBody(int idBody) {
        this.idBody = idBody;
    }
}
