package adndframework.character.components;

/**
 * Used to keep track of the character's experience and level.
 * 
 * @author Darin Beaudreau
 */
public class CharacterExperience {
    private int characterLevel;
    private int characterExp;
    private int nextLevel;
    
    public CharacterExperience() {
        this(1, 0, 1000);
    }
    
    public CharacterExperience(int level, int experience, int nextLevel) {
        this.characterLevel = level;
        this.characterExp = experience;
        this.nextLevel = nextLevel;
    }
    
    public int getLevel() { return this.characterLevel; }
    public void setLevel(int level) { this.characterLevel = level; }
    public int getExperience() { return this.characterExp; }
    public void setExperience(int exp) { this.characterExp = exp; }
    public int getNextLevel() { return this.nextLevel; }
    public void setNextLevel(int next) { this.nextLevel = next; }
}
