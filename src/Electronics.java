public class Electronics extends Product{
    private String brand;
    private String warranty;

    public Electronics(){

    }

    public Electronics(String productID,String productName, double productPrice){
        super(productID,productName,productPrice);
    }

    public Electronics(String productID,String productName, double productPrice,String brand){
        super(productID,productName,productPrice);
        this.brand = brand;
    }

    public Electronics(String productID, String productName, int availableItemsCount, double productPrice, String brand, String warranty) {
        super(productID, productName, availableItemsCount, productPrice);
        this.brand = brand;
        this.warranty = warranty;
    }

    public String getBrand() {
        return brand;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "brand='" + brand + '\'' +
                ", warranty='" + warranty + '\'';
    }
}
