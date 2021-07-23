import com.opencsv.CSVReader;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;

public class LoginScreen extends JFrame {
    private JPasswordField passwordInput;
    private JPanel loginPanel;
    private JButton loginButton;
    private JTextField usernameInput;
    private JButton createNewAccountButton;

    public LoginScreen(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(loginPanel);
        this.pack();

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // This should grab the text from username and password field
                // If it is empty, send a dialog screen up
                // and check it against a list of known usernames and passwords
                // If the username does not exist, it should issue an error stating as such
                // If the password is wrong, it should instead state that the password or user is wrong
                // For CSV Reading, I am using OpenCSV module, and help from Geeks4Geeks
                // This specific component referenced this page heavily: https://www.geeksforgeeks.org/reading-csv-file-java-using-opencsv/
                if (usernameInput.getText().isEmpty() || passwordInput.getPassword().length == 0) {
                    JOptionPane.showMessageDialog(null, "Please Enter Username and Password");
                }
                else {
                    try {

                        // Create an object of filereader
                        // class with CSV file as a parameter.
                        FileReader filereader = new FileReader("./userDB.csv");

                        // create csvReader object passing
                        // file reader as a parameter
                        CSVReader csvReader = new CSVReader(filereader);
                        String[] nextRecord;
                        boolean loginFlag = false;
                        boolean userExists = false;
                        // we are going to read data line by line
                        while ((nextRecord = csvReader.readNext()) != null) {
                            for (int i = 0; i < nextRecord.length; i++) {
                                // getText() method is deprecated for Swing password field UI
                                // but unfortunately the proper method of handling passwords
                                // is something a bit difficult to implement at my current level of skill.
                                // For this reason, alongside the fact that the project is not a demonstration
                                // of proper security practices, I am opting for the deprecated method to
                                // get the plaintext password, especially in light of the fact that the passwords
                                // are also stored in plaintext!
                                if (nextRecord[0].equals(usernameInput.getText()) && nextRecord[1].equals(passwordInput.getText())) {
                                    loginFlag = true;
                                    break;
                                }
                                else if (nextRecord[0].equals(usernameInput.getText())) {
                                    userExists = true;
                                }
                            }
                        }
                        if (loginFlag) {
                            JFrame screen = new AdminScreen("Gabe's Small Engine Parts Emporium");
                            screen.setExtendedState(JFrame.MAXIMIZED_BOTH);
                            screen.setVisible(true);
                        }
                        else if (userExists){
                            JOptionPane.showMessageDialog(null, "Incorrect password. Please try again.");
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "User not found! Please register a new account.");
                        }

                    }
                    catch (Exception f) {
                        f.printStackTrace();
                    }
                }

            }
        });

        // This opens the create new account window
        createNewAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame newAccount = new CreateNewAccount("Create New Account");
                newAccount.setVisible(true);
            }
        });


    }

}
