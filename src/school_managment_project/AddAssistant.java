
package school_managment_project;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddAssistant extends JFrame implements ActionListener {

    JLabel titleL, nameL, emailL, passL, contactNoL;
    JTextField nameTX, emailTX, passTX, contactNoTX;
    JButton addAssistantB, backB;
    Mytable table = AdminSection.tableAss;

    public AddAssistant() {
        titleL = new JLabel("Add Assistant");
        titleL.setFont(new Font("Arial", Font.BOLD, 20));
        nameL = new JLabel("Name:");
        passL = new JLabel("Password:");
        emailL = new JLabel("Email:");
        contactNoL = new JLabel("Contact No:");
        nameTX = new JTextField();
        emailTX = new JTextField();
        passTX = new JTextField();
        contactNoTX = new JTextField();
        addAssistantB = new JButton("Add Assistant");
        backB = new JButton("Back");
        addAssistantB.addActionListener(this);
        backB.addActionListener(this);
        titleL.setBounds(200, 20, 400, 30);
        nameL.setBounds(80, 70, 200, 30);
        emailL.setBounds(80, 150, 200, 30);
        passL.setBounds(80, 110, 200, 30);
        contactNoL.setBounds(80, 190, 200, 30);
        nameTX.setBounds(300, 70, 200, 30);
        emailTX.setBounds(300, 150, 200, 30);
        passTX.setBounds(300, 110, 200, 30);
        contactNoTX.setBounds(300, 190, 200, 30);
        addAssistantB.setBounds(170, 270, 200, 45);
        backB.setBounds(400, 270, 100, 30);
        add(titleL);
        add(nameL);
        add(nameTX);
        add(emailL);
        add(emailTX);
        add(passL);
        add(passTX);
        add(contactNoTX);
        add(contactNoL);
        add(addAssistantB);
        add(backB);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == addAssistantB) {
            String userName = nameTX.getText();
            String userPass = passTX.getText();
            String userEmail = emailTX.getText();
            String usercontactno = contactNoTX.getText();
            if (userName == null || userName.equals(" ") || userName.isEmpty()
                    || userEmail == null || userEmail.equals(" ") || userEmail.isEmpty()
                    || userPass == null || userPass.equals(" ") || userPass.isEmpty()
                    || usercontactno == null || usercontactno.equals(" ") || usercontactno.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Sorry ,Unable to add Assistant!!");

            } else {

                Assistant assisstant = new Assistant(userName, userPass, userEmail, usercontactno);
                DataStore.assistants.add(assisstant);
                JOptionPane.showMessageDialog(this, "Assistant Added Successfully!!");
            }

        } else {
            this.setVisible(false);
        }
    }

}
