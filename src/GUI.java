import javax.swing.*;

public class GUI extends JFrame {

    public GUI(){
        JFrame frame = new JFrame("Westminster Shopping Center");
        frame.setSize(600,600);
        frame.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new GUI();
    }
}