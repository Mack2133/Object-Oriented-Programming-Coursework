import java.io.Serializable;

public abstract class Product implements Serializable {
    private final String productID;
    private final String productName;
    private final double productPrice;
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

    public void decreaseItemQuantity() {
        itemQuantity--;
    }

    @Override
    public String toString() {
        return "ProductID: " + productID +
                ", Product Name: " + productName +
                ", Price: " + productPrice +
                ", Items Available: " + itemQuantity;
    }
}
