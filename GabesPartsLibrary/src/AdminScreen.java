import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminScreen extends JFrame  {
    private JPanel assemblyDiagram;
    private JPanel adminScreen;
    private JButton insertButton;
    private JButton deleteButton;
    private JButton editButton;
    private JList partsList;
    private JComboBox engineSelector;


    public AdminScreen(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(adminScreen);
        this.pack();


        // The following should open a new window that will allow the
        // addition of new engines and sub-assemblies as well
        // as editing current ones
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        // The following should first prompt an "Are you sure?" dialog
        // followed by deleting the currently selected item in the Jtree
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        // The following should open a dialog window similar
        // to the insert button, but with pre-populated fields
        // based on the selected object in the jTree. It will
        // allow the user to edit the existing data
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }

}
