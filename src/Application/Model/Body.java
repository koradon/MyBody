package application.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Date;

/**
 * Created by Michał on 17.03.2016.
 */
public class Body {
    private int idMeasurment;
    private String date;
    private double weight;
    private double height;
    private double neckCircuit;
    private double chestCircuit;
    private double bicepsCircuit;
    private double waistCircuit;
    private double abdomenCircuit;
    private double hipsCircuit;
    private double thighCircuit;
    private double calfCircuit;

    private double bmi;

    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public Body(){};

    public Body(int idMeasurment,
                String date,
                double weight,
                double height,
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
        this.height = height;
        this.neckCircuit = neckCircuit;
        this.chestCircuit = chestCircuit;
        this.bicepsCircuit = bicepsCircuit;
        this.waistCircuit = waistCircuit;
        this.abdomenCircuit = abdomenCircuit;
        this.hipsCircuit = hipsCircuit;
        this.thighCircuit = thighCircuit;
        this.calfCircuit = calfCircuit;

        this.bmi = calculateBMI();
    }

    public Body(double weight,
                double height,
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
        this.height = height;
        this.neckCircuit = neckCircuit;
        this.chestCircuit = chestCircuit;
        this.bicepsCircuit = bicepsCircuit;
        this.waistCircuit = waistCircuit;
        this.abdomenCircuit = abdomenCircuit;
        this.hipsCircuit = hipsCircuit;
        this.thighCircuit = thighCircuit;
        this.calfCircuit = calfCircuit;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener){
        pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener){
        pcs.removePropertyChangeListener(listener);
    }

    private double calculateBMI(){
        double bmi = weight/(Math.pow(height/100,2));
        System.out.println("Your BMI is: " + bmi);
        return bmi;
    };

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getNeckCircuit() {
        return neckCircuit;
    }

    public void setNeckCircuit(double neckCircuit) {
        this.neckCircuit = neckCircuit;
    }

    public double getChestCircuit() {
        return chestCircuit;
    }

    public void setChestCircuit(double chestCircuit) {
        this.chestCircuit = chestCircuit;
    }

    public double getBicepsCircuit() {
        return bicepsCircuit;
    }

    public void setBicepsCircuit(double bicepsCircuit) {
        this.bicepsCircuit = bicepsCircuit;
    }

    public double getWaistCircuit() {
        return waistCircuit;
    }

    public void setWaistCircuit(double waistCircuit) {
        this.waistCircuit = waistCircuit;
    }

    public double getAbdomenCircuit() {
        return abdomenCircuit;
    }

    public void setAbdomenCircuit(double abdomenCircuit) {
        this.abdomenCircuit = abdomenCircuit;
    }

    public double getHipsCircuit() {
        return hipsCircuit;
    }

    public void setHipsCircuit(double hipsCircuit) {
        this.hipsCircuit = hipsCircuit;
    }

    public double getThighCircuit() {
        return thighCircuit;
    }

    public void setThighCircuit(double thighCircuit) {
        this.thighCircuit = thighCircuit;
    }

    public double getCalfCircuit() {
        return calfCircuit;
    }

    public void setCalfCircuit(double calfCircuit) {
        this.calfCircuit = calfCircuit;
    }
}
