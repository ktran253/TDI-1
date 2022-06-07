import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RegisterPage extends JDialog{
    private JTextField txtName;
    private JTextField txtEmail;
    private JPasswordField pfpassword;
    private JPasswordField pfConfirmpassword;
    private JButton btnregister;
    private JPanel RegisterPanel;
    private JButton btnok;

    public RegisterPage(JFrame parent) {
        super(parent);
        setTitle("Create a new account");
        setContentPane(RegisterPanel);
        setMinimumSize(new Dimension(450, 530));
        setModal(true);
        setLocationRelativeTo(parent);

        btnregister.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    registerUser();

                }
            });
        btnok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginPage page = new LoginPage();
            }
        });
       setVisible(true);
        }

    private void registerUser() {
        String name = txtName.getText();
        String email = txtEmail.getText();
        String password = String.valueOf(pfpassword.getPassword());
        String confirmPassword = String.valueOf(pfConfirmpassword.getPassword());

        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please enter all fields",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this,
                    "Confirm Password does not match",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
            return;

        }
        else{
            try {
                FileWriter out = new FileWriter(name + ".json");
                JSONObject file = new JSONObject();
                file.put("password", password);
                file.put("email", email);
                JSONArray rooms = new JSONArray();
                JSONArray types = new JSONArray();
                JSONArray objects = new JSONArray();
                rooms.add("bedroom");
                rooms.add("kitchen");
                types.add("note");
                types.add("appliance");
                file.put("rooms", rooms);
                file.put("types", types);
                file.put("objects", objects);
                out.write(file.toString());
                out.flush();
                MainPageGUI page = new MainPageGUI(name, password, email);
                dispose();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        }
    }
