package adndframework.items;

/**
 * Base class used to represent an item in AD&D.
 * 
 * @author Darin Beaudreau
 */
public class Item {
    private String name = "";
    private String location = "";
    private String size = "";
    
    public Item(String name) {
        this.name = name;
        this.location = "";
        this.size = "";
    }
    
    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }
    public String getLocation() { return this.location; }
    public void setLocation(String location) { this.location = location; }
    public String getSize() { return this.size; }
    public void setSize(String size) { this.size = size; }
}
