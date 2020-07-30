/**
 * @author Patrick Luggasi 319266177
 * @author Ivan Borinseco 317366102
 * 
 * Point class 
 * 
 * @param x - the position in the x axis 
 * @param y - the position in the y axis
 * Creation of A Point 
 */

package Mobility;

public class Point {
    private int x;
    private int y;

    public Point(){
        this.x=0;
        this.y=0;
    }
    public Point(int x,int y)
    {
        if(x<0 || y<0)
        {
            throw new RuntimeException("Incorrect point values!");
        }

        this.x=x;
        this.y=y;
    }

	public int get_x(){
        return this.x;
    }
    
    public int get_y(){
        return this.y;
    }

    
    public boolean set_x(int numx){
        if(numx<0)
        {
            return false;
        }
        this.x=numx;
        return true;
    }

    
    public boolean set_y(int numy){
        if(numy<0)
        {
            return false;
        }
        this.y=numy;
        return true;
    }

    public boolean equals(Object other){
        boolean answer=false;
        if(other instanceof Point)
        {
         answer=( get_x()==((Point)other).x  &&  get_y()==((Point)other).y);
        }
        return answer;
    }

    public String toString(){
        return "Point x: "+ get_x() + "\n           Point y: " + get_y();
    }
}