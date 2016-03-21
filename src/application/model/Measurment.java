package application.model;

/**
 * Created by Dorotka on 2016-03-21.
 */
public class Measurment {
    private int idUser;
    private int idMeasurment;

    public Measurment(int idUser,
                      int idMeasurment) {
        this.idUser = idUser;
        this.idMeasurment = idMeasurment;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdMeasurment() {
        return idMeasurment;
    }

    public void setIdMeasurment(int idMeasurment) {
        this.idMeasurment = idMeasurment;
    }
}
