import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserLogin extends JFrame implements ActionListener{
    private JButton loginButton;
    private JButton registerButton;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel messageLabel;

    public UserLogin() {
        JLabel usernameLabel = new JLabel("Enter username: ");
        usernameLabel.setBounds(50, 100, 150, 40);

        JLabel passwordLabel = new JLabel("Enter password: ");
        passwordLabel.setBounds(50, 150, 150, 40);

        messageLabel = new JLabel();
        messageLabel.setBounds(50,250,200,40);

        usernameField = new JTextField();
        usernameField.setBounds(170, 100, 150, 40);

        passwordField = new JPasswordField();
        passwordField.setBounds(170, 150, 150, 40);

        loginButton = new JButton("Login");
        loginButton.setBounds(50, 200, 100, 40);
        loginButton.addActionListener(this);

        registerButton = new JButton("Register");
        registerButton.setBounds(150, 200, 100, 40);
        registerButton.addActionListener(this);

        this.add(messageLabel);
        this.add(loginButton);
        this.add(registerButton);
        this.add(usernameField);
        this.add(passwordField);
        this.add(usernameLabel);
        this.add(passwordLabel);
        this.setTitle("New User");
        this.setSize(400, 400);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==loginButton){
            User user = new User();
            user.loadLoginInfo();
            String username = usernameField.getText();
            String password = String.valueOf(passwordField.getPassword());

            if(user.getLoginInfo().containsKey(username)){
                if(user.getLoginInfo().get(username).equals(password)){
                    messageLabel.setForeground(Color.GREEN);
                    messageLabel.setText("Authentication Successful");
                    new WestminsterShoppingCenter();
                    this.dispose();
                }

                else {
                    messageLabel.setForeground(Color.red);
                    messageLabel.setText("Wrong Password");
                }

            } else {
                messageLabel.setForeground(Color.red);
                messageLabel.setText("Username not found");
            }
        }

        if (e.getSource()==registerButton){
            User user = new User();
            String username = usernameField.getText();
            String password = String.valueOf(passwordField.getPassword());
            if (!user.getLoginInfo().containsKey(username)){
//                user = new User(username,password);
                user.saveLoginInfo();
                new WestminsterShoppingCenter();
            } else {
                messageLabel.setForeground(Color.GRAY);
                messageLabel.setText(username + ": already taken.try something else.");
            }
        }
    }

    public static void main(String[] args) {
        new UserLogin();
    }
}