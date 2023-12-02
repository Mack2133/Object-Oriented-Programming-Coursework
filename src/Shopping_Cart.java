import java.util.ArrayList;
import java.util.List;

public class Shopping_Cart {
    ArrayList<Product> list_of_products = new ArrayList<>();

    void add_product (Product item){
        list_of_products.add(item);
    }

    void remove_product(Product item){
        list_of_products.remove(item);
    }

    void calculate_total(){

    }
}
