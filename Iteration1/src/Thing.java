import java.util.Comparator;

public class Thing{
    private String name, room, type;
    private String description;
    public Thing(String name, String room, String type, String description){
        this.name = name;
        this.room = room;
        this.type = type;
        this.description = description;
    }
    public String getName(){return name;}

    public String getRoom() {return room;}

    public String getType() {return type;}

    public String getDescription() {return description;}

    public void setName(String name) {this.name = name;}

    public void setRoom(String room) {this.room = room;}

    public void setType(String type) {this.type = type;}

    public void setDescription(String description) {this.description = description;}

    public String[] getObject(){return new String[] {name, room, type}; }
}
class SortByName implements Comparator<Thing> {
    public int compare(Thing one, Thing two){
        return one.getName().compareTo(two.getName());
    }
}
class SortByRoom implements Comparator<Thing> {
    public int compare(Thing one, Thing two){
        return one.getRoom().compareTo(two.getRoom());
    }
}
class SortByType implements Comparator<Thing> {
    public int compare(Thing one, Thing two){
        return one.getType().compareTo(two.getType());
    }
}
