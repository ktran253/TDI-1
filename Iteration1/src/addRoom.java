import javax.swing.*;
import java.awt.event.*;

/**
 * addRoom
 */
public class addRoom extends JDialog {
    private JPanel mainPanel;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel addText;
    private JTextField roomText;

    public addRoom() {
        setVisible(true);
        setContentPane(mainPanel);
        setModal(true);
        setSize(200,150);
        getRootPane().setDefaultButton(buttonOK);

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        mainPanel.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public JButton getButtonOK() {
        return buttonOK;
    }

    public String getText() {
        return roomText.getText();
    }

    public static void main(String[] args) {
        addRoom dialog = new addRoom();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
