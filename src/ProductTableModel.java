import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ProductTableModel extends AbstractTableModel {
    private final String[] columnNames = {"Product ID","Name","Category","Price","info"};
    private ArrayList<Product> productList;

    ProductTableModel(ArrayList<Product> productList){
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
            value = productList.get(rowIndex).getProductID();
        }

        if (columnIndex == 1){
            value = productList.get(rowIndex).getProductName();
        }

        if (columnIndex == 2){
            if(productList.get(rowIndex) instanceof Electronics){
                value = "Electronics";
            }

            if(productList.get(rowIndex) instanceof Clothing){
                value = "Clothing";
            }
        }

        if (columnIndex == 3){
            value = productList.get(rowIndex).getProductPrice();
        }

        if (columnIndex == 4){
            if(productList.get(rowIndex) instanceof Electronics){
                String brand = ((Electronics) productList.get(rowIndex)).getBrand();
                String warranty = ((Electronics) productList.get(rowIndex)).getWarranty();
                value = brand + ", " + warranty;
            }

            if(productList.get(rowIndex) instanceof Clothing){
                String size = ((Clothing) productList.get(rowIndex)).getSize();
                String color = ((Clothing) productList.get(rowIndex)).getColor();
                value = size + ", " + color;
            }
        }
        return value;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Class<?> getColumnClass(int col){
        if(col == 3){
            return Double.class;
        } else
            return String.class;
    }

    public void updateData(ArrayList<Product> newProductList) {
        this.productList = newProductList;
        fireTableDataChanged();
    }
}
