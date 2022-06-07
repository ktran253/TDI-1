import javax.swing.*;
import java.awt.event.*;

/**
 * Adds a new room created by the user to a list.
 * @author Kevin Tran ktran253@uw.edu
 * 5/25/2022
 */
public class addRoom extends JDialog {
    private JPanel mainPanel;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel addText;
    private JTextField roomText;
    // Constructor
    /**
     * Constructs a GUI that allows the user to add a new room to a list of rooms.
     */
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
    /**
     * Gives the functions of the button for the addType GUI.
     * @return ButtonOK
     */
    public JButton getButtonOK() {
        return buttonOK;
    }
    /**
     * get the text written by the user.
     * @return textfield
     */
    public String getText() {
        return roomText.getText();
    }

}
