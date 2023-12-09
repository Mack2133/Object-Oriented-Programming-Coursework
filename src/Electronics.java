import java.io.Serializable;

public class Electronics extends Product implements Serializable {
    private String brand;
    private String warranty;

    public Electronics(String productID, String productName, double productPrice, String brand, String warranty) {
        super(productID, productName, productPrice);
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
                ", Warranty Period: " + warranty +
                ", Brand " + brand +
                ", Type: Electronics";
    }
}
