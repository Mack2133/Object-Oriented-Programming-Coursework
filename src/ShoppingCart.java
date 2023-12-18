import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.ArrayList;

public class ShoppingCart extends JFrame {
    private ArrayList<Product> productListOfCart;
    JTable table;
    JLabel total;
    JLabel FPD;
    JLabel threeItemDiscount;
    JLabel finalTotal;
    JLabel total_amount;
    JLabel FPD_amount;
    JLabel threeItemDiscount_amount;
    JLabel finalTotal_amount;
    ShoppingCartTableModel tableModel;

    ShoppingCart(ArrayList<Product> productList){
        productListOfCart = productList;
        tableModel = new ShoppingCartTableModel(productListOfCart);

        JPanel panel1 = new JPanel();
        panel1.setPreferredSize(new Dimension(550,450));
        panel1.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        JPanel panel2 = new JPanel();
        panel2.setPreferredSize(new Dimension(600,350));

        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        getContentPane().add(panel1);
        getContentPane().add(panel2);

        tableModel = new ShoppingCartTableModel(WestminsterShoppingCenter.getSelectedItems()); // custom table model
        // and passing the array

        // creating a table and passing the custom table model to it.
        table = new JTable(tableModel);
        table.setGridColor(Color.BLACK);
        table.setAutoCreateRowSorter(true); // sort the table by clicking the column name
        table.setRowHeight(100);
        table.getTableHeader().setFont(new Font("Product Sans",Font.BOLD,18));

        // adding table scrollPane
        JScrollPane scrollPane = new JScrollPane(table);
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

        // adding the table to panel2
        panel1.add(scrollPane);

        total = new JLabel("Total: ");
        total_amount = new JLabel();

        FPD = new JLabel("First Purchase Discount (10%): ");
        FPD_amount = new JLabel();

        threeItemDiscount = new JLabel("Three items in same category discount (20%): ");
        threeItemDiscount_amount = new JLabel();

        finalTotal = new JLabel("Final Total: ");
        finalTotal_amount = new JLabel();
        finalTotal.setFont(new Font("product sans",Font.BOLD,15));



        JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayout(4,2,60,20));
        panel3.add(total);
        panel3.add(total_amount);
        panel3.add(FPD);
        panel3.add(FPD_amount);
        panel3.add(threeItemDiscount);
        panel3.add(threeItemDiscount_amount);
        panel3.add(finalTotal);
        panel3.add(finalTotal_amount);

        panel2.setLayout(new FlowLayout(FlowLayout.RIGHT,-180,50));
        panel2.add(panel3);

        this.setTitle("Shopping Cart");
        this.setSize(800,600);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
    }

    public void addProduct () {
    }

    public void removeProduct(Product item) {
    }

    public void calculateTotal() {
    }

    public void displayProductList() {
    }

    public static void main(String[] args) {
    }
}
