import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ShoppingCart {
    ArrayList<Product> productListOfCart = new ArrayList<>();

    public void addProduct (Product item){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the product name: ");
        if(Objects.equals(item.getProductName().toLowerCase(), scanner.nextLine().toLowerCase())){ //checking if the product is available in the system
            if(item.getAvailableItemsCount() > 0){ // checking if the product is in stock
                productListOfCart.add(item);
            } else System.out.println("The product you entered is currently not in stock"); // Error message product not in stock
        } else System.out.println("The product name you entered is not available in the store"); // Error message product is not in store
    }

    public void removeProduct(Product item){
        for (int i = 0; i < productListOfCart.size(); i++) {
            if(Objects.equals(productListOfCart.get(i).getProductID(), item.getProductID())) { // checking if the product is in the cart
                productListOfCart.remove(item);
                break;
            } else {
                System.out.println("The item you entered is not in the shopping cart");
            }
        }
    }

    public void calculateTotal(){
        double total = 0;
        for (int i = 0; i < productListOfCart.size(); i++) {
            total =+ productListOfCart.get(i).getProductPrice();
        }
        System.out.println("Total price: " + total);
    }

    @Override
    public String toString() {
        return "ShoppingCart: \n" +
                "productsList=" + productListOfCart;
    }
}
