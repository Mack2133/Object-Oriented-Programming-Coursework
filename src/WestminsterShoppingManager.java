import java.util.ArrayList;
import java.util.Scanner;

public class WestminsterShoppingManager implements ShoppingManager {
    private ArrayList<Product> productList = new ArrayList<Product>();
    int maxCount = 50;

    Product product = new Electronics("ID01","tv",123);
    Product computer = new Electronics("ID02","computer",1234);
    Product phone = new Electronics("ID03","phone",12345);
    Product clothing = new Clothing("ID04","clothing",123456);



    Scanner scanner = new Scanner(System.in);

    @Override
    public void addProduct() {
        System.out.println("Enter the product details");
    }

    @Override
    public void deleteProduct() {

    }

    @Override
    public void displayProducts() {

    }

    @Override
    public void saveFile() {

    }

    public static void displayMenuOptions() {
        System.out.println(
                "*************** Welcome To Westminster Shopping Manager ***************\n"
        );

        System.out.println(
                """
                        01. Add a new product
                        02. Delete a product
                        03. Print the list of the products
                        04. Save File
                        05. Exit
                """
        );
    }

    public static void main(String[] args) {

        WestminsterShoppingManager manger = new WestminsterShoppingManager();

        boolean value = false;
        do {
            WestminsterShoppingManager.displayMenuOptions(); // printing the options

            System.out.print("Enter a option: ");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> {
                    manger.addProduct();
                    value = true;
                }
                case "2" -> {
                    manger.deleteProduct();
                    value = true;
                }
                case "3" -> {
                    manger.displayProducts();
                    value = true;
                }
                case "4" -> {
                    manger.saveFile();
                    value = true;
                }
                case "5" -> {
                    System.out.println("System Exited");
                    System.exit(0);
                }
                default ->
                    System.out.println("Enter a valid option");

            }
        } while (!value);
    }
}
