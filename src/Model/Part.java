package Model;

import javafx.beans.property.SimpleStringProperty;

public class Part {

    private int partId;
    private String partName;
    private double partPrice;
    private int partInv;
    private int partMin;
    private int partMax;

    public Part(int partId, String partName, int partInv, double partPrice, int partMax, int partMin) {

        this.partId = partId;
        this.partName = partName;
        this.partPrice = partPrice;
        this.partInv = partInv;
        this.partMax = partMax;
        this.partMin = partMin;

        //this.machineId = new SimpleStringProperty();

    }
/*
    public Part(int partId, String partName, int partInv, double partPrice) {

        this.partId = partId;
        this.partName = new SimpleStringProperty(partName);
        this.partInv = partInv;
        this.partPrice = partPrice;

    }
*/
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

    public Integer getPartId() {
        return partId;
    }

    public String getPartName() {
        return partName;
    }

    public Double getPartPrice() {
        return partPrice;
    }

    public Integer getPartInv() {
        return partInv;
    }

    public Integer getPartMin() {
        return partMin;
    }

    public Integer getPartMax() {
        return partMax;
    }

}
