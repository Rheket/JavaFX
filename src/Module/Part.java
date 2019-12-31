package Module;

public class Part {

    private int partId;
    private String partName;
    private double partPrice;
    private int partStock;
    private int partMin;
    private int partMax;
    private String machineId;

    //setters
    public void setPartId(int partId) {
        this.partId = partId;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public void setPartPrice(double partPrice) {
        this.partPrice = partPrice;
    }

    public void setPartStock(int partStock) {
        this.partStock = partStock;
    }

    public void setPartMin(int partMin) {
        this.partMin = partMin;
    }

    public void setPartMax(int partMax) {
        this.partMax = partMax;
    }

    //getters
    public int getPartId() {
        return partId;
    }

    public String getPartName() {
        return partName;
    }

    public double getPartPrice() {
        return partPrice;
    }

    public int getPartStock() {
        return partStock;
    }

    public int getPartMin() {
        return partMin;
    }

    public int getPartMax() {
        return partMax;
    }
}
