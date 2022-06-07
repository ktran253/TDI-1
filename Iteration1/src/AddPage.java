import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * A GUI pops up that allows the user to create an item with a name, description,
 * typing label, and room location.
 * @author Kevin Tran ktran253@uw.edu
 * 5/20/2022
 */
public class AddPage extends JFrame {
    private JPanel mainPanel;
    private JLabel nameLabel;
    private JTextField nameText;
    private JComboBox roomSelect;
    private JComboBox typeSelect;
    private JLabel roomLabel;
    private JLabel typeLabel;
    private JLabel descriptionLabel;
    private JTextArea textArea;
    private JButton clearButton;
    private JButton confirmButton;
    private JButton addRoomButton;
    private JButton addTypeButton;
    private ThingList tList;
    private ArrayList<String> typeList;
    private ArrayList<String> roomList;
    private Thing item;
    private MainPageGUI myMainP;
    //Constructor
    /**
     * Constructs the addPage GUI.
     */
    public AddPage(ThingList theTList, MainPageGUI theMainP) {
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        setContentPane(mainPanel);
        setTitle("Add Page");
        setVisible(true);
        setSize(600, 650);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        this.tList = theTList;
        this.myMainP = theMainP;
        typeList = tList.getTypes();
        typeSelect.setModel(new DefaultComboBoxModel(typeList.toArray()));

        roomList = tList.getRooms();
        roomSelect.setModel(new DefaultComboBoxModel(roomList.toArray()));

        // Button Actions
        addRoomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addRoom roomGUI  = new addRoom();
                JButton roomButton = roomGUI.getButtonOK();
                roomButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        roomList.add(roomGUI.getText());
                        roomSelect.addItem(roomGUI.getText());
                        pack();
                        roomGUI.dispose();
                    }
                });
            }
        });
        addTypeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addType typeGUI = new addType();
                JButton roomButton = typeGUI.getButtonOK();
                roomButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        typeList.add(typeGUI.getText());
                        typeSelect.addItem(typeGUI.getText());
                        pack();
                        typeGUI.dispose();
                    }
                });
            }
        });
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                item = new Thing(nameText.getText(),(String) roomSelect.getSelectedItem(),
                        (String)typeSelect.getSelectedItem(),textArea.getText());
                tList.add(item);
                tList.printToJson();
                myMainP.build();
                dispose();
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameText.setText("");
                textArea.setText("");
            }
        });
    }
    //Methods

}
