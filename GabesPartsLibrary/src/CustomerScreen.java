import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CustomerScreen extends JFrame {


    private JPanel customerScreen;
    private JPanel leftPanel;
    private JList partsList;
    DefaultListModel<Part> model;
    private JComboBox engineSelector;
    DefaultComboBoxModel<Engine> engModel;
    private JSplitPane labelPanel;
    private JComboBox assySelector;
    DefaultComboBoxModel<Assembly> assyModel;
    private JPanel rightPanel;
    private JPanel assemblyDiagram;
    private JLabel assemblyDiagramPic;

    public CustomerScreen(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(customerScreen);
        this.pack();

        // The drop-down list code
        // I suspect works mostly like the list does
        // Since it is just a list, but drop down.
        // Edit: My suspicion was correct
        engModel = new DefaultComboBoxModel<>();
        engineSelector.setModel(engModel);

        assyModel = new DefaultComboBoxModel<>();
        assySelector.setModel(assyModel);

        model = new DefaultListModel<>();
        partsList.setModel(model);

        // The following populates the Engines drop down menu
        File f = new File("./src/Engines");
        String[] paths;
        paths = f.list();
        for(String path:paths) {
            try {
                FileReader filereader = new FileReader("./src/Engines/" + path + "/" + path + ".csv");
                CSVReader csvReader = new CSVReader(filereader);
                String[] nextRecord;
                while ((nextRecord = csvReader.readNext()) != null) {

                    engModel.addElement(new Engine(nextRecord[0], nextRecord[1], new ArrayList<>(), "./src/Engines/" + path));
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (CsvValidationException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        // When you double click a list object, a new window should open
        partsList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                // String name, String partNum, String desc, float price, int quantity
                String partName = model.get(partsList.getSelectedIndex()).getName();
                String partNum = model.get(partsList.getSelectedIndex()).getPartNum();
                String desc = model.get(partsList.getSelectedIndex()).getDesc();
                float price = model.get(partsList.getSelectedIndex()).getPrice();
                int quantity = model.get(partsList.getSelectedIndex()).getQuantity();
                String picPath = model.get(partsList.getSelectedIndex()).getPicPath();

                // The following if-then statement makes it so that
                // list items require double clicking to open the dialog
                if (e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1) {
                    // JOptionPane.showMessageDialog(null, "You clicked the thing.");
                    JDialog partsInfo = new PartsInfoWindow(partName, partNum, desc, price, quantity, picPath);
                    partsInfo.setSize(1000, 500);
                    partsInfo.setVisible(true);

                }

            }
        });

        // When a new Engine is selected
        // It should update the assemblies dropdown
        engineSelector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // First, clear the model
                assyModel.removeAllElements();

                // Then the Assemblies are populated
                File assysF = new File(engModel.getElementAt(engineSelector.getSelectedIndex()).getEnginePath() + "/Assemblies");
                String[] assyPaths;
                assyPaths = assysF.list();
                for (String path : assyPaths) {
                    if (!path.endsWith(".csv")) continue; // Only look at CSV files!
                    try {
                        String csv = engModel.getElementAt(engineSelector.getSelectedIndex()).getEnginePath() + "/Assemblies/" + path;
                        FileReader filereader = new FileReader(csv);
                        CSVReader csvReader = new CSVReader(filereader);
                        String[] nextRecord;
                        while ((nextRecord = csvReader.readNext()) != null) {
                            Assembly assy = new Assembly();
                            assy.setName(nextRecord[0]);
                            assy.setImageFilePath(nextRecord[1]);
                            assy.setAssyPath(nextRecord[2]);
                            assy.setPartsPath(nextRecord[3]);
                            assyModel.addElement(assy);
                        }
                    } catch (FileNotFoundException f) {
                        f.printStackTrace();
                    } catch (CsvValidationException f) {
                        f.printStackTrace();
                    } catch (IOException f) {
                        f.printStackTrace();
                    }
                }
            }
        });

        // When the Assembly selector is used it should
        // update the diagram picture and the list below it
        // as well that features all the parts
        assySelector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear the picture off the screen
                // to prevent confusion

                try {
                    ImageIcon i = new ImageIcon(assyModel.getElementAt(assySelector.getSelectedIndex()).getImageFilePath());
                    assemblyDiagramPic.setIcon(i);
                    assemblyDiagramPic.setSize(1000, 1000);
                } catch (NullPointerException n) {
                    n.printStackTrace();
                }

                // List Code
                // Largely followed this tutorial:
                // https://youtu.be/KOI1WbkKUpQ
                model.removeAllElements();
                try {
                    String asyPartsPath = assyModel.getElementAt(assySelector.getSelectedIndex()).getPartsPath();
                    File listf = new File(asyPartsPath);
                    String[] partsPaths;
                    partsPaths = listf.list();
                    for (String path : partsPaths) {
                        // Make a new part
                        // Read in the data from the CSV
                        // Add that part to the list model
                        String partCsv = asyPartsPath + "/" + path;
                        FileReader filereader = new FileReader(partCsv);
                        CSVReader csvReader = new CSVReader(filereader);
                        String[] nextRecord;
                        while ((nextRecord = csvReader.readNext()) != null) {
                            Part part = new Part();
                            part.setName(nextRecord[0]);
                            part.setPartNum(nextRecord[1]);
                            part.setDesc(nextRecord[2]);
                            part.setPrice(Float.parseFloat(nextRecord[3]));
                            part.setQuantity(Integer.parseInt(nextRecord[4]));
                            part.setPicPath(nextRecord[5]);
                            part.setDiagLoc(Integer.parseInt(nextRecord[6]));
                            part.setCsvPath(nextRecord[7]);
                            model.addElement(part);
                        }
                        // If you don't close the readers, you won't be able to delete any files
                        csvReader.close();
                        filereader.close();
                    }
                }
                catch (NullPointerException n) {
                    n.printStackTrace();
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                } catch (CsvValidationException csvValidationException) {
                    csvValidationException.printStackTrace();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });






    }

}
