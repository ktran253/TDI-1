import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;

public class ThingList {
    String name;
    String[] rooms, types;
    ArrayList<Thing> things;
    public ThingList(String name, String[] rooms, String[] types) {
        things = new ArrayList<>();
        this.name = name;
        this.rooms = rooms;
        this.types = types;
    }
    public void add(Thing a){
        things.add(a);
    }
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
    public void printToJson(){
        JSONObject out = new JSONObject();
        out.put("name", name);
        JSONArray roomList = new JSONArray();
        for(int i = 0; i < rooms.length; i ++){
            roomList.put(rooms[i]);
        }
        out.put("rooms", roomList);
        JSONArray typeList = new JSONArray();
        for(int i = 0; i < types.length; i ++){
            typeList.put(types[i]);
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
            objectList.put(thing);
        }
        out.put("objects", objectList);
        try(FileWriter file = new FileWriter("TestObject.json")){
            file.write(out.toString());
            file.flush();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}