import com.opencsv.CSVWriter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CreateNewAssy extends JFrame {
    private JPanel CreateNewAssy;
    private JButton okButton;
    private JButton cancelButton;
    private JTextField assyName;
    private JTextField assyImage;
    private JButton chooseFileButton;
    private JLabel assyNameLabel;
    private JLabel assyDiagramaLabel;
    private JTextField currentEngine;
    private JLabel currentEngLabel;

    public CreateNewAssy(String title, Engine eng) {
        super(title);

        this.setContentPane(CreateNewAssy);
        this.pack();

        currentEngine.setText(eng.getBrandName() + " " + eng.getModelNum());


        // This will open the choose file dialog
        chooseFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
                fc.showOpenDialog(CreateNewAssy);
                assyImage.setText(fc.getSelectedFile().getPath());
            }
        });

        // OK Button
        // This will capture the information inputted
        // and commit them
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Assembly userNewAssy = new Assembly(assyName.getText(), new ArrayList<Part>());
                userNewAssy.setImageFilePath(assyImage.getText());
                eng.assys.add(userNewAssy);
                // Create a new assembly folder under the engines folder
                String csv =  eng.getBrandName() + "_" + eng.getModelNum() + "_assys" + ".csv";
                String assyFilePath = eng.getEnginePath() + "/Assemblies/" + csv;
                userNewAssy.setAssyPath(eng.getEnginePath() + "/Assemblies/" + csv);
                System.out.println(assyFilePath);
                File assyCsv = new File(assyFilePath);

                try {
                    CSVWriter writer = new CSVWriter(new FileWriter(assyCsv, true));
                    String[] data = {userNewAssy.getName(), userNewAssy.getImageFilePath()};
                    writer.writeNext(data);
                    writer.close();
                    JOptionPane.showMessageDialog(null, "Assembly successfully added!");

                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                dispose();
            }
        });

        // Cancel button
        // Does exactly what you think it does...
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
