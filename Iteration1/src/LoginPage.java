import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;


public class LoginPage extends JFrame{
    private JTextField nameText;
    private JTextField passwordText;
    private JButton clearButton;
    private JButton confirmButton;
    private JPanel mainPanel;
    private JLabel nameLabel;
    private JLabel emailLabel;
    private JButton registerButton;

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
                passwordText.setText("");
            }
        });
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try(FileReader file = new FileReader(nameText.getText() + ".json")){
                    JSONParser parser = new JSONParser();
                    JSONObject main = (JSONObject) parser.parse(file);
                    String password = main.get("password").toString();
                    if(password.equals(passwordText.getText())){
                        dispose();
                        MainPageGUI page = new MainPageGUI(nameText.getText().toLowerCase(Locale.ROOT), passwordText.getText(), file);
                    }
                    else{
                        JOptionPane.showMessageDialog(LoginPage.this,
                                "Password does not match.\nPlease try again.",
                                "Try again",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
                catch (FileNotFoundException l){
                    RegistrationSender sender = new RegistrationSender(LoginPage.this);
                }
                catch (Exception l){
                    System.out.println(l);
                }
            }
        });

    }

}

