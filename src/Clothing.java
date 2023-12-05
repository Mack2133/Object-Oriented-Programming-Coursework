public class Clothing extends Product{
    private String size;
    private String color;

    public Clothing(String productID, String productName, double productPrice,String size,String color){
        super(productID, productName, productPrice);
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
