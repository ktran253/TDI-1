import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        }
        public static void main (String[]args){
            RegisterPage myForm = new RegisterPage(null);
        }

    }
