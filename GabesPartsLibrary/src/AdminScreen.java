import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class AdminScreen extends JFrame  {
    private JPanel assemblyDiagram;
    private JPanel adminScreen;
    private JButton insertButton;
    private JButton deleteButton;
    private JButton editButton;
    // List Things
    private JList partsList;
    DefaultListModel<Part> model;
    // Drop-down Things
    private JComboBox engineSelector;
    DefaultComboBoxModel<Engine> engModel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JSplitPane labelPanel;
    private JComboBox assySelector;
    private JButton createNewEngineButton;
    private JButton createNewAssyButton;
    DefaultComboBoxModel<Assembly> assyModel;


    public AdminScreen(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(adminScreen);
        this.pack();

        // The drop-down list code
        // I suspect works mostly like the list does
        // Since it is just a list, but drop down
        engModel = new DefaultComboBoxModel<>();
        engineSelector.setModel(engModel);

        // This should add the models based on a CSV full of stuff??
        // First walk through the engines folder
        // go in to each engine folder and
        // look for the csv file bearing the same name as the folder
        // and pull the first element to populate the dropdown
        // File Tree walking, this video was super useful: https://www.youtube.com/watch?v=aimd2tn0hLM
//        Path dir = Paths.get("./src/Engines");
//        EngineFileVisitor visitor = new EngineFileVisitor();
//        try {
//            Files.walkFileTree(dir, visitor);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        

        // The following was just testing code, I am leaving it in for
        // future troubleshooting should the need arise
        Engine gx390 = new Engine("Honda", "GX390", new ArrayList<Assembly>());
        engModel.addElement(gx390);


        Assembly airCleaner = new Assembly("Air Cleaner", new ArrayList<Part>());
        gx390.assys.add(airCleaner);
        assyModel = new DefaultComboBoxModel(gx390.assys.toArray());
        assySelector.setModel(assyModel);


        // List Code
        // Largely followed this tutorial:
        // https://youtu.be/KOI1WbkKUpQ
        model = new DefaultListModel<>();
        partsList.setModel(model);
        // This should add the models based on a CSV full of stuff??
        model.addElement(new Part(1,"A Part", "123", "A New Part", 3, 50, "./src/partPics/a_Part.jpg"));



        // The following should open a new window that will allow the
        // addition of new engines and sub-assemblies as well
        // as editing current ones
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame addPart = new InsertWindow("Add New Part");
                addPart.setVisible(true);
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
                    partsInfo.setVisible(true);

                }

            }
        });

        // Opens the create new engine dialog
        createNewEngineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame addNewEngine = new CreateNewEngine("Add New Engine...");
                addNewEngine.setVisible(true);
            }
        });


    }

}
