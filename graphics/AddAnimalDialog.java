/** 
 * @author Patrick Luggasi 319266177
 * @author Ivan Borinseco 317366102
 * 
 * AirAnimal class Inheritates Animal
 * 

 */

package graphics;

import Animals.*;
import Mobility.Point;


import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddAnimalDialog extends JDialog  {

    /**
     *
     */

    private static final long serialVersionUID = 1L;
    private int maxTerrestrial = 2;
    private int maxWater = 4;
    private int maxair = 5;
    private String competitionType;
    // Strings of different types for comboBox
    private String[] WaterAnimal = { "Choose","Whale", "Dolphin","Alligator","Stop Choosing"};
    private String[] AirAnimal = { "Choose","Pigeon", "Eagle","Stop Choosing"};
    private String[] LandAnimal = { "Choose","Dog", "Cat", "Snake","Stop Choosing"};
    private String[] gender = { "Choose","Male", "Female","Hermaphrodite"};
    public Animal[] animalArray;
    String[] waterType={"Sea","Sweet"};

    JLabel label1 = new JLabel("Animal Name");
    JLabel label2 = new JLabel("Category");
    JLabel label3 = new JLabel("Type");
    JLabel label4 = new JLabel("Speed");
    JLabel label6 = new JLabel("Distance");
    JLabel label7 = new JLabel("Energy Comsumpt.");
    JLabel label8 = new JLabel("Gender");
    JLabel label9 = new JLabel("Weight");
    JLabel label11 = new JLabel("Point x");
    JLabel label12 = new JLabel("Point y");

    JTextField animalName = new JTextField();
    JTextField Speed = new JTextField("1");

    JTextField energyCon = new JTextField();
    JTextField distance = new JTextField();
    JTextField weight = new JTextField();
    JTextField pointx = new JTextField("0");
    JTextField pointy = new JTextField("0");

    AddAnimalDialog(String CompType) {
        this.competitionType=CompType;
    }
   


    private String[] animalQuestionary() {
        String[] st=new String[4];
        st[0]=(String)JOptionPane.showInputDialog("Animals Name:");

        st[1]=(String)JOptionPane.showInputDialog(this,
                        "ChooseAnimals Gender",
                         "Gender Dialog", JOptionPane.PLAIN_MESSAGE , null, gender,null); 
        if(st[1]=="Male"){st[1]="0";}
        if(st[1]=="Female"){st[1]="1";} 
        if(st[1]=="Hermaphrodite"){st[1]="2";}                     

        st[2]=(String)JOptionPane.showInputDialog("Enter Animals Weight:");

        st[3]="1";

        return st;
    }


    public Animal[] Questionary() {
        boolean stop=true;
        int counter=0;
        String str;
        Point Landpoint=new Point(0,0);
        String[] generalAtrrs= new String[4]; 
        if(competitionType == "Water Competition"){
            this.animalArray=new Animal[maxWater];
            while(stop&&counter < maxWater){
                str=(String)JOptionPane.showInputDialog(this,
                       "Choose Water Animal",
                        "Water Animal Dialog", JOptionPane.PLAIN_MESSAGE , null, WaterAnimal,null);
                        Point WaterPoint=new Point(counter+40,0);
                if(str== "Stop Choosing") {stop = false;}

                else if(str == "Whale"){
                    generalAtrrs=this.animalQuestionary();
                    String dept="-1";
                    String FoodType=(String)JOptionPane.showInputDialog("Enter The Food Type");
                    animalArray[counter]=new Whale(generalAtrrs[0],Integer.parseInt(generalAtrrs[1]),Double.parseDouble(generalAtrrs[2]),Double.parseDouble(generalAtrrs[3]),WaterPoint,Double.parseDouble(dept),FoodType);
                    
                    String pictureNumber=(String)JOptionPane.showInputDialog("Picture 1 or Picture 2");
                    animalArray[counter].loadImages(pictureNumber);
                    JOptionPane.showMessageDialog(this, "Whale Added to competition");
                    

                }    
                else if(str == "Alligator"){
                    generalAtrrs=this.animalQuestionary();
                    Double dept= -1.0;
                    String FoodType=(String)JOptionPane.showInputDialog("Enter Area Of Living");
                    String legsnumber=(String)JOptionPane.showInputDialog("Enter Number of legs");
                    animalArray[counter]=new AlligatorDelegator(generalAtrrs[0],Integer.parseInt(generalAtrrs[1]),Double.parseDouble(generalAtrrs[2]),Double.parseDouble(generalAtrrs[3]),WaterPoint,dept,FoodType, Integer.parseInt(
                            legsnumber));
                    
                    String pictureNumber=(String)JOptionPane.showInputDialog("Picture 1 or Picture 2 or 3");
                    animalArray[counter].loadImages(pictureNumber);
                    JOptionPane.showMessageDialog(this, "Alligator Added to competition");
                }   
                else if(str == "Dolphin"){
                    generalAtrrs=this.animalQuestionary();
                    Double dept= -1.0;
                    String FoodType=(String)JOptionPane.showInputDialog(this,
                    "Water Type:",
                     "Water Type  Dialog", JOptionPane.PLAIN_MESSAGE , null, waterType,null); 
                     if(FoodType== "Sea"){FoodType="0";}
                     if(FoodType== "Sweet"){FoodType="1";}
                    animalArray[counter]=new Dolphin(generalAtrrs[0],Integer.parseInt(generalAtrrs[1]),Double.parseDouble(generalAtrrs[2]),Double.parseDouble(generalAtrrs[3]),WaterPoint,dept,Integer.parseInt(FoodType));
                    String pictureNumber=(String)JOptionPane.showInputDialog("Picture 1 or Picture 2 or 3");
                    animalArray[counter].loadImages(pictureNumber);
                    JOptionPane.showMessageDialog(this, "Dolphin Added to competition");
                }   
                ++counter;
            }

        }
        if(competitionType == "Air Competition"){
            this.animalArray=new Animal[maxair];
            while(stop&&counter < maxair){
                str=(String)JOptionPane.showInputDialog(this,
                       "Choose Air Animal",
                        "Air Animal Dialog", JOptionPane.PLAIN_MESSAGE , null, AirAnimal,null);
                        if(str== "Stop Choosing") {stop = false;}
                        else if(str == "Pigeon")     {
                            generalAtrrs=this.animalQuestionary();
                            String Family=(String)JOptionPane.showInputDialog("Enter Pigeons Family:");
                            String span=(String)JOptionPane.showInputDialog("Enter Pigeons wing span:");
                            Point WaterPoint=new Point(counter,0);
                            animalArray[counter]=new Pigeon(generalAtrrs[0],Integer.parseInt(generalAtrrs[1]),Double.parseDouble(generalAtrrs[2]),Double.parseDouble(generalAtrrs[3]),WaterPoint,Double.parseDouble(span),Family);
                          
                            animalArray[counter].loadImages("ivan");
                            JOptionPane.showMessageDialog(this, "Pigeon Added to competition");
                        }   
                        else if(str == "Eagle"){
                            generalAtrrs=this.animalQuestionary();
                            String span=(String)JOptionPane.showInputDialog("Enter Eagles Wing Span:");
                            String alt=(String)JOptionPane.showInputDialog("Enter Eagles altitude:");
                            Point WaterPoint=new Point(counter,0);
                            animalArray[counter]=new Eagle(generalAtrrs[0],Integer.parseInt(generalAtrrs[1]),Double.parseDouble(generalAtrrs[2]),Double.parseDouble(generalAtrrs[3]),WaterPoint,Double.parseDouble(span),Double.parseDouble(alt));
                      
                            String pictureNumber=(String)JOptionPane.showInputDialog("Picture 1 or Picture 2 or 3");
                            animalArray[counter].loadImages(pictureNumber);
                            JOptionPane.showMessageDialog(this, "Eagle Added to competition");
                        }         
                        ++counter;
            }
        }
        if(competitionType == "Land Competition"){
            this.animalArray=new Animal[maxTerrestrial];
            while(stop&&counter < maxTerrestrial){
                str=(String)JOptionPane.showInputDialog(this,
                       "Choose Land Animal",
                        "Land Animal Dialog", JOptionPane.PLAIN_MESSAGE , null, LandAnimal,null);
                     if(str== "Stop Choosing"){ stop=false; } 
                    else if(str == "Dog")     {
                    generalAtrrs=this.animalQuestionary();
                    String nlegs=(String)JOptionPane.showInputDialog("Enter Number of Legs ");
                    String Breed=(String)JOptionPane.showInputDialog("Enter Dogs Breed");
                    animalArray[counter]=new Dog(generalAtrrs[0],Integer.parseInt(generalAtrrs[1]),Double.parseDouble(generalAtrrs[2]),Double.parseDouble(generalAtrrs[3]),Landpoint,Integer.parseInt(nlegs),Breed);
 
                    String pictureNumber=(String)JOptionPane.showInputDialog("Picture 1 or Picture 2 or 3 or 4 or 5 or 6");
                    animalArray[counter].loadImages(pictureNumber);
                    JOptionPane.showMessageDialog(this, "Dog Added to competition");
                }   
                     else if(str == "Cat"){
                    generalAtrrs=this.animalQuestionary();
                    boolean check = true;
                    String nlegs=(String)JOptionPane.showInputDialog("Enter Number of Legs ");
                    String FoodType=(String)JOptionPane.showInputDialog("is Cat Castrated 0-yes 1-no");
                    if(FoodType=="1"){check= false;}
                    if(FoodType=="0"){check= true;}
                    animalArray[counter]=new Cat(generalAtrrs[0],Integer.parseInt(generalAtrrs[1]),Double.parseDouble(generalAtrrs[2]),Double.parseDouble(generalAtrrs[3]),Landpoint,Integer.parseInt(nlegs),check);
    
                    String pictureNumber=(String)JOptionPane.showInputDialog("Picture 1 or Picture 2 or 3 or 4");
                    animalArray[counter].loadImages(pictureNumber);
                    JOptionPane.showMessageDialog(this, "Cat Added to competition");
                }
                    else if(str == "Snake")
                {
                    generalAtrrs=this.animalQuestionary();
                    String Lentgh=(String)JOptionPane.showInputDialog("Enter Snakes Lentgh:");
                    String poison=(String)JOptionPane.showInputDialog("snake posison level:1 high 2 medium 3 low");
                    animalArray[counter]=new Snake(generalAtrrs[0],Integer.parseInt(generalAtrrs[1]),Double.parseDouble(generalAtrrs[2]),Double.parseDouble(generalAtrrs[3]),Landpoint,0,Integer.parseInt(poison),Double.parseDouble(Lentgh));
     
                    String pictureNumber=(String)JOptionPane.showInputDialog("Picture 1 or Picture 2 or 3");
                    animalArray[counter].loadImages(pictureNumber);
                    JOptionPane.showMessageDialog(this, "Snake Added to competition");
                } 
                ++counter;  
            }
        }

        return this.animalArray;
        
        
    }


    
}