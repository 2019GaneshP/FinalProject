import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Test extends Frame
{
    
    public Test()
    {
        super("TEST");
        this.setSize(400,400);
        addWindowListener(new WindowAdapter() 
        {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
        }); 
        this.setVisible(true);
    }
    public static void main(String[] args)
    {
    Test t = new Test();
    }
    
    public void paint(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.setFont(new Font(Font.MONOSPACED,Font.PLAIN,12));
        String[][] grid = TileGeneration.getFullGrid();
        int colPos = 100;
        
        for(String[] row : grid)
        {
            int rowPos = 100;
            for(String ch : row)
            {
                g.drawString(ch,rowPos,colPos); // Variable names are backwards. JFrame
                rowPos += 7;                    // handles it oddly. 
            }
            colPos += 10;
        }
    }
}
