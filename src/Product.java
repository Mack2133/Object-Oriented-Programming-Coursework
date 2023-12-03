public abstract class Product {
    private String productID;
    private String productName;
    private int availableItemsCount;
    private double productPrice;

    public Product(){

    }

    public Product(String productID, String productName, double productPrice){
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public Product(String productID, String productName, int availableItemsCount, double productPrice) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.availableItemsCount = availableItemsCount;
    }

    public String getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public int getAvailableItemsCount() {
        return availableItemsCount;
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

    public void setAvailableItemsCount(int availableItemsCount) {
        this.availableItemsCount = availableItemsCount;
    }

    @Override
    public String toString() {
        return "productID='" + productID + '\'' +
                ", productName='" + productName + '\'' +
                ", availableItemsCount=" + availableItemsCount +
                ", productPrice=" + productPrice;
    }
}
