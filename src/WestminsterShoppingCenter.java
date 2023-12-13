import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WestminsterShoppingCenter extends JFrame implements ActionListener {
    JComboBox<String> comboBox;
    JButton shoppingCartBtn;
    ProductTableModel tableModel;
    WestminsterShoppingManager westminsterShoppingManager = new WestminsterShoppingManager();

    WestminsterShoppingCenter(){
        JPanel panel1 = new JPanel();
        panel1.setBounds(0,0,1200,100); // first partition
        JPanel panel2 = new JPanel();
        panel2.setBounds(0,100,1200,357); // second partition
        JPanel panel3 = new JPanel();
        panel3.setBounds(0,450,1200,543); // third partition

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

        WestminsterShoppingManager shoppingManager = new WestminsterShoppingManager();
        tableModel = new ProductTableModel(shoppingManager.getProductsList()); // custom table model
        // and passing the array

        // creating a table and passing the custom table model to it.
        JTable table = new JTable(tableModel);
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

        // adding the panel1, panel2 & panel3 to the frame
        this.add(panel1);
        this.add(panel2);
        this.add(panel3);

        this.setTitle("Westminster Shopping Center");
        this.setSize(1200,1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==shoppingCartBtn){
            new ShoppingCart();
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
    }

    public static void main(String[] args) {
        new WestminsterShoppingCenter();
    }

}