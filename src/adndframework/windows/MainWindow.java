package adndframework.windows;

import adndframework.globals.GlobalConstants;
import adndframework.globals.GlobalFileList;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 * This is a panel that displays the main window from which all other
 * utilities of the program are launched.
 * 
 * @author Darin Beaudreau
 */
public class MainWindow extends javax.swing.JPanel implements java.awt.event.ActionListener {
    private adndframework.framework.Framework framework;
    private java.awt.image.BufferedImage backgroundImage = null;
    
    public MainWindow(adndframework.framework.Framework framework) {
        this.framework = framework;
        this.backgroundImage = this.framework.loadImage(GlobalFileList.MAIN_WINDOW_BACKGROUND);
        
        // The menu bar containing all the different menus.
        javax.swing.JMenuBar menuBar = new javax.swing.JMenuBar();
        
        {
            // Begin menu creation.
            JMenu characterMenu = new JMenu("Characters");
            characterMenu.setMnemonic(KeyEvent.VK_C);
            characterMenu.getAccessibleContext().setAccessibleDescription("Options for adding, editing, and removing characters.");

            JMenu tablesMenu = new JMenu("Tables");
            tablesMenu.setMnemonic(KeyEvent.VK_T);
            tablesMenu.getAccessibleContext().setAccessibleDescription("Tables containing game information for quick look-up.");
            
            JMenu helpMenu = new JMenu("Help");
            helpMenu.setMnemonic(KeyEvent.VK_H);
            helpMenu.getAccessibleContext().setAccessibleDescription("Contains information about this program.");
            // End menu creation.
            
            // Begin menu item creation.
            JMenuItem addCharacterMenuItem = new JMenuItem("Add Character");
            addCharacterMenuItem.getAccessibleContext().setAccessibleDescription("Add a new character to your character roster.");
            addCharacterMenuItem.addActionListener(this);
            characterMenu.add(addCharacterMenuItem);
            
            JMenuItem editCharacterMenuItem = new JMenuItem("Edit Character");
            editCharacterMenuItem.getAccessibleContext().setAccessibleDescription("Edit a character in your character roster.");
            editCharacterMenuItem.addActionListener(this);
            characterMenu.add(editCharacterMenuItem);
            
            JMenuItem removeCharacterMenuItem = new JMenuItem("Remove Character");
            removeCharacterMenuItem.getAccessibleContext().setAccessibleDescription("Remove a character in your character roster.");
            removeCharacterMenuItem.addActionListener(this);
            characterMenu.add(removeCharacterMenuItem);
            
            JMenuItem attributeTablesMenuItem = new JMenuItem("Attribute Tables");
            attributeTablesMenuItem.getAccessibleContext().setAccessibleDescription("Tables containing information about attribute values.");
            attributeTablesMenuItem.addActionListener(this);
            tablesMenu.add(attributeTablesMenuItem);
            
            JMenuItem raceTablesMenuItem = new JMenuItem("Race Tables");
            raceTablesMenuItem.getAccessibleContext().setAccessibleDescription("Tables containing information about player races.");
            raceTablesMenuItem.addActionListener(this);
            tablesMenu.add(raceTablesMenuItem);
            
            JMenuItem classTablesMenuItem = new JMenuItem("Class Tables");
            classTablesMenuItem.getAccessibleContext().setAccessibleDescription("Tables containing information about player classes.");
            classTablesMenuItem.addActionListener(this);
            tablesMenu.add(classTablesMenuItem);
            
            JMenuItem weaponTablesMenuItem = new JMenuItem("Equipment Tables");
            weaponTablesMenuItem.getAccessibleContext().setAccessibleDescription("Tables containing information about equipment, including weapons.");
            weaponTablesMenuItem.addActionListener(this);
            tablesMenu.add(weaponTablesMenuItem);
            
            JMenuItem spellTablesMenuItem = new JMenuItem("Spell Tables");
            spellTablesMenuItem.getAccessibleContext().setAccessibleDescription("Tables containing information about spells in the game.");
            spellTablesMenuItem.addActionListener(this);
            tablesMenu.add(spellTablesMenuItem);
            
            JMenuItem miscTablesMenuItem = new JMenuItem("Miscellaneous Tables");
            miscTablesMenuItem.getAccessibleContext().setAccessibleDescription("Tables containing miscellaneous information that don't belong in the other categories.");
            miscTablesMenuItem.addActionListener(this);
            tablesMenu.add(miscTablesMenuItem);
            
            JMenuItem aboutMenuItem = new JMenuItem("About");
            aboutMenuItem.getAccessibleContext().setAccessibleDescription("General information about this program.");
            aboutMenuItem.addActionListener(this);
            helpMenu.add(aboutMenuItem);
            // End menu item creation.
            
            // Add the menus to the menu bar.
            menuBar.add(characterMenu);
            menuBar.add(tablesMenu);
            menuBar.add(helpMenu);
            
            this.setLayout(new java.awt.BorderLayout());
            this.add(menuBar, java.awt.BorderLayout.NORTH);
        }
        
        setPreferredSize(new java.awt.Dimension(800, 600));
        setFocusable(true);
        requestFocus();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if("Add Character".equals(e.getActionCommand())) {
            // Handle creating the add character window.
            javax.swing.JOptionPane.showMessageDialog(this, "Add Character");
        } else if("Edit Character".equals(e.getActionCommand())) {
            // Handle creating the edit character window.
            javax.swing.JOptionPane.showMessageDialog(this, "Edit Character");
        } else if("Remove Character".equals(e.getActionCommand())) {
            // Handle creating the remove character window.
            javax.swing.JOptionPane.showMessageDialog(this, "Remove Character");
        } else if("Attribute Tables".equals(e.getActionCommand())) {
            // Handle creating the attribute tables window.
            String [][] listNames = {{"Strength Table I", GlobalFileList.ATT_STR_TBL_1},{"Strength Table II", GlobalFileList.ATT_STR_TBL_2},
                                     {"Intelligence Table I", GlobalFileList.ATT_INT_TBL_1}, {"Intelligence Table II", GlobalFileList.ATT_INT_TBL_2},
                                     {"Wisdom Table I", GlobalFileList.ATT_WIS_TBL_1}, {"Wisdom Table II", GlobalFileList.ATT_WIS_TBL_2},
                                     {"Dexterity Table I", GlobalFileList.ATT_DEX_TBL_1}, {"Dexterity Table II", GlobalFileList.ATT_DEX_TBL_2},
                                     {"Constitution Table", GlobalFileList.ATT_CON_TBL},
                                     {"Charisma Table", GlobalFileList.ATT_CHA_TBL}};
            createWindow("Attribute Tables", GlobalFileList.ATT_STR_TBL_1, listNames);
        } else if("Race Tables".equals(e.getActionCommand())) {
            // Handle creating the race tables window.
            String [][] listNames = {{"Race Table I", GlobalFileList.RACE_TBL_1},
                                     {"Race Table II", GlobalFileList.RACE_TBL_2},
                                     {"Race Table III", GlobalFileList.RACE_TBL_3}};
            createWindow("Race Tables", GlobalFileList.RACE_TBL_1, listNames);
        } else if("Class Tables".equals(e.getActionCommand())) {
            // Handle creating the class tables window.
            String [][] listNames = {{"Class Table I", GlobalFileList.CLASS_TBL_1}, {"Class Table II", GlobalFileList.CLASS_TBL_2},
                                     {"Cleric Table I", GlobalFileList.CLERIC_TBL_1}, {"Cleric Table II", GlobalFileList.CLERIC_TBL_2},
                                     {"Druid Table I", GlobalFileList.DRUID_TBL_1}, {"Druid Table II", GlobalFileList.DRUID_TBL_2},
                                     {"Fighter Table", GlobalFileList.FIGHTER_TBL},
                                     {"Paladin Table I", GlobalFileList.PALADIN_TBL_1}, {"Paladin Table II", GlobalFileList.PALADIN_TBL_2},
                                     {"Ranger Table I", GlobalFileList.RANGER_TBL_1}, {"Ranger Table II", GlobalFileList.RANGER_TBL_2},
                                     {"Fighters\', Paladins\' & Rangers\' Attacks Per Melee Round Table", GlobalFileList.FIGHTER_MELEE_TBL},
                                     {"Magic-User Table I", GlobalFileList.MAGIC_USER_TBL_1}, {"Magic-User Table II", GlobalFileList.MAGIC_USER_TBL_2},
                                     {"Illusionist Table I", GlobalFileList.ILLUSIONIST_TBL_1}, {"Illusionist Table II", GlobalFileList.ILLUSIONIST_TBL_2},
                                     {"Thieves Table I", GlobalFileList.THIEF_TBL_1}, {"Thief Function Table", GlobalFileList.THIEF_TBL_2}, {"Thieves Racial Bonus Table", GlobalFileList.THIEF_TBL_3},
                                     {"Assassins Table", GlobalFileList.ASSASSIN_TBL_1}, {"Minimum Fees for Assassination", GlobalFileList.ASSASSIN_TBL_2},
                                     {"Monk Table I", GlobalFileList.MONK_TBL_1}, {"Monk Table II", GlobalFileList.MONK_TBL_2}};
            createWindow("Class Tables", GlobalFileList.CLASS_TBL_1, listNames);
        } else if("Equipment Tables".equals(e.getActionCommand())) {
            // Handle creating the weapon tables window.
            String [][] listNames = {{"Equipment Table I: Armor", GlobalFileList.EQUIP_TBL_1}, {"Equipment Table II: Arms", GlobalFileList.EQUIP_TBL_2},
                                     {"Equipment Table III: Clothing", GlobalFileList.EQUIP_TBL_3}, {"Equipment Table IV: Herbs", GlobalFileList.EQUIP_TBL_4},
                                     {"Equipment Table V: Livestock", GlobalFileList.EQUIP_TBL_5}, {"Equipment Table VI: Miscellaneous Equipment & Items", GlobalFileList.EQUIP_TBL_6},
                                     {"Equipment Table VII: Provisions", GlobalFileList.EQUIP_TBL_7}, {"Equipment Table VIII: Religious Items", GlobalFileList.EQUIP_TBL_8},
                                     {"Equipment Table IX: Tack and Harness", GlobalFileList.EQUIP_TBL_9}, {"Equipment Table X: Transport", GlobalFileList.EQUIP_TBL_10},
                                     {"Weapon Table I: Weapon Proficiency Table", GlobalFileList.WEAPON_TBL_1}, {"Weapon Table Two: Weight and Damage by Weapon Type", GlobalFileList.WEAPON_TBL_2},
                                     {"Weapon Table III: Weapon Types, General Data, and \"To Hit\" Adjustments (Melee)", GlobalFileList.WEAPON_TBL_3}, {"Weapon Table IV: Weapon Types, General Data, and \"To Hit\" Adjustments (Ranged)", GlobalFileList.WEAPON_TBL_4}};
            createWindow("Equipment Tables", GlobalFileList.EQUIP_TBL_1, listNames);
        } else if("Spell Tables".equals(e.getActionCommand())) {
            // Handle creating the spell tables window.
            String [][] listNames = {{"Cleric Spells I", GlobalFileList.CLERIC_SPL_TBL_1}, {"Cleric Spells II", GlobalFileList.CLERIC_SPL_TBL_2},
                                     {"Druid Spells I", GlobalFileList.DRUID_SPL_TBL_1}, {"Druid Spells II", GlobalFileList.DRUID_SPL_TBL_2},
                                     {"Magic-User Spells I", GlobalFileList.MAGIC_USER_SPL_TBL_1}, {"Magic-User Spells II", GlobalFileList.MAGIC_USER_SPL_TBL_2},
                                     {"Illusionist Spells I", GlobalFileList.ILLUSIONIST_SPL_TBL_1}, {"Illusionist Spells II", GlobalFileList.ILLUSIONIST_SPL_TBL_2}};
            createWindow("Spell Tables", GlobalFileList.CLERIC_SPL_TBL_1, listNames);
        } else if("Miscellaneous Tables".equals(e.getActionCommand())) {
            // Handle creating the miscellaneous tables window.
            javax.swing.JOptionPane.showMessageDialog(this, "Miscellaneous Tables will go here.", "Miscellaneous Tables", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        } else if("About".equals(e.getActionCommand())) {
            // Handle creating the About window.
            javax.swing.JOptionPane.showMessageDialog(this, 
                                                      GlobalConstants.ABOUT_MESSAGE, 
                                                      "About AD&D Enhanced", 
                                                      javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(backgroundImage, 0, 0, null);
    }
    
    private void createWindow(String title, String filename, String [][] listNames) {
        javax.swing.JFrame frame = new javax.swing.JFrame(title);
        InformationTableWindow window = new InformationTableWindow(this.framework, filename, listNames);
        frame.add(window);
        frame.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(this);
        frame.pack();
        frame.setVisible(true);
    }
}
