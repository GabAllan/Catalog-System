import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateNewEngine extends JFrame {
    private JPanel NewEngineWindow;
    private JButton okButton;
    private JButton cancelButton;
    private JTextField brand;
    private JLabel brandLabel;
    private JTextField modelNum;
    private JLabel modelNumLabel;

    public CreateNewEngine(String title) {
        super(title);

        this.setContentPane(NewEngineWindow);
        this.pack();

        // Ok Button
        // This should commit the changes
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Capture the information in the boxes
                // and create a new folder bearing the
                // Brand name and model number in the format
                // ex: Honda_GX390K1ED6
                // As well as creating a CSV file
                // within detailing the specific object information

                dispose();
            }

        });

        // Cancel Button
        // It does exactly what you think.
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
