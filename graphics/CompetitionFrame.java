/** 
 * @author Patrick Luggasi 319266177
 * @author Ivan Borisenco 317366102
 * 
 * AirAnimal class Inheritates Animal
 * 

 */

package graphics;

import javax.swing.*;

import Animals.Animal;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.image.BufferedImage;


public class CompetitionFrame extends JFrame implements ActionListener {
    /**
     *
     */
    private boolean Comp = false;
    private static final long serialVersionUID = 1L;
    private final JFrame frame = new JFrame("Competition");
    JPanel bgPanel;
    JButton OptionButtons[];
    JMenuBar Bar;
    JMenu HelpB;
    JMenu FileB;
    JMenuItem ExitItem, AboutItem;
    String data[][];
    Object[] CompType = { "Water Competition", "Air Competition", "Land Competition" };
    String str;
    Animal[] animalsArr;
    BufferedImage background;
    TableExample Tb = new TableExample();
    CompetitionPanel cp;



    CompetitionFrame() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        OptionButtons = new JButton[6];
        FileB = new JMenu("File");
        FileB.setMnemonic(KeyEvent.VK_F);
        ExitItem = new JMenuItem("Exit");
        ExitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        FileB.add(ExitItem);
        HelpB = new JMenu("Help");
        HelpB.setMnemonic(KeyEvent.VK_H);
        AboutItem = new JMenuItem("Help");
        HelpB.add(AboutItem);

        Bar = new JMenuBar();
        Bar.add(FileB);
        Bar.add(HelpB);
        setJMenuBar(Bar);

