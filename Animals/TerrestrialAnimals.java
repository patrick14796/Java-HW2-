/**
 * @author Patrick Luggasi 319266177
 * @author Ivan Borinseco 317366102
 * 
 * TerrestrialAnimals class Inheritates Animal
 * 
 * @param NumberOfLegs   receive the Numbers of legs  of the TerrestrialAnimals
 * Creation of an Terrestrial-Animals types 
 * 
 */
package Animals;


import Mobility.Point;


public abstract class TerrestrialAnimals extends Animal {
	private int noLegs;
	public TerrestrialAnimals(){
		super();
		this.noLegs=0;
	}
	public TerrestrialAnimals(String name,int gend, double weight, double speed, Point p,int noLegs) {
		super(name, gend, weight, speed, p);
		if (noLegs<0 || noLegs>4)
		{
			throw new RuntimeException("Incorrect number  of Legs!");
		}
		this.noLegs=noLegs;
	}

	public boolean setNumberOfLegs(int x){
		if (noLegs<0 || noLegs>4)
		{
			return false;
		}
		else{
			this.noLegs=x;
			return true;
		}
	}
	public int get_noLegs() {
		return this.noLegs;
	}

	public String toString(){
        return "Is A TerrestrialAnimal \n" + super.toString()
        + "\n           Numbers of Legs: " + get_noLegs();
	}

	public boolean equals(Object other){
        boolean answer=false;
        if(other instanceof TerrestrialAnimals)
        {
		answer=super.equals(other)&&(this.noLegs==((TerrestrialAnimals)other).get_noLegs());
		};
        return answer;
    }
}
