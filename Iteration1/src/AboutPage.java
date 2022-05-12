import javax.swing.*;
import java.io.File;
import java.util.Scanner;

public class AboutPage extends JFrame{
    private JPanel panel1;
    private JLabel version;
    private JTextArea Names;

    public AboutPage(String name, String eMail){
        setContentPane(panel1);
        setTitle("About");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Names.setText(eMail + "\n" + name + "\nCreators: \nZac Moriarty \nBohdan Ivchenko \n Kevin Tran");
        version.setText(Version.getVersion());
        setVisible(true);
    }
}
