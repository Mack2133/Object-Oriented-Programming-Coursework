import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class ShoppingCart {
    ArrayList<Product> productListOfCart = new ArrayList<>();

    public void addProduct () {
    }

    public void removeProduct(Product item) {
    }

    public void calculateTotal() {
    }

    public void displayProductList() {
    }

    @Override
    public String toString() {
        return "ShoppingCart: \n" +
                "productsList=" + productListOfCart;
    }
}
