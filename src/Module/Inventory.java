package Module;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory {

    private static ObservableList<Part> partInventory = FXCollections.observableArrayList();
    private ObservableList<Product> productInventory = FXCollections.observableArrayList();

    public ObservableList<Part> getPartInventory() {
        return partInventory;
    }

    public void addPart(Part newPart) {
        partInventory.add(newPart);
    }

    public void addProduct(Product newProduct) {
        productInventory.add(newProduct);
    }

    public void deletePart(Part part) {
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


}
