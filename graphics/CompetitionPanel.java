/** 
 * @author Patrick Luggasi 319266177
 * @author Ivan Borisenco 317366102
 * 
 * AirAnimal class Inheritates Animal
 * 

 */

package graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
//import java.util.Timer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Animals.Animal;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;

import javax.swing.Timer;
import java.awt.event.ActionEvent;

public class CompetitionPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    protected BufferedImage background;
    Animal[] arr;
    private int yOffset = 0;
    private int xOffset=180;
    private int xDelta=4;
    private int yDelta = 4;
    private int xBackset=0;
    private int yBackset;
    public CompetitionPanel(Animal[] arr) {

        try {
            background = ImageIO.read(new File("graphics/competitionBackground.png"));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        this.arr = arr;
        
   //instead of 50 speed of animal
   Timer timer = new Timer(50, new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        //from right to left 
          if (xOffset < 1006 ) {
            xOffset += xDelta;
            repaint();
          if(xOffset >=1002){
            yBackset=60;
          }
        }
        // from high to low
        else if(yBackset<740){
          yBackset += yDelta;
          repaint();
          if(yBackset >=736){
            xBackset=xOffset;
          }
        }
        //from left to right
        else if(xBackset>190){
          xBackset -= xDelta;
          repaint();
          if(xBackset<=188){
            yOffset=yBackset;
          }
        }
        //from low to high
        else if( yOffset>30){
          yOffset -= yDelta;
          repaint();
        }
      }
    });
     timer.start();
  }

    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, this);
        if (true) {
            for (int i = 0; i < arr.length && arr[i] != null; ++i) {
                if (arr[i].get_Category().equals("Water")) { 
                    Graphics2D g2d = (Graphics2D) g.create();
                    int xPos = xOffset;
                    int yPos = 180;
                    xPos = xOffset;


                    
                   while (xPos < arr[i].get_position().get_x()+920) {
                    g2d.drawImage(arr[i].get_img1(), xPos, yPos*i+110,65,65, this);  
                    xPos += background.getWidth();
                  }

                  if(xBackset>=1){
                    xPos=xBackset;
                    while (xPos > arr[i].get_position().get_x()+90) {
                      g2d.drawImage(arr[i].get_img2(), xPos, yPos*i+110,65,65, this);  
                      xPos -= background.getWidth();
                    }
                    }
                }





                if (arr[i].get_Category().equals("Terrestrial")) {



                    Graphics2D g2d = (Graphics2D) g.create();
                    int xPos ;
                    int yPos = 20;
                  //from left to to right

                  if(xOffset<1006){
                    xPos = xOffset;
                   while (xPos < arr[i].get_position().get_x()+920) {
                    g2d.drawImage(arr[i].get_img1(), xPos, yPos*i,65,65, this);  
                    xPos += background.getWidth();
                  }
                  
                }

                  // from high to low
                  
                  if(yBackset<=740){
                      yPos=yBackset;
                      xPos=xOffset;
                      while (yPos < arr[i].get_position().get_y()+700) {
                      g2d.drawImage(arr[i].get_img4(), xPos, yPos,65,65, this);  
                      yPos += background.getHeight();
                    }
                    }

                    //from right to left
                    if(xBackset>=190){
                    xPos=xBackset;
                    while (xPos > arr[i].get_position().get_x()+90) {
                    g2d.drawImage(arr[i].get_img2(), xPos, yPos,65,65, this);  
                    xPos -= background.getWidth();
                  }


                  }

                
                  // from low to high
                  if(yOffset>=30){
                    yPos=yOffset;
                    xPos=xBackset;
                  while (yPos > arr[i].get_position().get_y()+30) {
                  g2d.drawImage(arr[i].get_img3(), xPos, yPos,65,65, this);  
                  yPos -= background.getHeight();
                }
                }

                         
                }

                g.dispose();






                if (arr[i].get_Category().equals("Air")) {
                    //putting at starting point the animal
                    //g.drawImage(arr[i].get_img1(), arr[i].get_position().get_x() + 60,arr[i].get_position().get_y() - 90 + (2 * i * 95), 65 * 2, 65, this);      
                    Graphics2D g2d = (Graphics2D) g.create();
                    int xPos = xOffset;
                    int yPos = 100;
                    xPos = xOffset;
                   while (xPos < arr[i].get_position().get_x()+920) {
                    g2d.drawImage(arr[i].get_img1(), xPos , yPos - 90 + (2 * i * 95),65,65, this);  
                    xPos += background.getWidth();
                  }


                }
            }

                }      
    
            //g2d.dispose();
            }
           
    }

