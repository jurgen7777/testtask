package testtask;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by yuri on 9/8/14.
 */
public class TestApplication extends JFrame {

    private static ArrayList<String> columns;
    private static ArrayList<String> colors;

    private JButton showDialogBtn         = new JButton("Add data...");
    private JPanel panelNorth             = new JPanel();
    private JPanel panelCenter            = new JPanel();
    private AddDataDialog addDataDialog   = new AddDataDialog(columns);
    private TestTaskTableModel tableModel = new TestTaskTableModel(columns, colors);
    private JTable dataTable              = new JTable(tableModel);
    private JScrollPane jScrollPane       = new JScrollPane(dataTable);

    public TestApplication(String title) {
        super(title);

        dataTable.setDefaultRenderer(Object.class, new TestTaskTableRenderer());
        dataTable.getTableHeader().setDefaultRenderer(new TestTaskTableRenderer());


        setLayout(new BorderLayout());

        panelNorth.add(showDialogBtn);
        panelCenter.add(jScrollPane);

        add(panelNorth, BorderLayout.NORTH);
        add(panelCenter, BorderLayout.CENTER);

        showDialogBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!addDataDialog.isVisible()) {
                    addDataDialog.setVisible(true);
                }
            }
        });

        addDataDialog.addConfirmButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (addDataDialog.isVisible()) {
                    addDataDialog.setVisible(false);
                    tableModel.addRow(addDataDialog.getTextFieldsValues());

                }
            }
        });

    }

    public static void createAndShowGUI() {

        System.out.println(System.getProperty("user.dir"));

        String columnFilePath = System.getProperty("user.dir") + "/../testfiles/column_names.csv";
        String colorFilePath = System.getProperty("user.dir") + "/../testfiles/color_names.csv";

        columns = ParamsFileReader.readParamsFile(columnFilePath);
        colors  = ParamsFileReader.readParamsFile(colorFilePath);

        JFrame frame = new TestApplication("Test Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
