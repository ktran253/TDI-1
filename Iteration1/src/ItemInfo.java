import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ItemInfo extends JFrame{
    private JTextField ItemNameTitle;
    private JButton deleteButton;
    private JButton editButton;
    private JLabel ItemLocationLabel;
    private JLabel ItemTypeLabel;
    private JTextArea textArea1;
    private JButton saveButton;
    private JButton cancelButton;
    private String oldName, oldDescription;

    public ItemInfo(Thing thing) {
        ItemNameTitle.setText(thing.getName());
        ItemTypeLabel.setText(thing.getType());
        ItemLocationLabel.setText(thing.getRoom());
        setSize(400,400);
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
                saveButton.setVisible(false);
                cancelButton.setVisible(false);
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveButton.setVisible(false);
                cancelButton.setVisible(false);
                ItemNameTitle.setText(oldName);
                textArea1.setText(oldDescription);
            }
        });
    }


}
