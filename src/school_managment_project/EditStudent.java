
package school_managment_project;

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

public class EditStudent extends JFrame implements ActionListener {

    JLabel nameL, FactulyL, courseL, idL, levelL, classL, labTimeL, rollnoL;
    JTextField nameTX, FactulyTX, courseTX, idTX, levelTX, classTX, rollNoTX;// nameTX, emailTX, passTX, contactNoTX;
    JButton updateStudentB, backB, loadRecordB;
    Mytable table = AdminSection.tableAss;
    String[] labTimeArr = new String[]{"Saturday 8-10", "Mon 1-3", "Tue 8-10", "Wed 2-4"};
    JComboBox labTimeCB = new JComboBox(labTimeArr);
    JPanel panel = new JPanel();

    public EditStudent() {
        setLayout(null);
        rollnoL = new JLabel("RollNo");
        rollNoTX = new JTextField();
        loadRecordB = new JButton("Load Record");

        panel = new JPanel(new GridLayout(7, 2, 50, 20));
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
        updateStudentB = new JButton("Update Student");
        backB = new JButton("Back");
        updateStudentB.addActionListener(this);
        loadRecordB.addActionListener(this);

        rollnoL.setBounds(20, 30, 150, 30);
        rollNoTX.setBounds(255, 30, 170, 25);
        loadRecordB.setBounds(450, 30, 120, 25);

        backB.addActionListener(this);

        nameTX.setEditable(false);
        courseTX.setEditable(false);
        FactulyTX.setEditable(false);
        idTX.setEditable(false);
        levelTX.setEditable(false);
        classTX.setEditable(false);
        labTimeCB.setEditable(false);
        updateStudentB.setEnabled(false);
        panel.setBounds(20, 70, 400, 300);
        updateStudentB.setBounds(170, 380, 200, 45);
        backB.setBounds(400, 380, 100, 30);
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
        add(rollnoL);
        add(rollNoTX);
        add(loadRecordB);
        add(panel);
        add(updateStudentB);
        add(backB);

    }

    public Student searchStudent() {
        boolean isfound = false;
        Student s = null;
        try {
            for (int i = 0; i < DataStore.students.size(); ++i) {

                if (DataStore.students.get(i).rollNo == Integer.parseInt(rollNoTX.getText())) {
                    s = DataStore.students.get(i);
                    isfound = true;
                    nameTX.setText(s.name);
                    FactulyTX.setText(s.Factuly);
                    courseTX.setText(s.course);
                    idTX.setText(s.id);
                    levelTX.setText(s.level);
                    classTX.setText(s.classN);
                    for (int j = 0; j < labTimeArr.length; ++j) {
                        if (s.labTime.equals(labTimeArr[i])) {
                            labTimeCB.setSelectedItem(i);
                            break;
                        }
                    }
                    break;
                }
            }
            if (!isfound) {
                JOptionPane.showMessageDialog(this, "Student isn't exist");

            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Wrong input");

        }
        return s;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Student s = null;
        if (e.getSource() == loadRecordB) {
            if (rollNoTX.getText() == null || rollNoTX.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Wrong input");
            } else if (searchStudent() != null) {
                nameTX.setEditable(true);
                courseTX.setEditable(true);
                FactulyTX.setEditable(true);
                idTX.setEditable(true);
                levelTX.setEditable(true);
                classTX.setEditable(true);
                labTimeCB.setEditable(true);
                updateStudentB.setEnabled(true);
            }
        } else if (e.getSource() == updateStudentB) {
            if (nameTX.getText() == null || nameTX.getText().equals(" ") || nameTX.getText().isEmpty()
                    || FactulyTX.getText() == null || FactulyTX.getText().equals(" ") || FactulyTX.getText().isEmpty()
                    || courseTX.getText() == null || courseTX.getText().equals(" ") || courseTX.getText().isEmpty()
                    || idTX.getText() == null || idTX.getText().equals(" ") || idTX.getText().isEmpty()
                    || levelTX.getText() == null || levelTX.getText().equals(" ") || levelTX.getText().isEmpty()
                    || classTX.getText() == null || classTX.getText().equals(" ") || classTX.getText().isEmpty()
                    || labTimeCB.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(this, "Have wrong input!!");
            } else {
                for (int i = 0; i < DataStore.students.size(); ++i) {

                    if (DataStore.students.get(i).rollNo == Integer.parseInt(rollNoTX.getText())) {
                        s = DataStore.students.get(i);
                        s.name = nameTX.getText();
                        s.Factuly = FactulyTX.getText();
                        s.course = courseTX.getText();
                        s.id = idTX.getText();
                        s.level = levelTX.getText();
                        s.classN = classTX.getText();
                        s.labTime = (String) labTimeCB.getSelectedItem();
                        JOptionPane.showMessageDialog(this, "Updated is done");
                        break;
                    }
                }

            }

        } else {
            this.setVisible(false);
        }
    }
}

