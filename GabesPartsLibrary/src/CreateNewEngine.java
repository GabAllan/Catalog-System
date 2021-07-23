import com.opencsv.CSVWriter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

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

                // If the dialogs are empty, do not allow exit
                if (brand.getText().isEmpty() || modelNum.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill out all boxes.");
                }
                else {
                    // create new engine object
                    Engine eng = new Engine(brand.getText(), modelNum.getText(), new ArrayList<Assembly>());

                    // Define the new folder name as well as the folder path
                    String folderName = eng.getBrandName() + "_" + eng.getModelNum();
                    String path = "./src/Engines/" + folderName;
                    String assyPath = path + "/Assemblies";
                    String assyCsvFile = assyPath + "/" + folderName + "_assys" + ".csv";


                    // Github helped here...
                    // https://stackoverflow.com/a/3634906
                    // this creates a new Engine folder, and if it already exists
                    // it alerts the user
                    File newDir = new File(path);
                    if (!newDir.exists()){
                        newDir.mkdirs();
                        // Next we create a blank assemblies folder within
                        File newDir1 = new File(assyPath);
                        newDir1.mkdirs();
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "That engine already exists!");
                    }

                    // Next we create a new CSV file
                    // This will contain the engine information
                    String csvFile = path + "/" + folderName + ".csv";
                    File file = new File(csvFile);


                    try {
                        CSVWriter writer = new CSVWriter(new FileWriter(csvFile, true));
                        // The last string is a path to the assys csv that will contain a
                        // list of the assemblies in the engine, which in turn will
                        // contain a list of file paths to the various
                        // assembly parts folders
                        String[] data = {eng.getBrandName(), eng.getModelNum(), assyCsvFile};
                        writer.writeNext(data);
                        writer.close();
                        JOptionPane.showMessageDialog(null, "Engine successfully added!");
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }

                    dispose();
                }
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
