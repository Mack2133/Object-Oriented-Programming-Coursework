import java.io.Serializable;
import java.util.Scanner;

public class User implements Serializable {
    private String userName;
    private String password;
    Scanner scanner = new Scanner(System.in);

    public User() {
        System.out.print("Enter user name: ");
        userName = scanner.nextLine();

        System.out.print("Enter password: ");
        password = scanner.nextLine();

        System.out.println("Username and password set up");
    }

    void userLogin(){

        while (true){
            System.out.print("Enter user name: ");
            userName = scanner.nextLine();

            System.out.print("Enter password: ");
            password = scanner.nextLine();

            if((userName.equals(this.getUserName()) && password.equals(this.getPassword()))){
                System.out.println("Authentication Successful");
                break;
            } else System.out.println("User name or password is not matching.Please try again");
        }
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
