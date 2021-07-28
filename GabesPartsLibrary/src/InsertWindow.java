import com.opencsv.CSVWriter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
    private JTextField selectedEngine;
    private JTextField selectedAssembly;
    private JTextField diagLoc;
    private JTextField quantity;

    public InsertWindow(String title, Engine eng, Assembly asy) {
        super(title);

        this.setContentPane(addNewPart);
        this.pack();

        selectedEngine.setText(eng.getBrandName() + " " + eng.getModelNum());
        selectedAssembly.setText(asy.getName());

        // The OK Button should first commit all the
        // entered data in to a CSV file
        // before closing the window
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create a new part and populate the members
                Part part = new Part();
                part.setName(partName.getText());
                part.setPartNum(partNum.getText());
                part.setDesc(desc.getText());
                part.setPrice(Float.parseFloat(price.getText()));
                part.setQuantity(Integer.parseInt(quantity.getText()));
                part.setPicPath(filePath.getText());
                part.setDiagLoc(Integer.parseInt(diagLoc.getText()));

                // Create a new part CSV in the proper folder
                String csv = asy.getPartsPath() + "/" + part.getName() + ".csv";
                part.setCsvPath(csv);
                File partCsv = new File(csv);

                //Next we can go ahead and write to the assembly CSV
                try {
                    CSVWriter writer = new CSVWriter(new FileWriter(partCsv, true));
                    // Schema: {partName, partNum, partDesc, partPrice, partQuant, picPath, diagLoc, csvPath}
                    String[] data =
                                    {part.getName(),
                                    part.getPartNum(),
                                    part.getDesc(),
                                    String.valueOf(part.getPrice()),
                                    String.valueOf(part.getQuantity()),
                                    part.getPicPath(),
                                    String.valueOf(part.getDiagLoc()),
                                    part.getCsvPath()};
                    writer.writeNext(data);
                    writer.close();
                    JOptionPane.showMessageDialog(null, "Part successfully added!");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

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
                filePath.setText(fc.getSelectedFile().getPath().replace("\\", "\\\\"));

            }
        });

        // This will open the create new engine box
        createNewEngineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame addNewEngine = new CreateNewEngine("Add New Engine...");
                addNewEngine.setVisible(true);
            }
        });
    }

    // This is an optional constructor to be used for the edit window
    public InsertWindow(String title, Engine eng, Assembly asy, Part part) {
        super(title);

        this.setContentPane(addNewPart);
        this.pack();

        // This is default and carried over
        // from the other constructor.
        // there is no reason to change this.
        selectedEngine.setText(eng.getBrandName() + " " + eng.getModelNum());
        selectedAssembly.setText(asy.getName());

        // The following pre-populate the field according
        // to the part that is selected
        partName.setText(part.getName());
        partNum.setText(part.getPartNum());
        desc.setText(part.getDesc());
        price.setText(String.valueOf(part.getPrice()));
        quantity.setText(String.valueOf(part.getQuantity()));
        diagLoc.setText(String.valueOf(part.getDiagLoc()));
        filePath.setText(part.getPicPath());


        // The OK Button should first delete the old
        // csv file and then replace it with a new one
        // with the new information entered in to it
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create a new part and populate the members
                Part part1 = new Part();
                part1.setName(partName.getText());
                part1.setPartNum(partNum.getText());
                part1.setDesc(desc.getText());
                part1.setPrice(Float.parseFloat(price.getText()));
                part1.setQuantity(Integer.parseInt(quantity.getText()));
                part1.setPicPath(filePath.getText());
                part1.setDiagLoc(Integer.parseInt(diagLoc.getText()));


                // Delete the old CSV File
                File myObj = new File(part.getCsvPath());
                if (!myObj.delete()) {
                    JOptionPane.showMessageDialog(null, "Failed to delete the file, Unable to create new part!");
                    dispose();
                }

                // Create a new part CSV in the proper folder
                String csv = asy.getPartsPath() + "/" + part1.getName() + ".csv";
                part1.setCsvPath(csv);
                File partCsv = new File(csv);

                //Next we can go ahead and write to the assembly CSV
                try {
                    CSVWriter writer = new CSVWriter(new FileWriter(partCsv, true));
                    // Schema: {partName, partNum, partDesc, partPrice, partQuant, picPath, diagLoc, csvPath}
                    String[] data =
                            {part1.getName(),
                                    part1.getPartNum(),
                                    part1.getDesc(),
                                    String.valueOf(part1.getPrice()),
                                    String.valueOf(part1.getQuantity()),
                                    part1.getPicPath(),
                                    String.valueOf(part1.getDiagLoc()),
                                    part1.getCsvPath()};
                    writer.writeNext(data);
                    writer.close();
                    JOptionPane.showMessageDialog(null, "Part successfully added!");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

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
                filePath.setText(fc.getSelectedFile().getPath().replace("\\", "\\\\"));

            }
        });

        // This will open the create new engine box
        createNewEngineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame addNewEngine = new CreateNewEngine("Add New Engine...");
                addNewEngine.setVisible(true);
            }
        });

    }
}
