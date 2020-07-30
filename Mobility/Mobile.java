 /** 
 * @author Patrick Luggasi 319266177
 * @author Ivan Borisenco 317366102
 * 
 * Mobile class implements ILocatable
 * 
 * @param location - the location In terms of ( x axis , y axis )
 * @param totalDistance - the total Distance the object move 
 */

package Mobility;

import java.lang.Math;

public abstract class Mobile implements ILocatable {
    private Point location;
    private double totalDistance;

    
    public Mobile(){
      this.location=new Point();
      this.totalDistance=0;
    }

    public Mobile(Point p) {
    	this.location=p;
    	this.totalDistance=0;
    }
    
    public void addTotalDistance(double d) {
    	this.totalDistance += d; 
    }
    
    public double calcDistance(Point p) {
		double d= Math.sqrt(Math.pow((location.get_x()-p.get_x()), 2) + Math.pow((location.get_y()-p.get_y()), 2));
    	return d;
    }
    
    public boolean move(Point p1) {
    	double d= this.calcDistance(p1);
    	this.addTotalDistance(d);
    	return true;
    }
    
    public double getTotalDistance(){
         return this.totalDistance;
    }
    
    public Point getLocation()
    {
		return this.location;
    }
    
    
    public boolean setLocation(Point p) {
		if(p.get_x()>=0 && p.get_y()>=0)
		{
			this.location=p;
			return true;
		}
    	return false;
    
    }

    public boolean equals(Object other){
      boolean answer=false;
      if(other instanceof Mobile)
      {
       answer=(this.getLocation()==((Mobile)other).getLocation()&& this.getTotalDistance()==((Mobile)other).getTotalDistance());
      }
      return answer;
  }

    public String toString(){
      return  getLocation().toString()
    		  + "\n           Total Distance: " + getTotalDistance(); 
    }
    
}
