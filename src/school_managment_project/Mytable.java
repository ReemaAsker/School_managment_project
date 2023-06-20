
package school_managment_project;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Mytable extends JFrame {

    Object[] tableTitle = new String[]{"Empty", "Empty", "Empty "};
    JTable myTable = new JTable();
    JScrollPane sp = new JScrollPane(myTable);
    DefaultTableModel tbmodel = (DefaultTableModel) myTable.getModel();

    public Mytable(String[] heders) {
        tableTitle = heders;
        setSize(600, 500);
        setLayout(null);

        tbmodel.setColumnIdentifiers(tableTitle);
        sp.setBounds(10, 20, 560, 400);
        add(sp);

//             setVisible(true);
    }

    public void addRow(String[] information) {
        tbmodel.addRow(information);
    }

    public JTable getTable() {
        return myTable;
    }

}
