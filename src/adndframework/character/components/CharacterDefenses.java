package adndframework.character.components;

/**
 * Used to store information about the character's defenses.
 * 
 * @author Darin Beaudreau
 */
public class CharacterDefenses {
    // Constants
    public static final int PARALYZE_POISON = 0;
    public static final int PETRIFY_POLYMORPH = 1;
    public static final int ROD_STAFF_WAND = 2;
    public static final int BREATH_WEAPON = 3;
    public static final int SPELLS = 4;
    
    // Defenses
    private int armorClass;
    private int [] saves = null;
    
    public CharacterDefenses() {
        this(10, new int[]{20, 20, 20, 20, 20});
    }
    
    public CharacterDefenses(int ac, int [] saves) {
        this.armorClass = ac;
        this.saves = saves;
    }
    
    public int getArmorClass() { return this.armorClass; }
    public void setArmorClass(int ac) { this.armorClass = ac; }
    public int getSave(int save) { return this.saves[save]; }
    public void setSave(int save, int value) { this.saves[save] = value; }
}
