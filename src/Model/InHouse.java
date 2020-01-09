package Model;

public class InHouse extends Part{

    private static int machineId;

    public InHouse() {
        this(0, null, 0, 0.0, 0, 0, 0);

    }

    public InHouse(int partId, String partName, int partInv, double partPrice, int partMax, int partMin, int machineId) {
        super(partId, partName, partInv, partPrice, partMax, partMin);
        this.machineId = machineId;

    }


    public void setMachineId(int machineId) {

        this.machineId = machineId;
    }

    public static int getMachineId() {
        return machineId;
    }
}
