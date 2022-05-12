import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginPage extends JFrame{
    private JTextField nameText;
    private JTextField emailText;
    private JButton clearButton;
    private JButton confirmButton;
    private JPanel mainPanel;
    private JLabel nameLabel;
    private JLabel emailLabel;
    public LoginPage() {
        setContentPane(mainPanel);
        setTitle("Household Handbook");
        setVisible(true);
        setSize(400, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameText.setText("");
                emailText.setText("");
            }
        });
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AboutPage about = new AboutPage(nameText.getText(), emailText.getText());
            }
        });
    }
    public static void main(String[] theArgs) {
        LoginPage login = new LoginPage();
    }
}

