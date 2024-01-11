import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.*;

public class WestminsterShoppingManager implements ShoppingManager {
    private final ArrayList<Product> productsList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public WestminsterShoppingManager(){
        loadFile();
        if(!productsList.isEmpty()){
            for (Product product : productsList) {
                if (product instanceof Electronics)
                    new Electronics(product.getProductID(), product.getProductName(), product.getProductPrice(),product.getItemQuantity(), ((Electronics) product).getBrand(), ((Electronics) product).getWarranty());
                if (product instanceof Clothing)
                    new Clothing(product.getProductID(), product.getProductName(), product.getProductPrice(), product.getItemQuantity(), ((Clothing) product).getSize(), ((Clothing) product).getColor());
            }
        }
    }

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
        int itemQty;

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
            while (true){
                System.out.print("Enter productID: ");
                productID = scanner.nextLine();
                String regex = "^id.*";

                if (!Pattern.matches(regex, productID)) {
                    System.out.println("Invalid ID format.Product ID should contain \"id\" in the start");
                }else break;
            }

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

        while (true){
            try {
                System.out.print("Enter the price: ");
                productPrice = scanner.nextDouble();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid value.");
                scanner.nextLine(); // to stop infinite loop
            }
        }

        while (true){
            try {
                System.out.print("Enter the quantity: ");
                itemQty = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid value.");
                scanner.nextLine(); // to stop infinite loop
            }
        }

        if (getTotalItems() + itemQty <= 50) {
            if (choice.equalsIgnoreCase("1")) {

                System.out.print("Enter the brand: ");
                brand = scanner.nextLine();

                System.out.print("Enter the warranty period: ");
                warranty = scanner.nextLine();

                Product newElectronicProduct = new Electronics(productID, productName, productPrice, itemQty, brand, warranty);
                productsList.add(newElectronicProduct);
                System.out.println(newElectronicProduct + " Product added successfully.\nAvailable Items: " + newElectronicProduct.getItemQuantity());
            }
            if (choice.equalsIgnoreCase("2")) {

                System.out.print("Enter the size: ");
                size = scanner.nextLine();

                System.out.print("Enter the color: ");
                color = scanner.nextLine();

                Product newClothingProduct = new Clothing(productID, productName, productPrice, itemQty, size, color);
                productsList.add(newClothingProduct);
                System.out.println(newClothingProduct + " product added successfully.\nAvailable Items: " + newClothingProduct.getItemQuantity());
            }
        } else {
            System.out.println("Cannot add more products. Product limit reached.");
        }
    }

    public ArrayList<Product> getProductsList() {
        return productsList;
    }

    @Override
    public void deleteProduct() {
        System.out.print("Enter the productID: ");
        String productID = scanner.nextLine().trim();

        boolean productFound = false;
        Product productDelete = null;

        for (Product product : productsList) {
            if (productID.equalsIgnoreCase(product.getProductID())) {
                if (product.getItemQuantity()>1){
                    product.decreaseItemQuantity();
                    System.out.println(product + ", is deleted successfully." + "\ntotal number of products left in the system " + getTotalItems());
                } else {
                    productDelete = product;
                }
                productFound = true;
            }
        }

        if (!productFound) System.out.println("The productID you have entered is not found");
        else {
            if (productDelete instanceof Electronics) {
                productDelete.decreaseItemQuantity();
                System.out.println(productDelete + ", is deleted successfully." + "\ntotal number of products left in the system " + getTotalItems());
                productsList.remove(productDelete);
            }
            if (productDelete instanceof Clothing) {
                productDelete.decreaseItemQuantity();
                System.out.println(productDelete + ", is deleted successfully." + "\ntotal number of products left in the system " + getTotalItems());
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
        try{
            FileInputStream fileIn = new FileInputStream("Data.ser");
            ObjectInputStream readFromFile = new ObjectInputStream(fileIn);
            ArrayList<Product> loadedProducts = (ArrayList<Product>) readFromFile.readObject();

            productsList.clear();
            productsList.addAll(loadedProducts);

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException | ClassNotFoundException ignored) {}
    }

    public void updateProductList(String category){
        ArrayList<Electronics> tempElectronics = new ArrayList<>();
        ArrayList<Clothing> tempClothing = new ArrayList<>();

        if(!(category==null)){

            if(category.equalsIgnoreCase("Electronics")){
                loadFile();
                for (Product product:productsList) {
                    if (product instanceof Electronics){
                        tempElectronics.add((Electronics) product);
                    }
                }
                productsList.clear();
                productsList.addAll(tempElectronics);
            }

            if(category.equalsIgnoreCase("Clothing")){
                loadFile();
                for (Product product:productsList) {
                    if (product instanceof Clothing){
                        tempClothing.add((Clothing) product);
                    }
                }
                productsList.clear();
                productsList.addAll(tempClothing);
            }

            if(category.equalsIgnoreCase("All")){
                loadFile();
            }
        }
    }

    public int getTotalItems(){
        int totalItems = 0;
        for (Product product:productsList) {
            totalItems += product.getItemQuantity();
        }
        return totalItems;
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

    public static void displayUserType() {
        System.out.print
                ("""
                    
                    01. User
                    02. Manager
                    
                """);
    }

}
