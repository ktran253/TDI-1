import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Zac Moriarty
 */
public class ThingList {
    String name, password, email;
    ArrayList<String> rooms, types;
    ArrayList<Thing> things;
    public ThingList(String name, String password, String email, ArrayList<String> rooms, ArrayList<String> types) {
        this.password = password;
        things = new ArrayList<>();
        this.email = email;
        this.name = name;
        this.rooms = rooms;
        this.types = types;
    }
    public ArrayList<String> getRooms(){return rooms;}
    public ArrayList<String> getTypes(){return types;}
    public void add(Thing a){things.add(a);}
    public void addRoom(String room){rooms.add(room);}
    public void addType(String type){types.add(type);}
    public void sortByName(){
        Collections.sort(things, new SortByName());
    }
    public void sortByRoom(){
        Collections.sort(things, new SortByRoom());
    }
    public void sortByType(){
        Collections.sort(things, new SortByType());
    }
    public ArrayList<Thing> getThings(){return things;}
    public String[][] get2DArray(){
        String[][] list = new String[things.size()][3];
        for(int i = 0; i < things.size(); i++){
            list[i][0] = things.get(i).getName();
            list[i][1] = things.get(i).getRoom();
            list[i][2] = things.get(i).getType();
        }
        return list;
    }
    public Thing getThing(String Name){
        for (Thing t:
             things) {
            if(t.getName().equals(Name)){
                return t;
            }
        }
        return null;
    }
    public void printToJson(){
        JSONObject out = new JSONObject();
        out.put("password", password);
        JSONArray roomList = new JSONArray();
        for(int i = 0; i < rooms.size(); i ++){
            roomList.add(rooms.get(i));
        }
        out.put("rooms", roomList);
        JSONArray typeList = new JSONArray();
        for(int i = 0; i < types.size(); i ++){
            typeList.add(types.get(i));
        }
        out.put("types", typeList);
        JSONArray objectList = new JSONArray();
        for(int i = 0; i < things.size(); i++){
            JSONObject thing = new JSONObject();
            Thing it = things.get(i);
            thing.put("name", it.getName());
            thing.put("room", it.getRoom());
            thing.put("type", it.getType());
            thing.put("description", it.getDescription());
            objectList.add(thing);
        }
        out.put("objects", objectList);
        out.put("email", email);
        try(FileWriter file = new FileWriter(name + ".json")){
            file.write(out.toString());
            file.flush();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public void removeThing(Thing t){things.remove(t);}
}