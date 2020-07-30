/**
 * @author Patrick Luggasi 319266177
 * @author Ivan Borinseco 317366102
 * 
 * Animal class Inheritates Mobile
 * 
 * @param gender- (Male,Female,Hermaphrodite)
 *  @param name - name of the animal
 *  @param weight - weight of the animal
 *  @param speed - the speed of the animal
 *  @param medals - array of all the medals of the Animal
 *  @param position - the position of the animal
 *  
 * Creation of an Animal type 
 */

package Animals;

import java.awt.image.BufferedImage;

import Mobility.Mobile;
import Mobility.Point;
import Olympics.Medal;
import graphics.CompetitionPanel;
import graphics.IAnimal;

public abstract class Animal extends Mobile implements IAnimal,Cloneable {
	enum gender{Male, Female, Hermaphrodite};
	private String name;
	private gender ge;
	private double weight;
	private double speed;
	private Medal medals[];
	private Point position;
	private String sound;
	protected int size=32;
	protected int maxEnergy=10;
	protected int energyPerMeter;
	protected CompetitionPanel pan;
	protected BufferedImage img1, img2, img3, img4;
	public enum orientation{EAST,SOUTH,WEST,NORTH};
	orientation orie;

	public Animal(){
		super();
		this.name="Unnamed";
		this.ge=gender.Hermaphrodite;
		this.weight=0;
		this.speed=1;
		this.medals=new Medal[100];
		this.position=new Point();
	}


	public Animal(String name,int gend,double weight,double speed, Point p) {
		super(p);
		this.position=super.getLocation();
		this.set_name(name);
		this.set_weight(weight);
		this.set_speed(speed);
		this.set_gender(gend);
	}

	public boolean set_position(Point p){
		return super.setLocation(p);
	}

	public String get_name() {
		return this.name;
	}
	
	public gender get_gender() {
		return this.ge;
	}
	
	public double get_weight() {
		return this.weight;
	}
	
	public double get_speed() {
		return this.speed;
	}
	
	
	public Medal[] get_medal() {
		return this.medals;
	}
	
	public Point get_position() {
		return this.position;
	}
	
	
	public boolean set_name(String name1) {
		this.name=name1;
		return true;
	}
	
	public boolean set_gender(int x) {
		switch (x) {
		case 1:
			this.ge=gender.Male;
			return true;
			
		case 2:
			this.ge=gender.Female;
			return true;
		
		case 3:	
			this.ge=gender.Hermaphrodite;
			return true;
			
		default:
			return false;
		}
		
	}
	
	public boolean set_weight(double d) {
		if(d>=0)
		{
			this.weight=d;
			return true;
		}
		return false;
	}
	
	
	public boolean set_speed(double sp) {
		if(sp>=0) {
			this.speed=sp;
			return true;
		}
		return false;
	}
	
	
	public void makeSound(){
		System.out.println("Animal " + this.name + " said <" + this.getSound() + ">");	

	 }
	 
	 public void setSound(String s){
		 this.sound=s;
	 }

	 public String getSound(){
		return this.sound;
	}

	 public String toString(){
		return "Data about: \n" 
		+ " Name: " + get_name()
		+ "\n Gender: " + get_gender()
		+ "\n Weight: " + get_weight()
		+ "\n Speed: " + get_speed()
		+ "\n Medals: " + get_medal()
		+ "\n Position: " + super.toString(); 
		 
	}
	
	public boolean equals(Object other){
        boolean answer=false;
        if(other instanceof Animal)
        {
		answer=super.equals(other)&&this.get_name() == ((Animal)other).get_name()&&this.get_gender() == ((Animal)other).get_gender()&&this.get_weight() == ((Animal)other).get_weight()&&this.get_speed() == ((Animal)other).get_speed();
        }
        return answer;
	}
	
	public int get_MaxEnergyAmount()
	{
		return maxEnergy;
	}

	//public int set_Energy(int energy)
	//{
//		if (enregy>5)
//	}

	public abstract String get_Category();
	public abstract String get_Type();
	public abstract void loadImages(String nm);
	
	public CompetitionPanel getPan()
	{
		return this.pan;
	}


	public orientation moveSide(String s){

		if(s.equals("1")){
			return orie.EAST;
		}
		else if(s.equals("2"))
		{
			return orie.WEST;
		}
		else if(s.equals("3")){
			return orie.NORTH;
		}
		else if(s.equals("4")){
			return orie.SOUTH;
		}
		return this.getOri();
		
	}
	//East
	public BufferedImage get_img1(){
		return this.img1;
	}
	//West
	public BufferedImage get_img2(){
		return this.img2;
	}
	//North
	public BufferedImage get_img3(){
		return this.img3;
	}
	//South
	public BufferedImage get_img4(){
		return this.img4;
	}

	public orientation getOri(){
		return orie;
	} 


}


