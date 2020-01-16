package Model;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Product {

    public ObservableList<Part> associatedParts = FXCollections.observableArrayList();;
    private int productId;
    private String productName;
    private double productPrice;
    private int productStock;
    private int productMax;
    private int productMin;

    public Product() {
        this(0, null, 0, 0.0, 0,0);
    }

    public Product(int productId, String productName, int productStock, double productPrice, int productMax, int productMin) {

        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productStock = productStock;
        this.productMax = productMax;
        this.productMin = productMin;

    }


    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public void setProductStock(Integer productStock) {
        this.productStock = productStock;
    }

    public void setProductMin(Integer productMin) {
        this.productMin = productMin;
    }

    public void setProductMax(Integer productMax) {
        this.productMax = productMax;
    }


    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public int getProductStock() {
        return productStock;
    }

    public int getProductMin() {
        return productMin;
    }

    public int getProductMax() {
        return productMax;
    }

    public void addAssociatedPart(Part part) {

    }

    public boolean deleteAssociatedPart(Part selectedAsPart) {

        return true;

    }

    public ObservableList<Part> getAllAssociatedParts() {

        return associatedParts;

    }


    public void setAssociatedParts(ObservableList<Part> aPart) {

        this.associatedParts = aPart;

    }


}