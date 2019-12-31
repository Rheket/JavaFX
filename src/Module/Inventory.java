package Module;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory {

    private static ObservableList<Part> partInventory = FXCollections.observableArrayList();
    private static ObservableList<Product> productInventory = FXCollections.observableArrayList();

    private static int partIdCount = 0;

    public ObservableList<Part> getPartInventory() {
        return partInventory;
    }

    public static void addPart(Part newPart) {
        partInventory.add(newPart);
    }

    public void addProduct (Product newProduct) {
        productInventory.add(newProduct);
    }

    public void deletePart (Part part) {
        partInventory.remove(part);
    }

    public void deleteProduct(Product product) {
        productInventory.remove(product);
    }

    public void searchPart(Part searchPart) {

    }

    public void searchProduct(Product searchProduct) {

    }

    public void updatePart(int partToUpdate, Part updatePart) {
        partInventory.set(partToUpdate, updatePart);
    }

    public void updateProduct(int productToUpdate, Product updateProduct) {
        productInventory.set(productToUpdate, updateProduct);
    }

    public static int getPartId() {
        partIdCount += 1;
        return partIdCount;
    }

}
