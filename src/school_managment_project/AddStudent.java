
package school_managment_project;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddStudent extends JFrame implements ActionListener {

    JLabel titleL, nameL, FactulyL, courseL, idL, levelL, classL, labTimeL;
    JTextField nameTX, FactulyTX, courseTX, idTX, levelTX, classTX;// nameTX, emailTX, passTX, contactNoTX;
    JButton addStudentB, backB;
    Mytable table = AdminSection.tableAss;
    JComboBox labTimeCB = new JComboBox(new String[]{"Saturday 8-10", "Mon 1-3", "Tue 8-10", "Wed 2-4"});
    JPanel panel = new JPanel();

    public AddStudent() {
        setLayout(null);
        panel = new JPanel(new GridLayout(7, 2, 50, 20));
        titleL = new JLabel("Add Student");
        titleL.setFont(new Font("Arial", Font.BOLD, 20));
        nameL = new JLabel("Name:");
        FactulyL = new JLabel("Factuly:");
        courseL = new JLabel("Course:");
        idL = new JLabel("ID:");
        levelL = new JLabel("Level:");
        classL = new JLabel("Class:");
        labTimeL = new JLabel("Class:");
        nameTX = new JTextField();
        courseTX = new JTextField();
        FactulyTX = new JTextField();
        idTX = new JTextField();
        levelTX = new JTextField();
        classTX = new JTextField();
        addStudentB = new JButton("Add Student");
        backB = new JButton("Back");
        addStudentB.addActionListener(this);
        backB.addActionListener(this);
        titleL.setBounds(200, 10, 400, 30);
        panel.setBounds(20, 50, 400, 300);
        addStudentB.setBounds(170, 380, 200, 45);
        backB.setBounds(400, 380, 100, 30);
        add(titleL);
        panel.add(nameL);
        panel.add(nameTX);
        panel.add(FactulyL);
        panel.add(FactulyTX);
        panel.add(courseL);
        panel.add(courseTX);
        panel.add(idL);
        panel.add(idTX);
        panel.add(levelL);
        panel.add(levelTX);
        panel.add(classL);
        panel.add(classTX);
        panel.add(labTimeL);
        panel.add(labTimeCB);
        add(titleL);
        add(panel);
        add(addStudentB);
        add(backB);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addStudentB) {

            if (nameTX.getText() == null || nameTX.getText().equals(" ") || nameTX.getText().isEmpty()
                    || FactulyTX.getText() == null || FactulyTX.getText().equals(" ") || FactulyTX.getText().isEmpty()
                    || courseTX.getText() == null || courseTX.getText().equals(" ") || courseTX.getText().isEmpty()
                    || idTX.getText() == null || idTX.getText().equals(" ") || idTX.getText().isEmpty()
                    || levelTX.getText() == null || levelTX.getText().equals(" ") || levelTX.getText().isEmpty()
                    || classTX.getText() == null || classTX.getText().equals(" ") || classTX.getText().isEmpty()
                    || labTimeCB.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(this, "Sorry ,Unable to add Student!!");
            } else {
                Student student = new Student(nameTX.getText(), FactulyTX.getText(), courseTX.getText(), idTX.getText(), levelTX.getText(), classTX.getText(), (String) labTimeCB.getSelectedItem());
                DataStore.students.add(student);
                JOptionPane.showMessageDialog(this, "Student Added Successfully!!");
            }

        } else {
            this.setVisible(false);
        }
    }
}
