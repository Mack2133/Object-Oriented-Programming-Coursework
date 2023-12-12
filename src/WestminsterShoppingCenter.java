import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WestminsterShoppingCenter extends JFrame implements ActionListener {

    JComboBox comboBox;
    JButton shoppingCartBtn;

    WestminsterShoppingCenter(){

        JPanel panel1 = new JPanel();
        panel1.setBounds(0,0,1200,100); // first partition
        JPanel panel2 = new JPanel();
        panel2.setBounds(0,100,1200,350); // second partition
        JPanel panel3 = new JPanel();
        panel3.setBounds(0,600,1200,400); // third partition

        String[] category = {"All","Electronic","Clothing"};

        JPanel panel1_1 = new JPanel();
        JPanel panel1_2 = new JPanel();
        panel1_2.setLayout(new FlowLayout(FlowLayout.RIGHT,10,10));

        JLabel label1 = new JLabel("Select Product Category");
        label1.setFont(new Font("Product Sans",Font.PLAIN,15));
        comboBox = new JComboBox(category);
        comboBox.setFont(new Font("Product Sans",Font.PLAIN,15));
        comboBox.setPreferredSize(new Dimension(200,80));

        shoppingCartBtn = new JButton("Shopping Cart");
        shoppingCartBtn.setFont(new Font("Product Sans",Font.PLAIN,15));
        shoppingCartBtn.setPreferredSize(new Dimension(160,40));
        shoppingCartBtn.setFocusable(false);
        shoppingCartBtn.addActionListener(this);

        panel1_1.add(label1);
        panel1_1.add(comboBox);
        panel1_1.setLayout(new FlowLayout(FlowLayout.LEFT,100,20));
        panel1_2.add(shoppingCartBtn);

        panel1.add(panel1_1);
        panel1.add(panel1_2);
        panel1.setLayout(new GridLayout(1,2));
        this.add(panel1);

        WestminsterShoppingManager shoppingManager = new WestminsterShoppingManager();
        ProductTableModel tableModel = new ProductTableModel(shoppingManager.getProductsList());

        JTable table = new JTable(tableModel);
        table.getTableHeader().setFont(new Font("Product Sans",Font.BOLD,18));

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(1100,400));

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        table.setDefaultRenderer(String.class, centerRenderer);
        table.setDefaultRenderer(Double.class, centerRenderer);

        panel2.add(scrollPane);

        this.add(panel2);
        this.add(panel3);

        this.setTitle("Westminster Shopping Center");
        this.setSize(1200,1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);
        this.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==shoppingCartBtn){
            new ShoppingCart();
        }

        if (e.getSource()==comboBox){
            if(comboBox.getSelectedItem()==("All")){

            }
        }
    }

    public static void main(String[] args) {
        new WestminsterShoppingCenter();
    }
}