import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminScreen extends JFrame{
    private JPanel assemblyDiagram;
    private JPanel adminScreen;
    private JButton addEditButton;
    private JButton delete;
    private JButton edit;
    private JList list1;
    private JLabel engineLabel;


    public AdminScreen(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(adminScreen);
        this.pack();



        // The following should open a new window that will allow the
        // addition of new engines and sub-assemblies as well
        // as editing current ones
        addEditButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

}
