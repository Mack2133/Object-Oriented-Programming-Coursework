import java.io.Serializable;

public class Clothing extends Product implements Serializable {
    private String size;
    private String color;

    public Clothing(String productID, String productName, double productPrice, int itemQuantity, String size,String color){
        super(productID, productName, productPrice,itemQuantity);
        this.size = size;
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Size: " + size +
                ", Color " + color +
                ", Type: Clothing";
    }
}
