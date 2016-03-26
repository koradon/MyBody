package application.model;

import javafx.beans.property.*;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Date;

/**
 * Created by Michał on 17.03.2016.
 */
public class Body {
    private int idMeasurment;
    private StringProperty date = new SimpleStringProperty(this, "date", "Unknown");
    private DoubleProperty weight = new SimpleDoubleProperty(this, "weight", 0);
    private DoubleProperty hight = new SimpleDoubleProperty(this, "hight", 0);
    private DoubleProperty neckCircuit = new SimpleDoubleProperty(this, "neck", 0);
    private DoubleProperty chestCircuit = new SimpleDoubleProperty(this, "chest", 0);
    private DoubleProperty bicepsCircuit = new SimpleDoubleProperty(this, "biceps", 0);
    private DoubleProperty waistCircuit = new SimpleDoubleProperty(this, "waist", 0);
    private DoubleProperty abdomenCircuit = new SimpleDoubleProperty(this, "abdomen", 0);
    private DoubleProperty hipsCircuit = new SimpleDoubleProperty(this, "hips", 0);
    private DoubleProperty thighCircuit = new SimpleDoubleProperty(this, "thigh", 0);
    private DoubleProperty calfCircuit = new SimpleDoubleProperty(this, "calf", 0);

    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public Body(){};

    
    /*
    public Body(int idMeasurment,
                String date,
                double weight,
                double hight,
                double neckCircuit,
                double chestCircuit,
                double bicepsCircuit,
                double waistCircuit,
                double abdomenCircuit,
                double hipsCircuit,
                double thighCircuit,
                double calfCircuit) {
        this.idMeasurment = idMeasurment;
        this.date = date;
        this.weight = weight;
        this.hight = hight;
        this.neckCircuit = neckCircuit;
        this.chestCircuit = chestCircuit;
        this.bicepsCircuit = bicepsCircuit;
        this.waistCircuit = waistCircuit;
        this.abdomenCircuit = abdomenCircuit;
        this.hipsCircuit = hipsCircuit;
        this.thighCircuit = thighCircuit;
        this.calfCircuit = calfCircuit;
    }

    public Body(double weight,
                double hight,
                double neckCircuit,
                double chestCircuit,
                double bicepsCircuit,
                double waistCircuit,
                double abdomenCircuit,
                double hipsCircuit,
                double thighCircuit,
                double calfCircuit) {
        this.idMeasurment = 0;
        this.date = new Date().toString();
        this.weight = weight;
        this.hight = hight;
        this.neckCircuit = neckCircuit;
        this.chestCircuit = chestCircuit;
        this.bicepsCircuit = bicepsCircuit;
        this.waistCircuit = waistCircuit;
        this.abdomenCircuit = abdomenCircuit;
        this.hipsCircuit = hipsCircuit;
        this.thighCircuit = thighCircuit;
        this.calfCircuit = calfCircuit;
    }
    */

}
