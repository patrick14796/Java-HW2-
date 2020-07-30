/** 
 * @author Patrick Luggasi 319266177
 * @author Ivan Borinseco 317366102
 * 
 * AirAnimal class Inheritates Animal
 * 
 * @param wingspan - the Wing-Span of the air animal 
 * Creation of an Air-Animal type  
 */

package Animals;

import Mobility.Point;



public abstract class AirAnimal extends Animal{
	private double wingspan;
	
	public AirAnimal(){
		super();
		this.wingspan=1;
	}
	
	public AirAnimal(String name, int gend, double weight, double speed, Point p,double wingspan) {
		super(name, gend, weight, speed, new Point(0,100));
		if(wingspan<=0) {
			throw new RuntimeException("Wingspan cant be negative!");
		}
		else this.wingspan=wingspan;
	}
	
	public double get_wingspan() {
		return this.wingspan;
	}
	
	public boolean set_wingspan(double wing) {
		if(wing>0) {
			this.wingspan= wing;
			return true;
		}
		return false;
	}
	
	public String toString(){
        return " Is A Air-Animal \n" + super.toString()
       + "\n           Wingspan: " + get_wingspan();
	}

	
	public boolean equals(Object other){
        boolean answer=false;
        if(other instanceof AirAnimal)
        {
		answer=super.equals(other)&&(this.wingspan==((AirAnimal)other).get_wingspan());
		};
        return answer;
    }
}

