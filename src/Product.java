public abstract class Product {
    private String productID;
    private String productName;
    private int numberOfAvailableItems;
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

    public int getNumberOfAvailableItems() {
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

    @Override
    public String toString() {
        return "ProductID: " + productID +
                ", Product Name: " + productName +
                ", Price: " + productPrice +
                ", Number of Available Items: " + numberOfAvailableItems;
    }
}
