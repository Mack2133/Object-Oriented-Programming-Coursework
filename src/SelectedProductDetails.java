import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SelectedProductDetails extends JPanel implements ActionListener {
    JButton addProductBtn;
    String selectedID = "";

    public void updateUI(){
        JPanel panel2 = new JPanel();
        JPanel panel1 = new JPanel();

        JLabel title = new JLabel("Selected Product - Details");
        title.setFont(new Font("Product Sans",Font.BOLD,15));

        JLabel productID;
        JLabel category;
        JLabel name;
        JLabel size;
        JLabel color;

        WestminsterShoppingManager westminsterShoppingManager = new WestminsterShoppingManager();
        ArrayList<Product> productsList = westminsterShoppingManager.getProductsList();

        System.out.println(selectedID + " product Details 02");

        panel1.add(title);
        panel1.setLayout(new GridLayout(9,1,1,15));

        if (!(selectedID==null)){
            for (Product product: productsList) {
                if ("id1".equalsIgnoreCase(product.getProductID())){
                    if (product instanceof Clothing) {
                        productID = new JLabel("Product ID: " + product.getProductID());
                        category = new JLabel("Category: Clothing");
                        name = new JLabel("Name: " + product.getProductName() );
                        size = new JLabel("Size: " + ((Clothing) product).getSize());
                        color = new JLabel("Color: " + ((Clothing) product).getColor());
                        panel1.add(productID);
                        panel1.add(category);
                        panel1.add(name);
                        panel1.add(size);
                        panel1.add(color);
                        JLabel itemsAvailable = new JLabel("Items Available: " + Product.getNumberOfAvailableItems());
                        panel1.add(itemsAvailable);
                    }

                    if (product instanceof Electronics) {
                        productID = new JLabel("Product ID: " + product.getProductID());
                        category = new JLabel("Category: Electronics");
                        name = new JLabel("Name: " + product.getProductName());
                        JLabel brand = new JLabel("Brand: " + ((Electronics) product).getBrand());
                        JLabel warranty = new JLabel("Warranty: " + ((Electronics) product).getWarranty());
                        panel1.add(productID);
                        panel1.add(category);
                        panel1.add(name);
                        panel1.add(brand);
                        panel1.add(warranty);
                        JLabel itemsAvailable = new JLabel("Items Available: " + Product.getNumberOfAvailableItems());
                        panel1.add(itemsAvailable);
                    }
                }
            }
        }

        addProductBtn = new JButton("Add to Shopping Cart");
        addProductBtn.setPreferredSize(new Dimension(250,40));
        addProductBtn.setFont(new Font("Product Sans",Font.PLAIN,15));
        addProductBtn.setFocusable(false);

        panel2.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        panel2.add(addProductBtn);

        this.setLayout(new BorderLayout());
        this.add(panel1,BorderLayout.WEST);
        this.add(panel2,BorderLayout.SOUTH);
        this.setPreferredSize(new Dimension(1050,280));
    }

    public void setSelectedID(String selectedID) {
        this.selectedID = selectedID;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==addProductBtn){
            System.out.println("Added");
        }
    }
}