import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private ThingList list;
    private ArrayList<String> typeList;
    private ArrayList <String> roomList;
    private Thing item;
    //Constructor
    /**
     * Constructs the addPage GUI.
     */
    public AddPage() {
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        setContentPane(mainPanel);
        setTitle("Add Page");
        setVisible(true);
        setSize(600, 650);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        typeList = new ArrayList<>(100);
        addTypeBox("Note");
        addTypeBox("Appliance");
        roomList = new ArrayList<>(100);
        addRoomBox("Bedroom");

        // Button Actions
        addRoomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addRoom roomGUI  = new addRoom();
                JButton roomButton = roomGUI.getButtonOK();
                roomButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        addRoomBox(roomGUI.getText());
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

                        addTypeBox(typeGUI.getText());
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
            }
        });
    }
    //Methods

    private void addRoomBox(String room) {
        if (room == "" || room == null)  {
            throw new IllegalArgumentException("please insert a room");
        }
        roomList.add(room);
        roomSelect.addItem(room);
    }
    private void addTypeBox(String type) {
        if (type == "" || type == null)  {
            throw new IllegalArgumentException("please insert a type");
        }
        typeList.add(type);
        typeSelect.addItem(type);
    }


    public static void main(String[] theArgs) {
        AddPage GUI = new AddPage();
    }
}
