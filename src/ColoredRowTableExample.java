import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class ColoredRowTableExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Colored Row Table Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Sample data
            Object[][] data = {
                    {"John", "Doe", 10},
                    {"Jane", "Smith", 25},
                    {"Bob", "Johnson", 40}
            };

            // Column names
            String[] columnNames = {"First Name", "Last Name", "Age"};

            // Create a JTable with custom model
            JTable table = new JTable(data, columnNames);

            // Set custom cell renderer for the entire table
            table.setDefaultRenderer(Object.class, new ColoredRowRenderer());

            JScrollPane scrollPane = new JScrollPane(table);
            frame.getContentPane().add(scrollPane);

            frame.setSize(400, 300);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    // Custom cell renderer for coloring rows based on age
    static class ColoredRowRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                       boolean hasFocus, int row, int column) {
            Component rendererComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            // Check the condition for coloring rows with age 25 or below
            int ageColumnIndex = 2; // Assuming the age column is at index 2
            Object ageValue = table.getValueAt(row, ageColumnIndex);

            if (ageValue instanceof Integer) {
                int age = (int) ageValue;
                if (age <= 25) {
                    rendererComponent.setBackground(Color.YELLOW);
                } else {
                    rendererComponent.setBackground(table.getBackground());
                }
            }

            return rendererComponent;
        }
    }
}
