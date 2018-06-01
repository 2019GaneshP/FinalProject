import java.util.*;
/**
 * Write a description of interface MoveableChar here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class MoveableChar
{
    int[] pos = new int[2]; // 0 is y-coord, 1 is x-coord
    private int health;
    private int attackDamage;
    private char icon;
    private char prevChar;
    private ArrayList<Character> forbiddenChars; //Chars that the player can't move in to. 
    
    /**
     * Creates a new MoveableChar
     * 
     */
    public MoveableChar(int healthIn, int dmgIn, char iconIn)
    {
        
        health = healthIn;
        attackDamage = dmgIn;
        icon = iconIn;
        
        forbiddenChars = new ArrayList<Character>();
        forbiddenChars.add('X');
        forbiddenChars.add('M');
        forbiddenChars.add('Z');
        forbiddenChars.add('@');
        prevChar = '-'; //All moveablechars will start on floor
        pos = this.generatePos();
    }
    /**
     * returns the position, where index 0 is the x value and index 1 is y value
     */
    public int[] getPos()
    {
        return pos;
    }
    
    public char getIcon()
    {
        return icon;
    }
    
    public void setPrevChar(char charIn)
    {
        prevChar = charIn;
    }
    
    public boolean isMonster(MoveableChar m)
    {
        if(m.icon != '@')
            return true;
        return false;
    }
    
    /**
     * Moves the MoveableChar based on the direction passed in. Will not move that direction if there is a wall
     * (denoted by 'X') in the way. 
     */
    public void move(String dir)
    {
       
            if(dir.equals("left"))
            {
                if(!(forbiddenChars.contains(Window.getGrid().getGridChar(pos[0],pos[1] - 1))))
                {
                    pos[1]--;
                    Window.getGrid().setGridChar(pos[0],pos[1] + 1, prevChar);
                    prevChar = Window.getGrid().setGridChar(pos[0],pos[1],icon);
                }
                else this.attack("left");
            }
            if(dir.equals("right"))
            {
                if(!(forbiddenChars.contains(Window.getGrid().getGridChar(pos[0],pos[1] + 1))))
                {
                    pos[1]++;
                    Window.getGrid().setGridChar(pos[0],pos[1] - 1, prevChar);
                    prevChar = Window.getGrid().setGridChar(pos[0],pos[1],icon);
                }
                else this.attack("right");
            }
            if(dir.equals("up"))
            {
                if(!(forbiddenChars.contains(Window.getGrid().getGridChar(pos[0] - 1,pos[1]))))
                {
                    pos[0]--;
                    Window.getGrid().setGridChar(pos[0] + 1,pos[1], prevChar);
                    prevChar = Window.getGrid().setGridChar(pos[0],pos[1],icon);
                }
                else this.attack("up");
            }   
            if(dir.equals("down"))
            {
                if(!forbiddenChars.contains(Window.getGrid().getGridChar(pos[0] + 1,pos[1])))
                {
                    pos[0]++;
                    Window.getGrid().setGridChar(pos[0] - 1,pos[1], prevChar);
                    prevChar = Window.getGrid().setGridChar(pos[0],pos[1],icon);
                }
                else this.attack("down");
            }    
    }
    
    public void changeHealth(int change)
    {
        health += change;
        if(health <= 0 && isMonster(this))
        {
            Window.getGrid().setGridChar(this.getPos()[0],this.getPos()[1],this.prevChar);
            Window.getGrid().removeMonster((Monster) this);
            System.out.println("The " + this.getName() + " is killed!");
        }
        else if(health <= 0) //Player char
        {
            
        }
    }
    
    private int getDamage()
    {
        return attackDamage;
    }
    
    
    public void attack(String dir) //Figure out why monsters don't disappear after killed. 
    { 
            if(dir.equals("left"))
            {
                if(!(Window.getGrid().getGridChar(pos[0],pos[1] - 1) == 'X'))
                {
                    Window.getGrid().characterAt(pos[0],pos[1] - 1).changeHealth(-(this.getDamage())); // TODO: REMOVE PLACEHOLDER
                }
            }
            if(dir.equals("right"))
            {
                if(!(Window.getGrid().getGridChar(pos[0],pos[1] + 1) == 'X'))
                {
                    Window.getGrid().characterAt(pos[0],pos[1] + 1).changeHealth(-(this.getDamage()));
                }
            }
            if(dir.equals("up"))
            {
                if(!(Window.getGrid().getGridChar(pos[0] - 1,pos[1]) == 'X'))
                {
                    Window.getGrid().characterAt(pos[0] - 1,pos[1]).changeHealth(-(this.getDamage()));
                }
            }   
            if(dir.equals("down"))
            {
                if(!(Window.getGrid().getGridChar(pos[0] + 1,pos[1]) == 'X'))
                {
                    Window.getGrid().characterAt(pos[0] + 1,pos[1]).changeHealth(-(this.getDamage()));
                }
            }    
    }
    
    private int[] generatePos()
    {
        int r1 = (int)(Math.random() * Window.getGrid().getGridLength()); // row
        int r2 = (int)(Math.random() * Window.getGrid().getGridWidth()); //col
        while(Window.getGrid().getGrid()[r1][r2] != '-')
        {
            r1 = (int)(Math.random() * Window.getGrid().getGrid().length); // row
            r2 = (int)(Math.random() * Window.getGrid().getGrid()[0].length); //col
        }
        
        return new int[] {r1,r2};
    }
    
    
    public abstract String getName();
    
    public String toString()
    {
        return this.getName() + this.getPos();
    }
}