        ExitItem.addActionListener(this);
        AboutItem.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosed(final WindowEvent e) {
                System.exit(0);
            }
        });


        
        OptionButtons[0] = new JButton("Add Competition");
        OptionButtons[0].addActionListener((java.awt.event.ActionListener)this);
        OptionButtons[1] = new JButton("Add Animal");
        OptionButtons[1].addActionListener((java.awt.event.ActionListener)this);
        OptionButtons[2] = new JButton("Clear");
        OptionButtons[2].addActionListener((java.awt.event.ActionListener)this);
        OptionButtons[3] = new JButton("Eat");
        OptionButtons[3].addActionListener((java.awt.event.ActionListener)this);
        OptionButtons[4] = new JButton("Info");
        OptionButtons[4].addActionListener((java.awt.event.ActionListener)this);
        OptionButtons[5] = new JButton("Exit");
        OptionButtons[5].addActionListener((java.awt.event.ActionListener)this);

        final JPanel ButtonsPanel = new JPanel();
        ButtonsPanel.setLayout(new GridLayout());
        ButtonsPanel.add(OptionButtons[0]);
        ButtonsPanel.add(OptionButtons[1]);
        ButtonsPanel.add(OptionButtons[2]);
        ButtonsPanel.add(OptionButtons[3]);
        ButtonsPanel.add(OptionButtons[4]);
        ButtonsPanel.add(OptionButtons[5]);
        frame.setLayout(new BorderLayout(2, 1));
        frame.add(Bar, BorderLayout.NORTH);
        frame.add(ButtonsPanel, BorderLayout.SOUTH);


        



        
        requestFocus();

        
    }

    public void display() {   
        frame.pack();
        frame.setVisible(true);
        
    }
    public Animal[] delete(String name,Animal[] animalsArr){
        int count=0;
        boolean flag = false;
        while(animalsArr[count] != null){
            ++count;
        }
        if(name.equals(animalsArr[count-1].get_name())){        
            animalsArr[count-1]=null;
            JOptionPane.showMessageDialog(frame,name+ "is Deleted");
        }
        for(int i=0;i<count-1;++i){   
            if(name.equals(animalsArr[i].get_name())){             
                animalsArr[i]=null;
                JOptionPane.showMessageDialog(frame,name+ "is Deleted");
                flag= true;  
                for(int j=i;j<count-1;++j){
                animalsArr[j]=animalsArr[j+1];                   
                }    
                }    
        }
        --count;
        if (flag){

            animalsArr[count]=null;
        }
        return animalsArr;

    }

    public static void main(final String[] args) {
        final CompetitionFrame obj = new CompetitionFrame();
        obj.display();

    }

    public void actionPerformed(ActionEvent e) {
        String s=e.getActionCommand();
        if(e.getSource() == ExitItem || s.equals("Exit") )
		{
			System.exit(0);
		}

        else if(e.getSource() == AboutItem)
		{
			JOptionPane.showMessageDialog(frame, "Home Work 2 \n GUI");
        }

        else if(s.equals("Add Competition"))
        {
            if(this.Comp == false){
                str=(String)JOptionPane.showInputDialog(frame,
                        "Adding Competition \n*Notice only 1 competition per game" + "\nChoose Competition",
                        "Competition Dialog", JOptionPane.PLAIN_MESSAGE , null, CompType,null);    
                this.Comp=true;

            }
            else{
                JOptionPane.showMessageDialog(frame, "Only 1 Competition Per Game");
            }
        }

        else if(s.equals("Add Animal"))
        {
            if(this.Comp==true){
                AddAnimalDialog ad = new AddAnimalDialog(str);
                if(str=="Water Competition"){
                    animalsArr=new Animal[4];
                    animalsArr=ad.Questionary();
                }else if(str == "Land Competition"){
                    animalsArr=new Animal[2];
                    animalsArr=ad.Questionary();
                }else if(str == "Air Competition"){
                    animalsArr=new Animal[5];
                    animalsArr=ad.Questionary();
                }
                Tb.addAnimalsArray(animalsArr);  
                cp=new CompetitionPanel(animalsArr);
                frame.add(cp); 
                frame.pack();  
            }

            else{
                JOptionPane.showMessageDialog(frame, "Must Add Competition First");
            }

        }

        else if(s.equals("Clear"))
        {
            Tb.display();
            String name=(String)JOptionPane.showInputDialog("Enter the name of the animal you want to delete from the table:");
            Tb.close();
            animalsArr=delete(name, animalsArr);
        }

        else if(s.equals("Eat"))
        {
            Tb.display();
            String name=(String)JOptionPane.showInputDialog("Enter the name of the animal you want to feed from the table:");
            for(int i=0;i<animalsArr.length-1 && animalsArr[i] != null;++i){   
                if(name == animalsArr[i].get_name()){   
                    String energy=(String)JOptionPane.showInputDialog("How Much Food You want to give hem on a scale of 1-10:");       
                    animalsArr[i].eat(Integer.parseInt(energy)); 
                }

        }}

        else if (s.equals("Info"))
        {
            Tb.display();
        }
              
            
        }


        public class TableExample {    
            JFrame  f=new JFrame();    
            Object[] column={"Animal","Category","Type","Speed","Energy Amount","Distance","Energy Comsumpt."};  
            Object[] row= new Object[7]; 
            JTextField textAnimal;
            JTextField textCat;
            JTextField textType ;
            JTextField textSpeed;
            JTextField textEnergyAmount;
            JTextField textDistance ;
            JTextField textEconst ;
            JTable jt=new JTable();    
            DefaultTableModel model= new DefaultTableModel();
            JScrollPane sp=new JScrollPane(jt); 

            //Constructor
            TableExample(){     
            model.setColumnIdentifiers(column);
            jt.setModel(model);
            jt.setBounds(100,50,200,300);   
            f.add(sp);          
            f.setSize(300,400);    
            f.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  
        }     



    
       public void close(){
           f.setVisible(false);
       }
       public void display(){
        f.setVisible(true);  
       }
       public void addAnimalsArray(Animal[] animalsArr){
        for(int i=0;i<animalsArr.length && animalsArr[i] != null;++i){
            textAnimal= new JTextField(animalsArr[i].get_name());
            textCat= new JTextField(animalsArr[i].get_Category());
            textType= new JTextField(animalsArr[i].get_Type());
            textSpeed= new JTextField(String.valueOf(animalsArr[i].get_speed()));
            textEnergyAmount =new JTextField(String.valueOf(animalsArr[i].get_MaxEnergyAmount()));
            textDistance= new JTextField(String.valueOf(animalsArr[i].getTotalDistance()));
            textEconst=new JTextField(String.valueOf(animalsArr[i].get_MaxEnergyAmount()));
            row[0] = textAnimal.getText();
            row[1] = textCat.getText();
            row[2] = textType.getText();
            row[3] = textSpeed.getText();
            row[4] = textEnergyAmount.getText();
            row[5] = textDistance.getText();
            row[6] = textEconst.getText();
            model.addRow(row); 
            }    


       }

    }

}