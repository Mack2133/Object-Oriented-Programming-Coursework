import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class QuantityColorRenderer extends DefaultTableCellRenderer {
    private static final Color LOW_QUANTITY_COLOR = Color.RED;

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component rowComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        int quantityColumn = table.getColumnCount() - 1;
        int quantity = Integer.parseInt(table.getValueAt(row, quantityColumn).toString());

        if (quantity < 3) {
            rowComponent.setBackground(LOW_QUANTITY_COLOR);
            rowComponent.setForeground(Color.WHITE); // Adjust text color for better visibility
        } else {
            rowComponent.setBackground(table.getBackground());
            rowComponent.setForeground(table.getForeground());
        }

        return rowComponent;
    }
}
