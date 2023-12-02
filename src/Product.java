public abstract class Product {
    private String productID;
    private String productName;
    private int availableItemsCount;
    private double productPrice;

    public Product(String productID, String productName, int availableItemsCount, double productPrice) {
        this.productID = productID;
        this.productName = productName;
        this.availableItemsCount = availableItemsCount;
        this.productPrice = productPrice;
    }

}
