import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPage extends JFrame {
    private JPanel mainPanel;
    private JLabel nameLabel;
    private JTextField nameText;
    private JComboBox roomSelect;
    private JComboBox comboBox1;
    private JLabel roomLabel;
    private JLabel typeLabel;
    private JLabel descriptionLabel;
    private JTextArea textArea;
    private JButton clearButton;
    private JButton confirmButton;
    private JButton addFileButton;
    private JButton addRoomButton;
    private JButton addTypeButton;

    public AddPage() {
        setContentPane(mainPanel);
        setTitle("Add Page");
        setVisible(true);
        setSize(600, 650);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        addRoomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] theArgs) {
        AddPage GUI = new AddPage();
    }
}
