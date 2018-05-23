import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Window extends Frame
{
    
    public Window()
    {
        super("TEST");
        Grid gr = new Grid();
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
                System.out.println("Key pressed code=" + e.getKeyCode() + ", char=" + e.getKeyChar());
                gr.processKeyPress(e.getKeyCode());
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
    
    public void paint(Graphics g)
    {
        g.setColor(Color.WHITE);
        g.setFont(new Font(Font.MONOSPACED,Font.PLAIN,12));
        char[][] grid = Grid.getGrid();
        int colPos = 100;
        
        for(char[] row : grid)
        {
            int rowPos = 100;
            for(char ch : row)
            {
                g.drawString(Character.toString(ch),rowPos,colPos); // Variable names are backwards. JFrame
                rowPos += 7;                    // handles it oddly. 
            }
            colPos += 10;
        }
    }
    
    
}
