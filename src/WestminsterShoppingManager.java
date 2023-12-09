import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class WestminsterShoppingManager implements ShoppingManager {

    private final ArrayList<Product> productsList = new ArrayList<>();

    public static void main(String[] args) {

        WestminsterShoppingManager manger = new WestminsterShoppingManager();

        do {
            WestminsterShoppingManager.displayMenuOptions(); // printing the options

            System.out.print("Enter a option: ");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> manger.addProduct();
                case "2" -> manger.deleteProduct();
                case "3" -> manger.displayProducts();
                case "4" -> manger.saveFile();
                case "5" -> manger.loadFile();
                case "6"-> {
                    System.out.println("System Exited");
                    System.exit(0);
                }
                default ->
                    System.out.println("Enter a valid option");
            }
        } while (true);
    }

    private WestminsterShoppingManager(){
        if(!productsList.isEmpty()){
            for (Product product : productsList) {
                if (product instanceof Electronics)
                    new Electronics(product.getProductID(), product.getProductName(), product.getProductPrice(), ((Electronics) product).getBrand(), ((Electronics) product).getWarranty());
                if (product instanceof Clothing)
                    new Clothing(product.getProductID(), product.getProductName(), product.getProductPrice(), ((Clothing) product).getSize(), ((Clothing) product).getColor());
            }
        }
    }

    Scanner scanner = new Scanner(System.in);

    @Override
    public void addProduct() {
        String choice;
        boolean isIDFound;
        String productID;
        String productName;
        double productPrice;
        String brand;
        String warranty;
        String size;
        String color;

        do {
            System.out.println(
                    """
                        01. Electronic
                        02. Clothing
                    """
            );

            System.out.print("Select the type: ");
            choice = scanner.nextLine();

        } while (!choice.equalsIgnoreCase("1") && (!choice.equalsIgnoreCase("2")));

        do {
            System.out.print("Enter productID: ");
            productID = scanner.nextLine();

            isIDFound = false;

            for (Product product : productsList) {
                if (productID.equalsIgnoreCase(product.getProductID())) {
                    System.out.println("The productID you entered already exists. Please try another ID");
                    isIDFound = true;
                    break;
                }
            }
        } while (isIDFound);

        System.out.print("Enter product Name: ");
        productName = scanner.nextLine();

        System.out.print("Enter the price: ");
        productPrice = scanner.nextDouble();
        scanner.nextLine(); // Consuming the newline character in the buffer

        if (productsList.size() < 50) {
            if (choice.equalsIgnoreCase("1")) {

                System.out.print("Enter the brand: ");
                brand = scanner.nextLine();

                System.out.print("Enter the warranty period: ");
                warranty = scanner.nextLine();

                Product newElectronicProduct = new Electronics(productID, productName, productPrice, brand, warranty);
                productsList.add(newElectronicProduct);
                System.out.println(newElectronicProduct + " Product added successfully.\nTotal products in the system: " + Product.getNumberOfAvailableItems());
            }
            if (choice.equalsIgnoreCase("2")) {

                System.out.print("Enter the size: ");
                size = scanner.nextLine();

                System.out.print("Enter the color: ");
                color = scanner.nextLine();

                Product newClothingProduct = new Clothing(productID, productName, productPrice, size, color);
                productsList.add(newClothingProduct);
                System.out.println(newClothingProduct + " product added successfully.\nTotal products in the system: " + Product.getNumberOfAvailableItems());
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
                Product.setNumberOfAvailableItems(Product.getNumberOfAvailableItems() - 1);
                System.out.println(productDelete + ", is deleted successfully." + "\ntotal number of products left in the system " + Product.getNumberOfAvailableItems());
                productsList.remove(productDelete);
            }
            if (productDelete instanceof Clothing) {
                Product.setNumberOfAvailableItems(Product.getNumberOfAvailableItems() - 1);
                System.out.println(productDelete + ", is deleted successfully." + "\ntotal number of products left in the system " + Product.getNumberOfAvailableItems());
                productsList.remove(productDelete);
            }
        }
    }

    @Override
    public void displayProducts() {

        productsList.sort(new ProductIDComparator());
        for (Product product:productsList) {
            String Products = product.toString();
            System.out.println(Products);
        }
    }

    @Override
    public void saveFile() {
        try {
            FileOutputStream fileOut = new FileOutputStream("Data.ser");
            ObjectOutputStream saveFile = new ObjectOutputStream(fileOut);
            saveFile.writeObject(productsList);
            fileOut.close();
            saveFile.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("File successfully saved");
    }

    @Override
    public void loadFile() {
        try (FileInputStream fileIn = new FileInputStream("Data.ser");
             ObjectInputStream readFromFile = new ObjectInputStream(fileIn)) {
            ArrayList<Product> loadedProducts = (ArrayList<Product>) readFromFile.readObject();

            productsList.clear();
            productsList.addAll(loadedProducts);
            System.out.println("File loaded successfully");

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void displayMenuOptions() {

        System.out.println("\n*************** Welcome To Westminster Shopping Manager ***************\n");

        System.out.println(
                """
                        01. Add a new product
                        02. Delete a product
                        03. Print the list of products
                        04. Save File
                        05. Load File
                        06. Exit
                """
        );
    }
}
