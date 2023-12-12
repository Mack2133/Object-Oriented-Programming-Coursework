import javax.swing.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class ShoppingCart extends JFrame {
    ArrayList<Product> productListOfCart = new ArrayList<>();

    ShoppingCart(){
        this.setTitle("Shopping Cart");
        this.setSize(1200,600);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

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
