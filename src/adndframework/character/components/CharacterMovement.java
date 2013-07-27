package adndframework.character.components;

/**
 * Used to store the character's base movement rate and to calculate
 * other movement rates.
 * 
 * @author Darin Beaudreau
 */
public class CharacterMovement {
    private int baseRate;
    
    public CharacterMovement(int baseRate) {
        this.baseRate = baseRate;
    }
    
    public int getBaseRate() { return this.baseRate; }
    public int getHeavyRate() { return (this.baseRate / 4); }
    public int getLoadRate() { return (this.baseRate / 2); }
    public int getMaxRate() { return (this.baseRate / 4); }
    public int getRunRate() { return (this.baseRate * 10); }
    public int getNormalRate() { return (this.baseRate * 5); }
    public int getCrawlRate() { return (this.baseRate / 2); }
    public int getHiddenRate() { return (this.baseRate * (2/3)); }
}
