package Application.Model;

/**
 * Created by Michał on 17.03.2016.
 */
public class Body {
    private double weight;
    private double hight;
    private double neckCircuit;
    private double chestCircuit;
    private double bicepsCircuit;
    private double waistCircuit;
    private double abdomenCircuit;
    private double hipsCircuit;
    private double thighCircuit;
    private double calfCircuit;

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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHight() {
        return hight;
    }

    public void setHight(double hight) {
        this.hight = hight;
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
