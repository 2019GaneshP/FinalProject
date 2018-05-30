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
    public MoveableChar(int[] posIn, int healthIn, int dmgIn, char iconIn)
    {
        pos = posIn;
        health = healthIn;
        attackDamage = dmgIn;
        icon = iconIn;
        
        forbiddenChars = new ArrayList<Character>();
        forbiddenChars.add('X');
        forbiddenChars.add('M');
        forbiddenChars.add('Z');
        forbiddenChars.add('@');
        prevChar = '-'; //All moveablechars will start on floor
    }
    /**
     * returns the position, where index 0 is the x value and index 1 is y value
     */
    public int[] getPos()
    {
        return pos;
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
        health -= change;
        if(health <= 0 && isMonster(this))
            Window.getGrid().removeMonster((Monster) this);
    }
    
    public void attack(String dir) //Figure out why monsters don't disappear after killed. 
    { 
            if(dir.equals("left"))
            {
                if(!(Window.getGrid().getGridChar(pos[0],pos[1] - 1) == 'X'))
                {
                    Window.getGrid().characterAt(pos[0],pos[1] - 1).changeHealth(5); // TODO: REMOVE PLACEHOLDER
                }
            }
            if(dir.equals("right"))
            {
                if(!(Window.getGrid().getGridChar(pos[0],pos[1] + 1) == 'X'))
                {
                    Window.getGrid().characterAt(pos[0],pos[1] + 1).changeHealth(5);
                }
            }
            if(dir.equals("up"))
            {
                if(!(Window.getGrid().getGridChar(pos[0] - 1,pos[1]) == 'X'))
                {
                    Window.getGrid().characterAt(pos[0] - 1,pos[1]).changeHealth(5);
                }
            }   
            if(dir.equals("down"))
            {
                if(!(Window.getGrid().getGridChar(pos[0] + 1,pos[1]) == 'X'))
                {
                    Window.getGrid().characterAt(pos[0] + 1,pos[1]).changeHealth(5);
                }
            }    
    }
}
