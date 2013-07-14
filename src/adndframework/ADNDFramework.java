package adndframework;

import adndframework.globals.GlobalConstants;

/**
 * The purpose of this program is to create a framework with which
 * dungeon masters can more easily manage games of Advanced Dungeons & Dragons.
 * 
 * @author Darin Beaudreau
 */
public class ADNDFramework {
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }
        
        javax.swing.JFrame frame = new javax.swing.JFrame("AD&D Enhanced v" + GlobalConstants.VERSION);
        adndframework.framework.Framework framework = new adndframework.framework.Framework();
        frame.add(framework.mainWindow);
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }
}
