package adndframework.framework;

import javax.imageio.ImageIO;

/**
 * This class handles most of the program's events.
 * 
 * @author Darin Beaudreau
 */
public class Framework {
    public adndframework.windows.MainWindow mainWindow;
    
    public Framework() {
        this.mainWindow = new adndframework.windows.MainWindow(this);
    }
    
    public java.awt.image.BufferedImage loadImage(String filename) {
        java.io.File f = new java.io.File(getClass().getResource(filename).getFile());
        if(f != null) {
            try {
                java.awt.image.BufferedImage image = ImageIO.read(f);
                return image;
            } catch(java.io.IOException io) {
                System.out.println("Error reading file: " + f.getName());
            }
        }
        return null;
    }
}
