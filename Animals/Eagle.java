/**
 * @author Patrick Luggasi 319266177
 * @author Ivan Borinseco 317366102
 * 
 * Eagle class Inheritates Air Animals
 * 
 * @param altitudeOfFlight   the fly height of the Eagle
 * @param Max_Altitude max height 
 * Creation of an animal type Eagle 
 * 
 */

package Animals;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Mobility.Point;

public class Eagle extends AirAnimal {
    private double altitudeOfFlight;
    static final double Max_Altitude = 100;

    public Eagle() {
        super();
        super.setSound("Clack-wack-chack");
        this.altitudeOfFlight = 20;
    }

    public Eagle(String name, int gend, double weight, double speed, Point p, double wingspan, double altitude) {
        super(name, gend, weight, speed, p, wingspan);
        super.setSound("Clack-wack-chack");
        if (altitude < 0 || altitude > 100) {
            throw new RuntimeException(
                    "Wrong Input of Altitude cant be lower than 0 or higher than 100 and yours is " + altitude);
        } else {
            this.altitudeOfFlight = altitude;
        }
    }

    public double getAltitudeOfFlight() {
        return this.altitudeOfFlight;
    }

    public boolean setAltitudeOfFlight(double x) {
        double check = altitudeOfFlight + x;
        if (check > 100 || check < 0) {
            System.out.println("Infucient flight Altitude");
            return false;
        } else {
            this.altitudeOfFlight = check;
            return true;
        }
    }

    public String toString() {
        return "Eagle: \n" + super.toString() + "\n           Altitude Of Flight: " + getAltitudeOfFlight();
    }

    public boolean equals(Object other) {
        boolean answer = false;
        if (other instanceof Eagle) {
            answer = super.equals(other) && (this.altitudeOfFlight == ((Eagle) other).getAltitudeOfFlight());
        }
        ;
        return answer;
    }


  
    public void loadImages(String nm) {
        try { super.img1 = ImageIO.read(new File("graphics/eagle"+nm+".png")); }
		catch (IOException e) { System.out.println("Cannot load image"); }

    }

	public String get_Category() {
		return "Air";
	}

	public String get_Type() {
		return "Eagle";
	}
    

  
    public boolean eat(int energy) {
        if(maxEnergy+energy<10){
			maxEnergy=maxEnergy+energy;
			return true;
		}
		return false;
    }
}
