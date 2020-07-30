/** 
 * @author Patrick Luggasi 319266177
 * @author Ivan Borinseco 317366102
 * 
 * WaterAnimal class Inheritates Animal
 * 
 * @param Max_Dive   the Maximum Dive Depth of the water-Animal 
 * Creation of an Water-Animal type 
 * 
 */
package Animals;

import Mobility.Point;


public abstract class WaterAnimal extends Animal {
    static final int MAX_DIVE= (-800);
    //Dept is Z on Grapgh
    private double diveDept;

    public WaterAnimal(){
        super();
        this.diveDept=-5;
    }
    
    public WaterAnimal(String name,int gend,double weight,double speed,Point p,double diveDept){
            super(name, gend, weight, speed,new Point(50, 0));
            if(diveDept <-800 || diveDept >0){
                throw new RuntimeException("Wrong Dive Dept!!!!");
            }
            else{
                this.diveDept=diveDept;
            }

        }
    //Function to Dive On Z
    public void Dive(double d){
            double check= this.diveDept+d;
            if(check<-800 || check > 0){
                throw new RuntimeException("Cant dive above "+check);
            }
            else{
                this.diveDept+=d;
            }
        }


    public double get_diveDept(){
        return this.diveDept;
    }   

	public String toString(){
        return "Is A Water-Animal \n" + super.toString()
        + "\n           Dive Dept: " + get_diveDept();
    }

    public boolean equals(Object other){
        boolean answer=false;
        if(other instanceof WaterAnimal)
        {
		answer=super.equals(other)&&(this.diveDept==((WaterAnimal)other).get_diveDept());
		};
        return answer;
    }
}

