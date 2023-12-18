import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class WestminsterShoppingCenter extends JFrame implements ActionListener, MouseListener {
    private static final ArrayList<Product> selectedItems = new ArrayList<>();
    JComboBox<String> comboBox;
    JButton shoppingCartBtn;
    ProductTableModel tableModel;
    String selectedID;
    JTable table;
    JLabel productID;
    JLabel category2;
    JLabel name;
    JLabel size;
    JLabel color;
    JPanel panel4;
    JButton addProductBtn;

    WestminsterShoppingManager westminsterShoppingManager = new WestminsterShoppingManager();

    public WestminsterShoppingCenter(){

        JPanel panel1 = new JPanel();
        panel1.setBounds(0,0,1200,100); // first partition
        JPanel panel2 = new JPanel();
        panel2.setBounds(0,100,1200,357); // second partition
        JPanel panel3 = new JPanel();
        panel3.setBounds(0,450,1200,543); // third partition
        panel3.setLayout(new FlowLayout(FlowLayout.CENTER,80,60));

        JPanel panel1_1 = new JPanel(); // for the left part which the combobox and label are there.
        JPanel panel1_2 = new JPanel(); // for the shopping cart panel button
        panel1_2.setLayout(new FlowLayout(FlowLayout.RIGHT,10,10));

        // creating the label for comboBox
        JLabel label1 = new JLabel("Select Product Category");
        label1.setFont(new Font("Product Sans",Font.PLAIN,15));

        // setting up the comboBox
        String[] category = {"All","Electronics","Clothing"};
        comboBox = new JComboBox<>(category);
        comboBox.addActionListener(this);
        comboBox.setFont(new Font("Product Sans",Font.PLAIN,15));
        comboBox.setPreferredSize(new Dimension(200,80));

        // setting up the shopping cart button
        shoppingCartBtn = new JButton("Shopping Cart");
        shoppingCartBtn.setFont(new Font("Product Sans",Font.PLAIN,15));
        shoppingCartBtn.setPreferredSize(new Dimension(160,40));
        shoppingCartBtn.setFocusable(false);
        shoppingCartBtn.addActionListener(this);

        // adding the label and combo box to the left panel of the panel1 which is named panel1_1
        panel1_1.add(label1);
        panel1_1.add(comboBox);
        panel1_1.setLayout(new FlowLayout(FlowLayout.LEFT,100,20));

        // adding the shopping cart button to the right panel of the panel1 which is named panel1_2
        panel1_2.add(shoppingCartBtn);

        // adding both the panel1_1 & panel1_2 to the panel1
        panel1.add(panel1_1);
        panel1.add(panel1_2);
        panel1.setLayout(new GridLayout(1,2));

        tableModel = new ProductTableModel(westminsterShoppingManager.getProductsList()); // custom table model
        // and passing the array

        // creating a table and passing the custom table model to it.
        table = new JTable(tableModel);
        table.addMouseListener(this);
        table.setGridColor(Color.BLACK);
        table.setAutoCreateRowSorter(true); // sort the table by clicking the column name
        table.setRowHeight(40);
        table.getTableHeader().setFont(new Font("Product Sans",Font.BOLD,18));

        // adding table scrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(1100,400));

        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setPreferredSize(new Dimension(0,40));
        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) tableHeader.getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(JLabel.CENTER);

        DefaultTableCellRenderer tableCell = new DefaultTableCellRenderer();
        tableCell.setHorizontalAlignment( JLabel.CENTER );
        table.setDefaultRenderer(String.class, tableCell);
        table.setDefaultRenderer(Double.class, tableCell);

        // adding the table to panel2
        panel2.add(scrollPane);

        selectedID = "";

        panel4 = new JPanel();
        JPanel panel5 = new JPanel();

        JLabel title = new JLabel("Selected Product - Details");
        title.setFont(new Font("Product Sans",Font.BOLD,15));

        panel4.add(title);
        panel4.setLayout(new GridLayout(9,1,1,15));

        productID = new JLabel("Product ID: " );
        category2 = new JLabel("Category: ");
        name = new JLabel("Name: " );
        JLabel brand = new JLabel("Brand: " );
        JLabel warranty = new JLabel("Warranty: " );
        panel4.add(productID);
        panel4.add(category2);
        panel4.add(name);
        panel4.add(brand);
        panel4.add(warranty);
        JLabel itemsAvailable = new JLabel("Items Available: " );
        panel4.add(itemsAvailable);

        addProductBtn = new JButton("Add to Shopping Cart");
        addProductBtn.setPreferredSize(new Dimension(250,40));
        addProductBtn.setFont(new Font("Product Sans",Font.PLAIN,15));
        addProductBtn.setFocusable(false);
        addProductBtn.addActionListener(this);

        panel5.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        panel5.add(addProductBtn);

        JPanel panel6 = new JPanel();
        panel6.setLayout(new BorderLayout());
        panel6.add(panel4,BorderLayout.WEST);
        panel6.add(panel5,BorderLayout.SOUTH);
        panel6.setPreferredSize(new Dimension(1050,280));

        panel3.add(panel6);

        // adding the panel1, panel2 & panel3 to the frame
        this.add(panel1);
        this.add(panel2);
        this.add(panel3);

        this.setTitle("Westminster Shopping Center");
        this.setSize(1200,1000);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    public void updateUI() {
        panel4.removeAll();

        WestminsterShoppingManager westminsterShoppingManager = new WestminsterShoppingManager();
        ArrayList<Product> productsList = westminsterShoppingManager.getProductsList();

        for (Product product: productsList) {
            if (selectedID.equalsIgnoreCase(product.getProductID())){
                if (product instanceof Clothing) {
                    JLabel title = new JLabel("Selected Product - Details");
                    title.setFont(new Font("Product Sans",Font.BOLD,15));
                    panel4.add(title);
                    productID = new JLabel("Product ID: " + product.getProductID());
                    category2 = new JLabel("Category: Clothing");
                    name = new JLabel("Name: " + product.getProductName() );
                    size = new JLabel("Size: " + ((Clothing) product).getSize());
                    color = new JLabel("Color: " + ((Clothing) product).getColor());
                    panel4.add(productID);
                    panel4.add(category2);
                    panel4.add(name);
                    panel4.add(size);
                    panel4.add(color);
                    JLabel itemsAvailable = new JLabel("Items Available: " + product.getItemQuantity());
                    panel4.add(itemsAvailable);
                    break;
                }

                if (product instanceof Electronics) {
                    JLabel title = new JLabel("Selected Product - Details");
                    title.setFont(new Font("Product Sans",Font.BOLD,15));
                    panel4.add(title);
                    productID = new JLabel("Product ID: " + product.getProductID());
                    category2 = new JLabel("Category: Electronics");
                    name = new JLabel("Name: " + product.getProductName());
                    JLabel brand = new JLabel("Brand: " + ((Electronics) product).getBrand());
                    JLabel warranty = new JLabel("Warranty: " + ((Electronics) product).getWarranty());
                    panel4.add(productID);
                    panel4.add(category2);
                    panel4.add(name);
                    panel4.add(brand);
                    panel4.add(warranty);
                    JLabel itemsAvailable = new JLabel("Items Available: " + product.getItemQuantity());
                    panel4.add(itemsAvailable);
                    break;
                }
            }
        }
        panel4.revalidate();
        panel4.repaint();
    }

    public static ArrayList<Product> getSelectedItems() {
        return selectedItems;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==shoppingCartBtn){
            ShoppingCartTableModel shoppingCart = new ShoppingCartTableModel(selectedItems);
            shoppingCart.updateData(getSelectedItems());
            new ShoppingCart(selectedItems);
        }

        if (e.getSource()==comboBox){

            if(comboBox.getSelectedItem()==("Electronics")){
                westminsterShoppingManager.updateProductList("Electronics");
                tableModel.updateData(westminsterShoppingManager.getProductsList());
            }
            if(comboBox.getSelectedItem()==("Clothing")){
                westminsterShoppingManager.updateProductList("Clothing");
                tableModel.updateData(westminsterShoppingManager.getProductsList());
            }
            if (comboBox.getSelectedItem()==("All")){
                westminsterShoppingManager.updateProductList("All");
                tableModel.updateData(westminsterShoppingManager.getProductsList());
            }
        }
        if (e.getSource()==addProductBtn){
            ShoppingCartTableModel shoppingCart = new ShoppingCartTableModel(selectedItems);
            shoppingCart.updateData(getSelectedItems());
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==table){
            int selectedRow = table.getSelectedRow();
            selectedID = (String)table.getValueAt(selectedRow, 0);
            updateUI();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public static void main(String[] args) {
        new WestminsterShoppingCenter();
    }

}