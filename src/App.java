import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        WestminsterShoppingManager manager = new WestminsterShoppingManager();
        Scanner scanner1 = new Scanner(System.in);

        while(true){
            WestminsterShoppingManager.displayUserType();
            System.out.print("Enter a option: ");
            String userType = scanner1.nextLine();

            if(userType.equalsIgnoreCase("1")){
                new User();
                break;
            }
            else if(userType.equalsIgnoreCase("2")){
                do {
                    WestminsterShoppingManager.displayMenuOptions(); // printing the options

                    System.out.print("Enter a option: ");
                    Scanner scanner = new Scanner(System.in);
                    String choice = scanner.nextLine();

                    switch (choice) {
                        case "1" -> manager.addProduct();
                        case "2" -> manager.deleteProduct();
                        case "3" -> manager.displayProducts();
                        case "4" -> manager.saveFile();
                        case "5" -> manager.loadFile();
                        case "6"-> {
                            System.out.println("System Exited");
                            System.exit(0);
                        }
                        default -> System.out.println("Enter a valid option");
                    }
                } while (true);
            }
            else {
                System.out.println("Enter a valid option.");
            }
        }
    }
}
