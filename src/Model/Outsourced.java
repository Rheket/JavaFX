package Model;

public class Outsourced extends Part{

    private String companyName;

    public Outsourced() {
        this(0, null, 0, 0.0, 0, 0, null);

    }

    public Outsourced(int partId, String partName, int partInv, double partPrice, int partMax, int partMin, String companyName) {
        super(partId, partName, partInv, partPrice, partMax, partMin);
        this.companyName = companyName;
    }

    public void setCompanyName(String companyName) {

        this.companyName = companyName;

    }

    public String getCompanyName() {

        return companyName;

    }

}
