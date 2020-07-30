/**
 * @author Patrick Luggasi 319266177
 * @author Ivan Borinseco 317366102
 * 
 * Whale class Inheritates WaterAnimal
 * 
 * @param FoodType   the food of the whale 
 * Creation of an animal type Whale 
 * 
 */

package Animals;


import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Mobility.Point;

public class Whale extends WaterAnimal {
	private String foodType;
	public Whale() {
		super();
		super.setSound("Splash");
		this.foodType = "Sea weed";
	}

	public Whale(String name, int gend, double weight, double speed, Point p, double diveDept, String foodType) {
		super(name, gend, weight, speed, p, diveDept);
		super.setSound("Splash");
		this.foodType = foodType;
	}

	public String get_foodType() {
		return this.foodType;
	}

	public String toString() {
		return "Whale: \n" + super.toString() + "\n           Food Type: " + get_foodType();
	}

	public boolean equals(Object other) {
		boolean answer = false;
		if (other instanceof Whale) {
			answer = super.equals(other) && (this.foodType == ((Whale) other).get_foodType());
		}
		;
		return answer;
	}
	


	/*picking image for whale  */
	public void loadImages(String nm) {
		// Loads an image for whale
		try { super.img1 = ImageIO.read(new File("graphics/whale"+nm+"E.png")); }
		catch (IOException e) { System.out.println("Cannot load image"); }
		try { super.img2 = ImageIO.read(new File("graphics/whale"+nm+"W.png")); }
		catch (IOException e) { System.out.println("Cannot load image"); }
	}


	public String get_Category() {
		return "Water";
	}

	public String get_Type() {
		return "Whale";
	}

	public boolean eat(int energy) {
		if(maxEnergy+energy<10){
			maxEnergy=maxEnergy+energy;
			return true;
		}
		return false;
	}
}