import java.io.Serializable;

public abstract class Product implements Serializable {
    private String productID;
    private String productName;
    private static int numberOfAvailableItems;
    private double productPrice;

    public Product(String productID, String productName, double productPrice){
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        numberOfAvailableItems++;
    }

    public String getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public static int getNumberOfAvailableItems() {
        return numberOfAvailableItems;
    }

    public double getProductPrice() {
        return productPrice;
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

    public static void setNumberOfAvailableItems(int numberOfAvailableItems) {
        Product.numberOfAvailableItems = numberOfAvailableItems;
    }

    @Override
    public String toString() {
        return "ProductID: " + productID +
                ", Product Name: " + productName +
                ", Price: " + productPrice;
    }
}
