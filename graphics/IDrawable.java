/** 
 * @author Patrick Luggasi 319266177
 * @author Ivan Borisenco 317366102
 * 
 * AirAnimal class Inheritates Animal
 * 

 */

package graphics;
import java.awt.Graphics;

public interface IDrawable {
    public final static String PICTURE_PATH = "…";
    public void loadImages(String nm);
    public void drawObject (Graphics g);    
}