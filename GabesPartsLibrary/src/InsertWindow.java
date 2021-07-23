import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InsertWindow extends JFrame {
    private JButton OKButton;
    private JButton cancelButton;
    private JButton createNewEngineButton;
    private JButton chooseFileButton;
    private JTextField filePath;
    private JTextField price;
    private JTextField desc;
    private JTextField partNum;
    private JLabel partNameLabel;
    private JLabel partNumLabel;
    private JLabel descLabel;
    private JLabel priceLabel;
    private JLabel picPathLabel;
    private JPanel addNewPart;
    private JTextField partName;

    public InsertWindow(String title) {
        super(title);

        this.setContentPane(addNewPart);
        this.pack();

        // The OK Button should first commit all the
        // entered data in to a CSV file
        // before closing the window
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        // The cancel button can just close the window
        // straight away without any issue.
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                dispose();
            }
        });

        // This should open a file chooser to pick a path
        chooseFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
                fc.showOpenDialog(addNewPart);
                filePath.setText(fc.getSelectedFile().getPath());

            }
        });
    }
}
