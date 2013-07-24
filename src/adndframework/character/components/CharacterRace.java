package adndframework.character.components;

/**
 * Used to store information about the character race.
 * 
 * @author Darin Beaudreau
 */
public class CharacterRace {
    private String raceName = "";
    private int [] scoreMods = null;
    
    public CharacterRace(String name, int [] mods) {
        this.raceName = name;
        if(mods != null) this.scoreMods = mods;
        else this.scoreMods = new int[]{0, 0, 0, 0, 0, 0};
    }
    
    public String getRaceName() { return this.raceName; }
    public int getScoreMod(int score) { return this.scoreMods[score]; }
    public int [] getScoreMods() { return this.scoreMods; }
}
