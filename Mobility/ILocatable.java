/**
 * @author Patrick Luggasi 319266177
 * @author Ivan Borinseco 317366102
 * 
 * ILocatable interface
 * 
 * @method getLocation - getting the location of the object in term of Point
 * @method setLocation - set the location of the object with Point receive
 */

package Mobility;

public interface ILocatable {
    public Point getLocation();
    public boolean setLocation(Point p);
}