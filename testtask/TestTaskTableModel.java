package testtask;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.util.ArrayList;

public class TestTaskTableModel extends AbstractTableModel implements TableModel {

    private ArrayList<String> columns;
    private ArrayList<String> colors;
    private ArrayList<ArrayList<String>> rows = new ArrayList<>();

    public TestTaskTableModel(ArrayList<String> columns, ArrayList<String> colors) {
        this.columns = columns;
        this.colors  = colors;
    }

    public String getColumnColor(int columnIndex) {
        return colors.get(columnIndex);
    }

    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public int getColumnCount() {
        return columns.size();
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columns.get(columnIndex);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return Object.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return rows.get(rowIndex).get(columnIndex);
    }

    public void addRow(ArrayList<String> row) {
        this.rows.add(row);
        fireTableDataChanged();
    }
}
