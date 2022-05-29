
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.util.ArrayList;

public class MainPageGUI extends JFrame{
    private ThingList things;
    private String name, password;
    private ArrayList<String> types, rooms;
    private DefaultTableModel tableModel;
    private JButton addButton;
    private JButton searchButton;
    private JTextField textField1;
    private JComboBox sortBy;
    private JTable table1;
    private JPanel mainPanel;
    private JMenuBar bar;

    /**
     * The main page of the program. Shows a table of the users items that can be accessed to get descriptions.
     *
     * @param name The name of the user profile accessing the program.
     * @param password the users' password. used to make it easier to store later
     * @param file  a file reader with the users json file holding all of their items
     */
    public MainPageGUI(String name, String password, FileReader file){
        this.name = name;
        this.password = password;
        setTitle("Home helper");
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
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Name");
        tableModel.addColumn("Room");
        tableModel.addColumn("Type");
        table1.setModel(tableModel);
        parseJson(name + ".json");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddPage page = new AddPage();
            }
        });
    }

    /*
    * a private method to go through the users json file and create a list of the things they have in it,
    * as well as a list of their rooms, and types.
     */
    private void parseJson(String fileName){
        try(FileReader file = new FileReader(fileName)){
            JSONParser parser = new JSONParser();
            JSONObject main = (JSONObject) parser.parse(file);
            JSONArray roomsList = (JSONArray) main.get("rooms");
            for(int i = 0; i < roomsList.size(); i++){
                rooms.add(roomsList.get(i).toString());
            }
            JSONArray typeList = (JSONArray) main.get("types");
            for(int i = 0; i < typeList.size(); i++){
                types.add(typeList.get(i).toString());
            }
            JSONArray objectList = (JSONArray) main.get("objects");
            for(int i =0; i < objectList.size(); i++){
                JSONObject temp = (JSONObject) objectList.get(i);
                String name = temp.get("name").toString();
                String room = temp.get("room").toString();
                String type = temp.get("type").toString();
                String description = temp.get("description").toString();
                objectList.add(new Thing(name, room, type, description));
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    /*
    * used to build the main table. can be recalled to add new things to table.
     */
    private void buildTable(ThingList list, TableModel model){
        for(Thing t: list.getThings()){

        }
    }
}
