
package school_managment_project;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

public class AdminSection extends JFrame implements ActionListener {

    JLabel title;
    JButton addAssistantB, viewAssistantB, logoutB;
    static String[] headers = new String[]{"Id ", "Name", "Password ", "Email ", "ContactNo "};
    static Mytable tableAss = new Mytable(headers);

    AdminSection() {
        setLayout(null);
        setBounds(550, 200, 500, 350);
        title = new JLabel(" Admin Section ");
        addAssistantB = new JButton(" Add Assistant ");
        viewAssistantB = new JButton(" View Assistant ");
        logoutB = new JButton(" logoutB ");
        addAssistantB.addActionListener(this);
        viewAssistantB.addActionListener(this);
        logoutB.addActionListener(this);

        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBounds(170, 20, 250, 30);
        addAssistantB.setBounds(170, 100, 150, 30);
        viewAssistantB.setBounds(170, 150, 150, 30);
        logoutB.setBounds(170, 200, 150, 30);
        add(title);
        add(addAssistantB);
        add(viewAssistantB);
        add(logoutB);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addAssistantB) {
            JFrame addassistant = new AddAssistant();
            addassistant.setBounds(550, 200,600, 450);
            addassistant.setLayout(null);
            addassistant.setVisible(true);

        } else if (e.getSource() == viewAssistantB) {
            tableAss.setVisible(false);
            tableAss.setVisible(true);
            ((DefaultTableModel) tableAss.getTable().getModel()).setNumRows(0);
            for (int i = 0; i < DataStore.assistants.size(); ++i) {
                tableAss.addRow(new String[]{(DataStore.assistants.get(i).id + ""), DataStore.assistants.get(i).name, DataStore.assistants.get(i).password, DataStore.assistants.get(i).email, DataStore.assistants.get(i).contactNo});
            }

        } else if (e.getSource() == logoutB) {
            System.exit(0);
        }
    }

}
