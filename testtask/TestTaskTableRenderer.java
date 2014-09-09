package testtask;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

/**
 * Created by yuri on 9/8/14.
 */
public class TestTaskTableRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        c.setBackground(
                Color.decode(
                        ((TestTaskTableModel)table.getModel()).getColumnColor(column)
                )
        );

        return c;
    }
}
