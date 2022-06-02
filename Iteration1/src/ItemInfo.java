import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Bohdan Ivchenko
 */
public class ItemInfo extends JFrame{
    private JTextField ItemNameTitle;
    private JButton deleteButton;
    private JButton editButton;
    private JLabel ItemLocationLabel;
    private JLabel ItemTypeLabel;
    private JTextArea textArea1;
    private JButton saveButton;
    private JButton cancelButton;
    private JPanel pane;
    private String oldName, oldDescription;

    public ItemInfo(Thing thing, ThingList list, MainPageGUI main) {
        setContentPane(pane);
        ItemNameTitle.setText(thing.getName());
        ItemTypeLabel.setText(thing.getType());
        ItemLocationLabel.setText(thing.getRoom());
        textArea1.setText(thing.getDescription());
        setSize(400,300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        textArea1.setEditable(false);
        ItemNameTitle.setEditable(false);
        saveButton.setVisible(false);
        cancelButton.setVisible(false);
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    ItemNameTitle.setEditable(true);
                    textArea1.setEditable(true);
                    saveButton.setVisible(true);
                    cancelButton.setVisible(true);
                    oldName = ItemNameTitle.getText();
                    oldDescription = textArea1.getText();
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                thing.setName(ItemNameTitle.getText());
                thing.setDescription(textArea1.getText());
                main.build();
                list.printToJson();
                saveButton.setVisible(false);
                cancelButton.setVisible(false);
                ItemNameTitle.setEditable(false);
                textArea1.setEditable(false);
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveButton.setVisible(false);
                cancelButton.setVisible(false);
                ItemNameTitle.setText(oldName);
                textArea1.setText(oldDescription);
                ItemNameTitle.setEditable(false);
                textArea1.setEditable(false);
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int input = JOptionPane.showConfirmDialog(ItemInfo.this, "Are you sure you want to delete "+thing.getName()+" ?","Confirm Deletiond",JOptionPane.YES_NO_OPTION);

                if( input == 0){
                    list.removeThing(thing);
                    list.printToJson();
                    main.build();
                    dispose();
                }
            }
        });
    }


}
