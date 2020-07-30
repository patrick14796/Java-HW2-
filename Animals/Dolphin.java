/**
* @author Patrick Luggasi 319266177
* @author Ivan Borinseco 317366102
* 
* Dolphin class Inheritates Water Animal
* 
* @param Water Type -  the type of water the animal live in
* Creation of an water animal type Dolphin 
* 
*/

package Animals;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Mobility.Point;

public class Dolphin extends WaterAnimal {
	enum WaterType {
		Sea, Sweet
	};

	private WaterType wa;

	public Dolphin() {
		super();
		super.setSound("Click-click");
		this.wa = WaterType.Sea;
	}

	public Dolphin(String name, int gend, double weight, double speed, Point p, double diveDept, int w) {
		super(name, gend, weight, speed, p, diveDept);
		super.setSound("Click-click");
		set_WaterType(w);
	}

	public boolean set_WaterType(int x) {
		switch (x) {
			case 1:
				this.wa = WaterType.Sea;
				return true;

			case 2:
				this.wa = WaterType.Sweet;
			default:
				return false;
		}
	}

	public WaterType get_WaterType() {
		return this.wa;
	}

	public String toString() {
		return "Dolphin: \n" + super.toString() + "\n           Water Type: " + get_WaterType();
	}

	public boolean equals(Object other) {
		boolean answer = false;
		if (other instanceof Dolphin) {
			answer = super.equals(other) && (this.wa == ((Dolphin) other).get_WaterType());
		}
		;
		return answer;
	}

	
	public void loadImages(String nm) {
		try { super.img1 = ImageIO.read(new File("graphics/dolphin"+nm+"E.png")); }
		catch (IOException e) { System.out.println("Cannot load image"); }
		try { super.img2 = ImageIO.read(new File("graphics/dolphin"+nm+"W.png")); }
        catch (IOException e) { System.out.println("Cannot load image"); }
	}

	public String get_Category() {
		return "Water";
	}

	public String get_Type() {
		return "Dolphin";
	}




	public boolean eat(int energy) {
		if(maxEnergy+energy<10){
			maxEnergy=maxEnergy+energy;
			return true;
		}
		return false;
	}
}
