import java.util.Scanner;

public class User {
    private String userName;
    private String password;

    public User() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter user name: ");
        userName = scanner.nextLine();

        System.out.print("Enter password: ");
        password = scanner.nextLine();

        System.out.println("Username and password set up");
    }

    void userLogin(String userName, String password){
        if(userName.equals(this.userName) && password.equals(this.password)){
            System.out.println("Authentication Successful");
        } else System.out.println("User name / Password not matching");
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
