package Model;

import javafx.beans.property.SimpleStringProperty;

public abstract class Part {

    protected int partId;
    private String partName;
    private double partPrice;
    private int partInv;
    private int partMin;
    private int partMax;

    public Part() {
        this(0, null, 0, 0.0,0,0);
    }

    public Part(int partId, String partName, int partInv, double partPrice, int partMax, int partMin) {

        this.partId = partId;
        this.partName = partName;
        this.partInv = partInv;
        this.partPrice = partPrice;
        this.partMax = partMax;
        this.partMin = partMin;


    }

    public void setPartId(Integer partId) {
        this.partId = partId;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public void setPartPrice(Double partPrice) {
        this.partPrice = partPrice;
    }

    public void setPartInv(Integer partInv) {
        this.partInv = partInv;
    }

    public void setPartMin(Integer partMin) {
        this.partMin = partMin;
    }

    public void setPartMax(Integer partMax) {
        this.partMax = partMax;
    }

    public int getPartId() {
        return partId;
    }

    public String getPartName() {
        return partName;
    }

    public double getPartPrice() {
        return partPrice;
    }

    public int getPartInv() {
        return partInv;
    }

    public int getPartMin() {
        return partMin;
    }

    public int getPartMax() {
        return partMax;
    }

}