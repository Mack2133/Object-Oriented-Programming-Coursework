import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.ArrayList;

public class ShoppingCart {
    private JPanel panel1;
    private JLabel total_amount;
    private JLabel FPD_amount;
    private JLabel threeItemDiscount_amount;
    private JLabel finalTotal_amount;
    JScrollPane scrollPane;
    static JFrame shoppingCartFrame;

    ShoppingCart() {
        initUI();  // Initialize the UI components

        addProduct(); // Adding the products to the table

        shoppingCartFrame = new JFrame();
        shoppingCartFrame.setTitle("Shopping Cart");
        shoppingCartFrame.setSize(800, 600);
        shoppingCartFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        shoppingCartFrame.setResizable(false);
        shoppingCartFrame.setLocation(50, 50);

        // Add the main panel to the JFrame
        shoppingCartFrame.getContentPane().add(panel1);

        // Make the frame visible
        shoppingCartFrame.setVisible(true);
    }

    private void initUI() {
        panel1 = new JPanel();
        panel1.setPreferredSize(new Dimension(550, 350));
        panel1.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel panel2 = new JPanel();
        panel2.setPreferredSize(new Dimension(600, 250));
        panel2.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panel2.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, -180));

        JLabel total = new JLabel("Total: ");
        total_amount = new JLabel();

        JLabel FPD = new JLabel("First Purchase Discount (10%): ");
        FPD_amount = new JLabel();

        JLabel threeItemDiscount = new JLabel("Three items in the same category discount (20%): ");
        threeItemDiscount_amount = new JLabel("0.0");

        JLabel finalTotal = new JLabel("Final Total: ");
        finalTotal_amount = new JLabel();
        finalTotal.setFont(new Font("product sans", Font.BOLD, 15));

        JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayout(4, 2, 60, 20));
        panel3.add(total);
        panel3.add(total_amount);
        panel3.add(FPD);
        panel3.add(FPD_amount);
        panel3.add(threeItemDiscount);
        panel3.add(threeItemDiscount_amount);
        panel3.add(finalTotal);
        panel3.add(finalTotal_amount);

        // Add the labels and amounts to the main container
        panel2.add(panel3);

        // Set up the main panel layout
        panel1.setLayout(new BorderLayout());

        // Add the main container to the main panel
        panel1.add(panel2, BorderLayout.SOUTH);
    }

    public void addProduct () {
        if (shoppingCartFrame!=null){
            panel1.remove(scrollPane);
        }
        ShoppingCartTableModel tableModel = new ShoppingCartTableModel(WestminsterShoppingCenter.getSelectedItems()); // custom table model
        // and passing the array

        // creating a table and passing the custom table model to it.
        JTable table = new JTable(tableModel);
        table.setGridColor(Color.BLACK);
        table.setAutoCreateRowSorter(true); // sort the table by clicking the column name
        table.setRowHeight(100);
        table.getTableHeader().setFont(new Font("Product Sans",Font.BOLD,18));
        table.setFocusable(false);

        // adding table scrollPane
        scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(750,300));

        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setPreferredSize(new Dimension(0,100));
        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) tableHeader.getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(JLabel.CENTER);

        DefaultTableCellRenderer tableCell = new DefaultTableCellRenderer();
        tableCell.setHorizontalAlignment( JLabel.CENTER );
        table.setDefaultRenderer(String.class, tableCell);
        table.setDefaultRenderer(Double.class, tableCell);
        table.setDefaultRenderer(Integer.class, tableCell);

        // adding the table to panel1
        panel1.add(scrollPane);

        calculateTotal(); // Calculating the products total
        if (shoppingCartFrame!=null){
            shoppingCartFrame.revalidate();
            shoppingCartFrame.repaint();
        }
    }

    public void removeProduct(Product item) {
    }

    public void calculateTotal() {
        ArrayList<Product> selectedItems = WestminsterShoppingCenter.getSelectedItems();

        double totalPrice = 0;
        int countElectronics = 0;
        int countClothing = 0;

        for (Product selectedItem : selectedItems) {
            totalPrice += selectedItem.getProductPrice();

            if (selectedItem instanceof Electronics) {
                countElectronics++;
            }

            if (selectedItem instanceof Clothing) {
                countClothing++;
            }
        }

        double _10percent_discount = (totalPrice * 0.1);
        double _20percent_discount = 0;

        if (countElectronics >= 3 || countClothing >= 3) {
            _20percent_discount = (totalPrice * 0.2);
        }

        total_amount.setText(String.valueOf(totalPrice));
        FPD_amount.setText(String.format("%.2f", totalPrice * 0.1));
        threeItemDiscount_amount.setText(String.format("%.2f", _20percent_discount));

        finalTotal_amount.setText(String.format("%.2f", totalPrice - (_10percent_discount + _20percent_discount)));
    }
}
