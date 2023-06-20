
package school_managment_project;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AssistantLogin extends JFrame implements ActionListener {

    JLabel titleL, nameL, passL;
    JTextField nameTX, passTX;
    JButton loginbtn, backbtn;

    public AssistantLogin() {
        titleL = new JLabel("Assistant Login");
        nameL = new JLabel("Name:");
        passL = new JLabel("Password:");
        nameTX = new JTextField();
        passTX = new JTextField();
        loginbtn = new JButton("Login");
        backbtn = new JButton("back");
        titleL.setFont(new Font("Arial", Font.BOLD, 20));
        titleL.setBounds(200, 20, 400, 30);
        loginbtn.addActionListener(this);
        backbtn.addActionListener(this);
        nameL.setBounds(80, 70, 200, 30);
        passL.setBounds(80, 110, 200, 30);
        nameTX.setBounds(300, 70, 200, 30);
        passTX.setBounds(300, 110, 200, 30);
        loginbtn.setBounds(180, 200, 150, 30);
        backbtn.setBounds(400, 200, 100, 30);

        add(titleL);
        add(nameL);
        add(nameTX);
        add(passL);
        add(passTX);
        add(loginbtn);
        add(backbtn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == loginbtn) {
            boolean isFound = false;
            for (int i = 0; i < DataStore.assistants.size(); ++i) {
                if (nameTX.getText().equals(DataStore.assistants.get(i).name) && passTX.getText().equals(DataStore.assistants.get(i).password)) {
                    isFound = true;
                    break;
                }
            }
            if (isFound) {
                JFrame assistantsection = new AssistantSection();
                assistantsection.setBounds(550, 200,500, 350);
                assistantsection.setLayout(null);
                assistantsection.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Login error!", "Sorry ,username or password error!", JOptionPane.ERROR_MESSAGE);

            }
        } else {
            this.setVisible(false);
        }

    }
}
