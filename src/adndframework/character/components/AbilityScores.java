package adndframework.character.components;

/**
 * Used to store, retrieve, and modify ability score values.
 * 
 * @author Darin Beaudreau
 */
public class AbilityScores {
    // Constants
    public static final int STRENGTH = 0;
    public static final int INTELLIGENCE = 1;
    public static final int WISDOM = 2;
    public static final int DEXTERITY = 3;
    public static final int CONSTITUTION = 4;
    public static final int CHARISMA = 5;
    
    private int [] scores = null;
    public int getScore(int score) { return this.scores[score]; }
    public void setScore(int score, int value) { this.scores[score] = value; }
    
    public AbilityScores(int [] scores) {
        if(scores != null) this.scores = scores;
    }
    
    public void modifyValues(int [] mods) {
        if(mods.length == 6) {
            for(int i = 0; i < mods.length; i++) {
                this.scores[i] += mods[i];
            }
        } else {
            System.out.println("Invalid number of ability score modifiers specified. Aborting...");
        }
    }
}
