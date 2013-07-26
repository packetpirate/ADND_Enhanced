package adndframework.character;

import adndframework.character.components.AbilityScores;
import adndframework.character.components.CharacterDefenses;
import adndframework.character.components.CharacterDescription;
import adndframework.character.components.CharacterExperience;
import adndframework.character.components.CharacterRace;
import adndframework.framework.Framework;

/**
 * Used to store and represent information from the player character's
 * information sheet.
 * 
 * @author Darin Beaudreau
 */
public class CharacterSheet {
    // Basic Character Information
    private CharacterDescription description = null;
    private CharacterRace characterRace = null;
    private String characterClass = "";
    private CharacterExperience characterExperience = null;
    
    // Ability Score Information
    private AbilityScores scores = null;
    
    // Defense Information
    private CharacterDefenses defenses = null;
    
    public CharacterSheet() {
        this.characterRace = new CharacterRace("Human", new int[]{0, 0, 0, 0, 0, 0});
        this.characterExperience = new CharacterExperience(1, 0, 2000);
        
        this.scores = new AbilityScores(Framework.rollAbilityScores());
        this.scores.modifyValues(this.characterRace.getScoreMods());
        
        this.defenses = new CharacterDefenses();
    }
    
    // Getters and Setters
    public CharacterDescription getCharacterDescription() { return this.description; }
    public CharacterRace getCharacterRace() { return this.characterRace; }
    public void setCharacterRace(String raceName, int [] mods) { this.characterRace = new CharacterRace(raceName, mods); }
    public String getCharacterClass() { return this.characterClass; }
    public void setCharacterClass(String cclass) { this.characterClass = cclass; }
    public CharacterExperience getCharacterExperience() { return this.characterExperience; }
    public AbilityScores getAbilityScores() { return this.scores; }
    public CharacterDefenses getCharacterDefenses() { return this.defenses; }
}
