import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.*;

public class Window extends Frame
{
    private static ArrayList<Grid> grids;
    private static Grid currGrid;
    private BufferedImage bufferImage;
    public static Grid nullGrid = new Grid(0,0);
    
    
    public Window()
    {
        super("Totally not a virus");
        printWelcome();
        grids = new ArrayList<Grid>();
        currGrid = new Grid(5,5);
        currGrid.createPlayer();
        grids.add(currGrid);
        currGrid.populate();
        this.setSize(400,400);
        this.setBackground(Color.BLACK);
        
        
        addWindowListener(new WindowAdapter() 
        {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
        }); 
        this.setVisible(true);
        this.addKeyListener(new KeyListener() //Copied from internet. Figure out how to move player.
        {
            @Override
            public void keyTyped(KeyEvent e) 
            {
            }

            @Override
            public void keyPressed(KeyEvent e) 
            {
                //System.out.println("Key pressed code=" + e.getKeyCode() + ", char=" + e.getKeyChar());
                currGrid.processKeyPress(e.getKeyCode());
                repaint();
            }

            @Override
            public void keyReleased(KeyEvent e) 
            {
            }
        });
    }
    
    public static void main(String[] args)
    {
        Window w = new Window();
    }
    
    public static Grid getGrid()
    {
        return currGrid;
    }
    
    public static void setGrid(Grid in)
    {
        currGrid = in;
    }
    
    public static char[][] getCharGrid()
    {
        return currGrid.getGrid();
    }
    
    public static void changeGridDown()
    {
        if(grids.indexOf(currGrid) + 1 == grids.size())
        {
            Grid g = new Grid(5,5);
            grids.add(g);
            currGrid = g;
            if( grids.indexOf(currGrid) == 1)
                currGrid.spawnStrawberry();
            currGrid.populate();
            System.out.println("You are on level " + grids.indexOf(currGrid));
        }
        else
        {
            currGrid = grids.get(grids.indexOf(currGrid) - 1);
            System.out.println("You are on level " + grids.indexOf(currGrid));
        }
        
    }
    
    public static int getGridIndex()
    {
        return grids.indexOf(currGrid);
    }
        
    private void printWelcome()
    {
        System.out.println("Welcome to the game! \n" +
                           "Move with the arrow keys, and attack monsters by moving into them\n" +
                           "Pick up items by pressing the \"g\" key\n" +
                           "Once you have cleared a level, move down by pressing \">\"\n" +
                           "Swords ('/') will increase the damage you deal\n" +
                           "Armor (']') will increase your defense against attacks\n" +
                           "Potions ('!') will increase your health\n" +
                           "As you go down the dungeon, Monsters' health will increase linearly\n" + 
                           "and their damage will increase exponentially!\n" +
                           "Your goal is to get the mystical strawberry from the dungeon.\n");
    }
    
    public void paint(Graphics g)
    {
        if(currGrid != null)
        {
            bufferImage = new BufferedImage(this.getWidth(),this.getHeight(),4);
            Graphics2D graph = bufferImage.createGraphics();
            
            graph.setColor(Color.WHITE);
            graph.setFont(new Font(Font.MONOSPACED,Font.PLAIN,12));
            char[][] grid = Window.getCharGrid();
            int colPos = 100;
            
            for(char[] row : grid)
            {
                int rowPos = 100;
                for(char ch : row)
                {
                    if(ch != '*')
                        graph.drawString(Character.toString(ch),rowPos,colPos); // Variable names are backwards. Frame
                    else
                    {
                        graph.setColor(Color.RED);
                        graph.drawString(Character.toString(ch),rowPos,colPos);
                        graph.setColor(Color.WHITE);
                    }
                    rowPos += 7;                    // handles it oddly. 
                }
                colPos += 10;
            }

            g.drawImage(bufferImage, 0, 0, null);
        }
        else
        {
            bufferImage = new BufferedImage(this.getWidth(),this.getHeight(),4);
            Graphics2D graph = bufferImage.createGraphics();
            
            graph.setColor(Color.RED);
            graph.setFont(new Font(Font.MONOSPACED,Font.PLAIN,36));
            graph.drawString("You Are Dead",200,100);
            g.drawImage(bufferImage, 0, 0, null);
        }
    }
    
    
}
