
package school_managment_project;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public 
class AdminLogin extends JFrame implements ActionListener {

    JLabel titleL, nameL, passL;
    JTextField nameTX, passTX;
    JButton loginbtn;

    public AdminLogin() {
        titleL = new JLabel("Admin Login");
        nameL = new JLabel("Name:");
        passL = new JLabel("Password:");
        nameTX = new JTextField();
        passTX = new JTextField();
        loginbtn = new JButton("Login");
        titleL.setFont(new Font("Arial", Font.BOLD, 20));
        titleL.setBounds(200, 20, 400, 30);
        loginbtn.addActionListener(this);
        nameL.setBounds(80, 70, 200, 30);
        passL.setBounds(80, 110, 200, 30);
        nameTX.setBounds(300, 70, 200, 30);
        passTX.setBounds(300, 110, 200, 30);
        loginbtn.setBounds(180, 200, 200, 30);

        add(titleL);
        add(nameL);
        add(nameTX);
        add(passL);
        add(passTX);
        add(loginbtn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (nameTX.getText().equalsIgnoreCase("admin") && passTX.getText().equals("123")) {
            JFrame adminsection = new AdminSection();
            adminsection.setBounds(550, 200,500, 350);
            adminsection.setLayout(null);
            adminsection.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Error", "Wrong input!!", 0);
        }
    }
}
