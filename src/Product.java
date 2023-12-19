import java.io.Serializable;

public abstract class Product implements Serializable {
    private String productID;
    private String productName;
    private double productPrice;
    private int itemQuantity;

    public Product(String productID, String productName, double productPrice, int itemQuantity){
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.itemQuantity = itemQuantity;
    }

    public String getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void increaseItemQuantity() {
        itemQuantity++;
    }

    public void decreaseItemQuantity() {
        itemQuantity--;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "ProductID: " + productID +
                ", Product Name: " + productName +
                ", Price: " + productPrice +
                ", Items Available: " + itemQuantity;
    }
}
