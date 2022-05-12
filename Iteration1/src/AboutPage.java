import javax.swing.*;
import java.io.File;
import java.util.Scanner;

public class AboutPage extends JFrame{
    private JPanel panel1;
    private JLabel version;
    private JLabel Names;

    public void AboutPage(String name, String eMail){
        setTitle("About");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Names.setText(eMail + "\n" + name + "\nCreators: \nZac Moriarty\n");
        version.setText("test");
        setVisible(true);
    }
}
