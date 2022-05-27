import javax.swing.*;

public class MainPageGUI extends JFrame{
    private JButton addButton;
    private JButton searchButton;
    private JTextField textField1;
    private JButton filterButton;
    private JComboBox sortBy;
    private JTable table1;
    private JPanel mainPanel;
    private JMenuBar bar;

    public MainPageGUI(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        setSize(500, 500);
        setVisible(true);
        bar = new JMenuBar();
        setJMenuBar(bar);
        JMenu fileMenu = new JMenu("File");
        bar.add(fileMenu);
        JMenuItem about = new JMenuItem("about");
        JMenuItem export = new JMenuItem("export");
        JMenuItem importer = new JMenuItem("import");
        fileMenu.add(about);
        fileMenu.add(export);
        fileMenu.add(importer);
    }
}
