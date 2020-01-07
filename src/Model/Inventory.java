package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory {

    public static ObservableList<Part> partInventory = FXCollections.observableArrayList();
    public static ObservableList<Product> productInventory = FXCollections.observableArrayList();

    private static int partIdCount = 0;
    private static int productIdCount = 0;

    public ObservableList<Part> getPartInventory() {
        return partInventory;
    }

    public static void addPart(Part newPart) {
        partInventory.add(newPart);
    }

    public static void addProduct (Product newProduct) {
        productInventory.add(newProduct);
    }

    public void deletePart (Part part) {
        partInventory.remove(part);
    }

    public void deleteProduct(Product product) {
        productInventory.remove(product);
    }

    public static ObservableList searchPart(String searchPartName) {

        ObservableList<Part> foundParts;
        foundParts = FXCollections.observableArrayList();

        if (searchPartName.length() == 0) foundParts = partInventory;
        else {
            for (int i = 0; i < partInventory.size(); i++) {
                if (partInventory.get(i).getPartName().toLowerCase().contains(searchPartName.toLowerCase()))
                    foundParts.add(partInventory.get(i));
            }
        }

        return foundParts;

    }

    public static ObservableList<Part> getAllPartsList() {
        return partInventory;
    }

    public static ObservableList<Product> getAllProductsList() {
        return productInventory;
    }

    public static int lookupPart(String searchTerm) {

        boolean isFound = false;
        int index = 0;

        if (isInteger(searchTerm)) {
            for (int i = 0; i < partInventory.size(); i++) {
                if (Integer.parseInt(searchTerm) == partInventory.get(i).getPartId()) {
                    index = i;
                    isFound = true;
                }
            }
        }
        else {
            for (int i = 0; i < partInventory.size(); i++) {
                searchTerm = searchTerm.toLowerCase();
                if (searchTerm.equals(partInventory.get(i).getPartName().toLowerCase())) {
                    index = i;
                    isFound = true;
                }
            }
        }

        if (isFound == true) {
            return index;
        }
        else {
            System.out.println("No Parts Found");
            return -1;
        }

    }

    private static boolean isInteger(String toCheck) {

        try {
            Integer.parseInt(toCheck);
            return true;
        }
        catch (Exception e) {
            return false;
        }

    }

    public void searchProduct(Product searchProduct) {

    }

    public static void updatePart(int index, Part part) {

        partInventory.set(index, part);
    }

    public static void updateProduct(int productToUpdate, Product updateProduct) {
        productInventory.set(productToUpdate, updateProduct);
    }

    public static int getPartId() {
        partIdCount += 1;
        return partIdCount;
    }

    public static int getProductId() {
        productIdCount += 1;
        return productIdCount;
    }

}
