package adndframework.character.components;

/**
 * Used to store the character's basic information, such as name and
 * information about the character's background.
 * 
 * @author Darin Beaudreau
 */
public class CharacterDescription {
    private java.util.HashMap<String, String> stringValues = null;
    private java.util.HashMap<String, Integer> intValues = null;
    
    public CharacterDescription(String name, String sex, int age) {
        this(name, "", "", "", "", "", "", sex, age, "", "", "", "", "", 0, "", "", "", "", "");
    }
    
    public CharacterDescription(String name, String family, String raceClan, String homeland,
                                String liegePatron, String religion, String alignment, String sex, int age,
                                String socialClass, String status, String height, String weight,
                                String birthRank, int siblings, String hair, String eyes,
                                String appearance, String personality, String history) {
        this.stringValues = new java.util.HashMap<String, String>();
        this.intValues = new java.util.HashMap<String, Integer>();
        this.stringValues.put("Name", name);
        this.stringValues.put("Family", family);
        this.stringValues.put("Race/Clan", raceClan);
        this.stringValues.put("Homeland", homeland);
        this.stringValues.put("Liege/Patron", liegePatron);
        this.stringValues.put("Religion", religion);
        this.stringValues.put("Alignment", alignment);
        this.stringValues.put("Sex", sex);
        this.intValues.put("Age", age);
        this.stringValues.put("Social Class", socialClass);
        this.stringValues.put("Status", status);
        this.stringValues.put("Height", height);
        this.stringValues.put("Weight", weight);
        this.stringValues.put("Birth Rank", birthRank);
        this.intValues.put("Siblings", siblings);
        this.stringValues.put("Hair", hair);
        this.stringValues.put("Eyes", eyes);
        this.stringValues.put("Appearance", appearance);
        this.stringValues.put("Personality", personality);
        this.stringValues.put("History", history);
    }
    
    public Object get(String item) {
        if(item.equals("Age") || item.equals("Siblings")) return this.intValues.get(item);
        else return this.stringValues.get(item);
    }
    
    public void set(String item, int value) {
        this.intValues.put(item, value);
    }
    
    public void set(String item, String value) {
        this.stringValues.put(item, value);
    }
}
