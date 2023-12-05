import java.util.ArrayList;
import java.util.Scanner;

public class WestminsterShoppingManager implements ShoppingManager {

    private final ArrayList<Product> productsList = new ArrayList<>();

    private WestminsterShoppingManager(){
        productsList.add(new Electronics("ID01", "Smart TV", 599.99,"LG","03-Years"));
        productsList.add(new Electronics("ID02", "Laptop", 899.99,"apple","01-Year"));
        productsList.add(new Clothing("ID03", "T-Shirt", 19.99,"Large","Black"));
        productsList.add(new Electronics("ID04", "Headphones", 129.99,"samsung","01-Year"));
        productsList.add(new Clothing("ID05", "Jeans", 49.99,"Medium","Sky-Blue"));
    }

    Scanner scanner = new Scanner(System.in);

    @Override
    public void addProduct() {
        String choice;
        boolean added = false;
        String productID = null;
        String productName = null;
        double productPrice = 0;
        String brand = null;
        String warranty = null;
        String size = null;
        String color = null;

        do {
            System.out.println(
                    """
                            01. Electronic
                            02. Clothing
                    """
            );
            System.out.print("Select the type: ");
            choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("1")){

                for (Product product : productsList) {
                    System.out.print("Enter productID: ");
                    productID = scanner.nextLine().toUpperCase();
                    if (productID.equalsIgnoreCase(product.getProductID())) {
                        System.out.println("The productID must be unique and the product id you have entered is already existing. please try another ID");
                    }
                    else break;
                }

                System.out.print("Enter product Name: ");
                productName = scanner.nextLine();

                System.out.print("Enter the price");
                productPrice = scanner.nextDouble();
                scanner.nextLine(); // Consuming the newline character in the buffer

                System.out.print("Enter the brand: ");
                brand = scanner.nextLine();

                System.out.print("Enter the warranty period: ");
                warranty = scanner.nextLine();
                added = true;
            }
            else if (choice.equalsIgnoreCase("2")){

                for (Product product : productsList) {
                    System.out.print("Enter productID: ");
                    productID = scanner.nextLine().toUpperCase();
                    if (productID.equalsIgnoreCase(product.getProductID())) {
                        System.out.println("The productID must be unique and the product id you have entered is already existing. please try another ID");
                    }
                    else break;
                }

                System.out.print("Enter product Name: ");
                productName = scanner.nextLine();

                System.out.print("Enter the price");
                productPrice = scanner.nextDouble();
                scanner.nextLine(); // Consuming the newline character in the buffer

                System.out.print("Enter the size: ");
                size = scanner.nextLine();

                System.out.print("Enter the color: ");
                color = scanner.nextLine();
                added = true;
            } else System.out.println("Enter a valid type");
        } while (!added);

        int maxCountForAddingProducts = 50;
        if (productsList.size() < maxCountForAddingProducts) {
            if(choice.equalsIgnoreCase("1")) {
                productsList.add(new Electronics(productID,productName,productPrice,brand,warranty));
                System.out.println("Product added successfully.");
            }
            if(choice.equalsIgnoreCase("2")) {
                productsList.add(new Clothing(productID, productName, productPrice, size, color));
                System.out.println("Product added successfully.");
            }
        } else {
            System.out.println("Cannot add more products. Product limit reached.");
        }
    }

    @Override
    public void deleteProduct() {
        System.out.print("Enter the productID: ");
        String productID = scanner.nextLine().trim();

        boolean productFound = false;
        Product productDelete = null;

        for (Product product : productsList) {
            if (product.getProductID().equalsIgnoreCase(productID)) {
                productDelete = product;
                productFound = true;
            }
        }
        if (!productFound) System.out.println("The productID you have entered is not found");
        else {
            if (productDelete instanceof Electronics) {
                System.out.println(productDelete + ",\nis deleted successfully");
                productsList.remove(productDelete);
            }
            if (productDelete instanceof Clothing) {
                System.out.println(productDelete + ",\nis deleted successfully");
                productsList.remove(productDelete);
            }
        }
    }

    @Override
    public void displayProducts() {
        for (Product product:productsList) {
            String Products = product.toString();
            System.out.println(Products);
        }
    }

    @Override
    public void saveFile() {

    }

    public static void displayMenuOptions() {

        System.out.println("\n*************** Welcome To Westminster Shopping Manager ***************\n");

        System.out.println(
                """
                        01. Add a new product
                        02. Delete a product
                        03. Print the list of products
                        04. Save File
                        05. Exit
                """
        );
    }

    public static void main(String[] args) {

        WestminsterShoppingManager manger = new WestminsterShoppingManager();

        do {
            WestminsterShoppingManager.displayMenuOptions(); // printing the options

            System.out.print("Enter a option: ");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> {
                    manger.addProduct();
                }
                case "2" -> {
                    manger.deleteProduct();
                }
                case "3" -> {
                    manger.displayProducts();
                }
                case "4" -> {
                    manger.saveFile();
                }
                case "5"-> {
                    System.out.println("System Exited");
                    System.exit(0);
                }
                default ->
                    System.out.println("Enter a valid option");
            }
        } while (true);
    }
}
