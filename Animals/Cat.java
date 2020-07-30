/**
* @author Patrick Luggasi 319266177
 * @author Ivan Borinseco 317366102
 * 
 * Cat class Inheritates TerrestrialAnimals
 * 
 * @param Castrated -  boolean parameter(true-Castrated || false-Not Castrated)
 * Creation of an Terrestrial-Animal type Cat 
 */

package Animals;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Mobility.Point;

public class Cat extends TerrestrialAnimals {
	private boolean Castrated;

	public Cat() {
		super();
		super.setSound("Meow");
		this.Castrated = false;
	}

	public Cat(String name, int gend, double weight, double speed, Point p, int noLegs, boolean Castrated) {
		super(name, gend, weight, speed, p, noLegs);
		super.setSound("Meow");
		this.Castrated = Castrated;
	}

	public boolean get_Castrated() {
		return Castrated;
	}

	public String toString() {
		return "Cat: \n" + super.toString() + "\n           Castrated: " + this.get_Castrated();

	};

	public boolean equals(Object other) {
		boolean answer = false;
		if (other instanceof Cat) {
			answer = super.equals(other) && (this.Castrated == ((Cat) other).get_Castrated());
		}
		;
		return answer;
	}
	
	public void loadImages(String nm) {
		try { super.img1 = ImageIO.read(new File("graphics/cat"+nm+"E.png")); }
		catch (IOException e) { System.out.println("Cannot load image"); }
		try { super.img2 = ImageIO.read(new File("graphics/cat"+nm+"W.png")); }
        catch (IOException e) { System.out.println("Cannot load image"); }
        try { super.img3 = ImageIO.read(new File("graphics/cat"+nm+"N.png")); }
        catch (IOException e) { System.out.println("Cannot load image"); }
        try { super.img4 = ImageIO.read(new File("graphics/cat"+nm+"S.png")); }
		catch (IOException e) { System.out.println("Cannot load image"); }
	}


	public String get_Category() {
		return "Terrestrial";
	}


	public String get_Type() {
		return "Cat";
	}



	public boolean eat(int energy) {
		if(maxEnergy+energy<10){
			maxEnergy=maxEnergy+energy;
			return true;
		}
		return false;
	}
    }
