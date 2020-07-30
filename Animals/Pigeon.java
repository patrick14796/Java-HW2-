/**
 * @author Ivan Borinseco 317366102
 * @author Patrick Luggasi 319266177
 * 
 * Pigeon class extends air animals
 * 
 * @param family   the family that the pigeon is connected
 * creation of an animal type pigeon
 * 
 * 
 */

package Animals;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Mobility.Point;

public class Pigeon extends AirAnimal {
    private String family;

    public Pigeon() {
        super();
        super.setSound("Arr-rar-rar-rar-raah");
        this.family = "Alone";
    }

    public Pigeon(String name, int gend, double weight, double speed, Point p, double wingspan, String family) {
        super(name, gend, weight, speed, p, wingspan);
        super.setSound("Arr-rar-rar-rar-raah");
        this.family = family;
    }

    public String getPigeonFamily() {
        return this.family;
    }

    public String toString() {
        return "Pigeon: \n" + super.toString() + "\n           Family: " + getPigeonFamily();
    }

    public boolean equals(Object other) {
        boolean answer = false;
        if (other instanceof Pigeon) {
            answer = super.equals(other) && (this.family == ((Pigeon) other).getPigeonFamily());
        }
        ;
        return answer;
    }


    public void loadImages(String nm) {
        try { super.img1 = ImageIO.read(new File("graphics/pigeon.png")); }
		catch (IOException e) { System.out.println("Cannot load image"); }

    }

	public String get_Category() {
		return "Air";
	}

	public String get_Type() {
		return "Pigeon";
	}
    
   


    public boolean eat(int energy) {
        if(maxEnergy+energy<10){
			maxEnergy=maxEnergy+energy;
			return true;
		}
		return false;
    }
}