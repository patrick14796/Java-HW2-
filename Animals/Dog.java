/** @author Patrick Luggasi 319266177
 * @author Ivan Borinseco 317366102
 * 
 * Dog class Inheritates TerrestrialAnimals
 * 
 * @param breed -  the breed type of the Dog
 * Creation of an Terrestrial-Animal type Dog 
 */

package Animals;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Mobility.Point;

public class Dog extends TerrestrialAnimals {
	private String breed;

	public Dog() {
		super();
		super.setSound("Woof Woof");
		this.breed = "BullDog";
	}

	public Dog(String name, int gend, double weight, double speed, Point p, int noLegs, String breed) {
		super(name, gend, weight, speed, p, noLegs);
		super.setSound("Woof Woof");
		this.breed = breed;
	}

	public String get_breed() {
		return this.breed;
	}

	public String toString() {
		return "Dog: \n" + super.toString() + "\n           Breed Type: " + get_breed();
	}

	public boolean equals(Object other) {
		boolean answer = false;
		if (other instanceof Dog) {
			answer = super.equals(other) && (this.breed == ((Dog) other).get_breed());
		}
		;
		return answer;
	}
	
	public void loadImages(String nm) {
		try { super.img1 = ImageIO.read(new File("graphics/dog"+nm+"E.png")); }
		catch (IOException e) { System.out.println("Cannot load image"); }
		try { super.img2 = ImageIO.read(new File("graphics/dog"+nm+"W.png")); }
        catch (IOException e) { System.out.println("Cannot load image"); }
        try { super.img3 = ImageIO.read(new File("graphics/dog"+nm+"N.png")); }
        catch (IOException e) { System.out.println("Cannot load image"); }
        try { super.img4 = ImageIO.read(new File("graphics/dog"+nm+"S.png")); }
		catch (IOException e) { System.out.println("Cannot load image"); }
    }

	public String get_Category() {
		return "Terrestrial";
	}

	public String get_Type() {
		return "Dog";
	}


	public boolean eat(int energy) {
		if(maxEnergy+energy<10){
			maxEnergy=maxEnergy+energy;
			return true;
		}
		return false;
	}
}
