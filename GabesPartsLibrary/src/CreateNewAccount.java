import com.opencsv.CSVWriter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateNewAccount extends JFrame {
    private JTextField userNameInput;
    private JTextField passwordInput;
    private JTextField fullNameInput;
    private JRadioButton yesAdmin;
    private JRadioButton noAdmin;
    private JButton submitButton;
    private JButton cancelButton;
    private JPanel newAccountPanel;

    public CreateNewAccount(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(newAccountPanel);
        this.pack();


        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (userNameInput.getText().isEmpty() || passwordInput.getText().isEmpty() || fullNameInput.getText().isEmpty() || (!yesAdmin.isSelected() && !noAdmin.isSelected())) {
                    // I found this neat little trick on https://www.edureka.co/community/7489/what-the-correct-way-add-external-jars-intellij-idea-project
                    // Otherwise I was going to create dozens of Dialog classes for no reason!!!
                    JOptionPane.showMessageDialog(null, "Please fill in all fields!");
                }
                else {
                    // This is my first real foray in to the world of OpenCSV, and it's clumsy.
                    // This leans HEAVILY on this particular article: https://www.geeksforgeeks.org/writing-a-csv-file-in-java-using-opencsv/
                    // and features more copy-pasting than it really should. Being pressed for time, I am opting
                    // for modifications on copy-pasted solutions rather than trying to parse a deep understanding
                    // at the moment.
                    UserAcc user = new UserAcc(userNameInput.getText(), passwordInput.getText(), fullNameInput.getText(), yesAdmin.isSelected());

                    File file = new File("./userDB.csv");

                    try {

                        // create CSVWriter object filewriter object as parameter
                        File database = new File("./userDB.csv");
                        String csv = "userDB.csv";
                        CSVWriter writer = new CSVWriter(new FileWriter(csv, true));

                        // adding header to csv
                        // This isn't entirely necessary to the proper functioning of the program
                        // I've decided to grey it out until I can figure out how to do this
                        // later. What I am trying to do is get this to only write the header
                        // once, upon file creation. I do not want headers for every new
                        // user created.

                        //if (database.equals()) {
                        //    String[] header = { "Username", "Password", "Full Name", "Admin" };
                        //    writer.writeNext(header);
                        //}

                        // add data to csv
                        String admin = String.valueOf(user.isAdmin());
                        String[] data = { user.getUserName(), user.getPassword(), user.getFullName(), admin};
                        writer.writeNext(data);

                        // closing writer connection
                        writer.close();

                        JOptionPane.showMessageDialog(null, "User Successfully Added!");
                        dispose();

                    }
                    catch (IOException f) {
                        // TODO Auto-generated catch block
                        f.printStackTrace();
                    }
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        // The following listeners just allow the Yes/No Radio buttons
        // to be mutually exclusive. (they aren't both allowed to be selected)
        yesAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                noAdmin.setSelected(false);
            }
        });
        noAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                yesAdmin.setSelected(false);
            }
        });
    }
}
