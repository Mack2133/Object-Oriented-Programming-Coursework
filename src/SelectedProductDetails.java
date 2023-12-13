import javax.swing.*;

public class SelectedProductDetails extends JPanel {
    JLabel title;
    JLabel productID;
    JLabel category;
    JLabel name;
    JLabel size;
    JLabel color;
    JLabel brand;
    JLabel warranty;
    JLabel itemsAvailable;

    SelectedProductDetails(){
        title = new JLabel("Selected Product - Details");
        productID = new JLabel();
        category = new JLabel();
        name = new JLabel();
        size = new JLabel();
        color = new JLabel();
        brand = new JLabel();
        warranty = new JLabel();
        itemsAvailable = new JLabel();
    }
}
