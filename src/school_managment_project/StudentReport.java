
package school_managment_project;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class StudentReport extends JFrame implements ActionListener {

    JLabel title;
    JButton adminloginB, assistantloginB;

    StudentReport() {
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(550, 200, 500, 350);
        title = new JLabel(" Student Report ");
        adminloginB = new JButton(" Admin Login ");
        assistantloginB = new JButton(" Assistant Login ");
        adminloginB.addActionListener(this);
        assistantloginB.addActionListener(this);

        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBounds(170, 20, 250, 30);
        adminloginB.setBounds(170, 100, 150, 30);
        assistantloginB.setBounds(170, 190, 150, 30);
        add(title);
        add(adminloginB);
        add(assistantloginB);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == adminloginB) {
            JFrame login = new AdminLogin();
            login.setBounds(550, 200,600, 350);
            login.setLayout(null);
            login.setVisible(true);
        } else {
            JFrame Asslogin = new AssistantLogin();
            Asslogin.setBounds(550, 200,600, 350);
            Asslogin.setLayout(null);
            Asslogin.setVisible(true);
        }
    }

    public static void main(String[] args) {
        new StudentReport();
    }

}
