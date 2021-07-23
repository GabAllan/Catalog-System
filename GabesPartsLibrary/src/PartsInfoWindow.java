import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PartsInfoWindow extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JLabel partPicture;
    private JLabel nameLabel;
    private JLabel partNumLabel;
    private JLabel priceLabel;
    private JLabel qtyLabel;
    private JLabel descLabel;
    private JLabel partNum;
    private JLabel price;
    private JLabel quantity;
    private JLabel desc;
    private JLabel partNam;


    public PartsInfoWindow(String name, String partNum, String desc, float price, int quantity, String picPath) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);


        ImageIcon i = new ImageIcon(picPath);
        partNam.setText(name);
        this.partNum.setText(partNum);
        this.desc.setText(desc);
        this.price.setText(String.valueOf(price));
        this.quantity.setText(String.valueOf(quantity));
        partPicture.setIcon(i);
        partPicture.setSize(250, 250);


        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });
    }

    private void onOK() {
        dispose();
    }

//    public static void main(String[] args) {
//        PartsInfoWindow dialog = new PartsInfoWindow();
//        dialog.pack();
//        dialog.setVisible(true);
//        System.exit(0);
//    }
}
