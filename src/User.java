import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class User implements Serializable {
    private static final HashMap<String,String> loginInfo = new HashMap<>();
    Scanner scanner = new Scanner(System.in);

    public User(){
        while (true){
            System.out.print
                    ("""
                    
                    01. login as user
                    02. register as  a user
                    
                    """);

            System.out.print("Choose a option to continue: ");
            String isNewUser = scanner.nextLine().toLowerCase();

            switch (isNewUser){
                case "2" -> {
                    registerNewUser();
                    return;
                }
                case "1" -> {
                    userLogin();
                    return; // break the while loop using return
                }
                default -> System.out.println("Invalid input. Please enter \"yes\" or \"no\".");
            }
        }
    }

    public void userLogin(){
        loadLoginInfo();
        while (true){
            System.out.print("Enter the username: ");
            String username = scanner.nextLine();

            if(loginInfo.containsKey(username)){
                System.out.print("Enter the password: ");
                String password = scanner.nextLine();
                if(loginInfo.get(username).equals(password)){
                    System.out.println("Authentication successful");
                    new WestminsterShoppingCenter();
                    break;
                } else System.out.println("entered password wrong");
            } else {
                System.out.println("User " + username + " not found");
                break;
            }
        }
    }

    public void registerNewUser(){
        loadLoginInfo();
        while (true){
            System.out.print("Enter the username: ");
            String username = scanner.nextLine();

            if(!loginInfo.containsKey(username)){
                System.out.print("Enter the password: ");
                String password = scanner.nextLine();

                loginInfo.put(username,password);
                saveLoginInfo();
                System.out.println("user " + username + " created");
                break;
            } else {
                System.out.println( username + ": username already taken, try another username");
            }
        }
    }

    public HashMap<String, String> getLoginInfo() {
        return loginInfo;
    }

    public void saveLoginInfo() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("credentials.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(loginInfo);
            fileOutputStream.close();
            objectOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadLoginInfo(){
        try{
            FileInputStream fileInputStream = new FileInputStream("credentials.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            HashMap<String,String> readFile = (HashMap<String,String>)objectInputStream.readObject();
            loginInfo.clear();
            loginInfo.putAll(readFile);
        } catch (IOException | ClassNotFoundException e) {
            if (!(e instanceof FileNotFoundException)) {
                throw new RuntimeException(e);
            }
        }
    }

}
