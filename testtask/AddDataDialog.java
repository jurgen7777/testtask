package testtask;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddDataDialog extends JDialog {

    private JButton confirmBtn  = new JButton("Add to table");
    private JPanel panelSouth   = new JPanel();
    private JPanel panelCenter  = new JPanel();


    public AddDataDialog(ArrayList<String> columns) {
        super();

        for(String columnName: columns) {
            panelCenter.add(new JTextField(columnName));
        }

        setLayout(new BorderLayout());

        panelSouth.add(confirmBtn);
        add(panelSouth, BorderLayout.SOUTH);
        add(panelCenter, BorderLayout.CENTER);

        pack();
    }

    public void addConfirmButtonListener(ActionListener listener) {
        confirmBtn.addActionListener(listener);
    }

    public ArrayList<String> getTextFieldsValues() {
        ArrayList<String> values = new ArrayList<>();

        for(Component c: panelCenter.getComponents()) {
            if (c instanceof JTextField) {
                values.add(((JTextField) c).getText());
            }
        }

        return values;
    }

}
