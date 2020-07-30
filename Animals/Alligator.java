/**
 * @author Patrick Luggasi 319266177
 * @author Ivan Borinseco 317366102
 * 
 * Alligator class Inheritates WaterAnimal
 * 
 * @param AreaOfLiving - The Area living of the Water-Animal
 * Creation of an Water-Animal type Alligator 
 */

package Animals;

import Mobility.Point;

public class Alligator extends WaterAnimal implements IReptile {
	private String AreaOfLiving;

	public Alligator() {
		super();
		super.setSound("Roar");
		this.AreaOfLiving = "Sea";
	}

	public Alligator(String name, int gend, double weight, double speed, Point p, double diveDept,String AreaOfLiving) {
		super(name, gend, weight, speed, p, diveDept);
		super.setSound("Roar");
		this.AreaOfLiving = AreaOfLiving;
	}

	public String get_AreaOfLiving() {
		return this.AreaOfLiving;
	}

	public String toString() {
		return "Alligator : \n" + super.toString() + "\n           Area Of Living: " + get_AreaOfLiving();
	}

	public boolean equals(Object other) {
		boolean answer = false;
		if (other instanceof Alligator) {
			answer = super.equals(other) && (this.AreaOfLiving == ((Alligator) other).get_AreaOfLiving());
		}
		;
		return answer;
	}

	public void speedUp(int sp) {
		super.set_speed(sp);
	}


	public void loadImages(String nm) {}
	




	public boolean eat(int energy) {
		if(maxEnergy+energy<10){
			maxEnergy=maxEnergy+energy;
			return true;
		}
		return false;
	}

	public String get_Category() {
		return "Water";
	}

	public String get_Type() {
		return "Alligator";
	}
}