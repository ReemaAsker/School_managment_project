
package school_managment_project;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AssistantSection extends JFrame implements ActionListener {

    JLabel title;
    JButton addStudentB, viewStudenB, editStudentB, deleteStudentB, logoutB;
    static String[] headers = new String[]{"Rollno ", "Name", "Faculty ", "Course ", "ID ", " Level ", " Class ", " Lab_Time "};
    static Mytable tableAss = new Mytable(headers);

    AssistantSection() {
        setLayout(null);
        setBounds(550, 200, 500, 350);
        title = new JLabel(" Assistant Section ");
        addStudentB = new JButton(" Add Student ");
        viewStudenB = new JButton(" View Student ");

        editStudentB = new JButton(" Edit Student ");
        deleteStudentB = new JButton(" Delete Student ");

        logoutB = new JButton(" logoutB ");
        addStudentB.addActionListener(this);
        viewStudenB.addActionListener(this);
        editStudentB.addActionListener(this);
        deleteStudentB.addActionListener(this);
        logoutB.addActionListener(this);

        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBounds(170, 20, 250, 30);
        addStudentB.setBounds(70, 100, 150, 30);
        viewStudenB.setBounds(250, 100, 150, 30);
        editStudentB.setBounds(70, 160, 150, 30);
        deleteStudentB.setBounds(250, 160, 150, 30);
        logoutB.setBounds(185, 220, 150, 30);
        add(title);
        add(addStudentB);
        add(viewStudenB);
        add(editStudentB);
        add(deleteStudentB);
        add(logoutB);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addStudentB) {
            JFrame addStudent = new AddStudent();
            addStudent.setBounds(550, 200,600, 500);
            addStudent.setLayout(null);
            addStudent.setVisible(true);
        } else if (e.getSource() == viewStudenB) {
            tableAss.setVisible(false);
            tableAss.setVisible(true);
            ((DefaultTableModel) tableAss.getTable().getModel()).setNumRows(0);
            for (int i = 0; i < DataStore.students.size(); ++i) {
                tableAss.addRow(new String[]{(DataStore.students.get(i).rollNo + ""), DataStore.students.get(i).name, DataStore.students.get(i).Factuly, DataStore.students.get(i).course, DataStore.students.get(i).id, DataStore.students.get(i).level, DataStore.students.get(i).classN, DataStore.students.get(i).labTime});
            }
        } else if (e.getSource() == editStudentB) {
            JFrame editStudent = new EditStudent();
            editStudent.setBounds(550, 200,600, 500);
            editStudent.setLayout(null);
            editStudent.setVisible(true);

        } else if (e.getSource() == deleteStudentB) {
            try {
                String rollno = JOptionPane.showInputDialog(this, "Enter Roll No. ", "Delete Student", JOptionPane.QUESTION_MESSAGE);
                int rollnostdDelete = Integer.parseInt(rollno);
                boolean isDelete = false;
                for (int i = 0; i < DataStore.students.size(); ++i) {
                    if (DataStore.students.get(i).rollNo == rollnostdDelete) {
                        isDelete = true;
                        DataStore.students.remove(DataStore.students.get(i));
                        Student.rollCnt--;
                        DataStore.updateRollNoAfterDeleteStd();
                        JOptionPane.showMessageDialog(this, "Deleted is done");
                        break;
                    }
                }
                if (!isDelete) {
                    JOptionPane.showMessageDialog(this, "Student isn't exist");
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Wrong Input");
            }
        } else if (e.getSource() == logoutB) {
            System.exit(0);
        }
    }

}
