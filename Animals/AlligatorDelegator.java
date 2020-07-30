/** 
 * @author Patrick Luggasi 319266177
 * @author Ivan Borinseco 317366102
 * 
 * AirAnimal class Inheritates Animal
 * 

 */

package Animals;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Mobility.Point;

public class AlligatorDelegator extends TerrestrialAnimals {

    Alligator ali;

    public AlligatorDelegator() {
        super();
		ali=new Alligator();
	}

	public AlligatorDelegator(String name, int gend, double weight, double speed, Point p, double diveDept,String AreaOfLiving,int noLegs) {
		super(name, gend, weight, speed, p, noLegs);
		super.setSound("Roar");
        ali=new Alligator(name,gend,weight,speed,p, diveDept,AreaOfLiving);
        

	}

	public String get_AreaOfLiving() {
		return ali.get_AreaOfLiving();
	}

	public String toString() {
		return "Alligator : \n" + ali.toString() +  "\n         Number of Legs"+this.get_noLegs();
	}

	public boolean equals(Object other) {
		boolean answer = false;
		if (other instanceof AlligatorDelegator) {
			answer = super.equals(other) && (ali.get_AreaOfLiving() == ((AlligatorDelegator) other).get_AreaOfLiving());
		}
		return answer;
	}

	public void speedUp(int sp) {
		ali.speedUp(sp);
	}

    public void loadImages(String nm) {
        try { super.img1 = ImageIO.read(new File("graphics/alligator"+nm+"E.png")); }
		catch (IOException e) { System.out.println("Cannot load image"); }
		try { super.img2 = ImageIO.read(new File("graphics/alligator"+nm+"W.png")); }
        catch (IOException e) { System.out.println("Cannot load image"); }
    }

	public String get_Category() {
		return "Water";
	}

	public String get_Type() {
		return "Alligator";
	}



	public boolean eat(int energy) {
		if(maxEnergy+energy<10){
			maxEnergy=maxEnergy+energy;
			return true;
		}
		return false;
	}

    
}