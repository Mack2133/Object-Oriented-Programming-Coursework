import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ShoppingCartTableModel extends AbstractTableModel {
    private final String[] columnNames = {"Product","Quantity","Price"};
    private final ArrayList<Product> productList;

    ShoppingCartTableModel (ArrayList<Product> productList){
        this.productList = productList;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return productList.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Object value = null;

        if (columnIndex == 0){
            String ID = productList.get(rowIndex).getProductID();
            String Name = productList.get(rowIndex).getProductName();
            String brand;
            String warranty;
            String size;
            String color;
            if(productList.get(rowIndex) instanceof Electronics){
                brand = ((Electronics) productList.get(rowIndex)).getBrand();
                warranty = ((Electronics) productList.get(rowIndex)).getWarranty();
                value = ID + "\n" + Name + "\n" + brand + ", " + warranty;
            }

            if(productList.get(rowIndex) instanceof Clothing){
                size = ((Clothing) productList.get(rowIndex)).getSize();
                color = ((Clothing) productList.get(rowIndex)).getColor();
                value = ID + "\n" + Name + "\n" + size + ", " + color;
            }
        }

        if (columnIndex == 1){
            value = 1;
        }

        if (columnIndex == 2){
            value = productList.get(rowIndex).getProductPrice();
        }
        return value;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Class<?> getColumnClass(int col) {
        return switch (col) {
            case 0 -> String.class;
            case 1 -> Integer.class;
            case 2 -> Double.class;
            default -> Object.class;
        };
    }

}
