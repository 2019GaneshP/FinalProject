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
        prevChar = Grid.getGridChar(pos[0],pos[1]);
    }
    /**
     * returns the position, where index 0 is the x value and index 1 is y value
     */
    public int[] getPos()
    {
        return pos;
    }
    /**
     * Moves the MoveableChar based on the direction passed in. Will not move that direction if there is a wall
     * (denoted by 'X') in the way. 
     */
    public void move(String dir)
    {
       
            if(dir.equals("left"))
            {
                if(!(forbiddenChars.contains(Grid.getGridChar(pos[0],pos[1] - 1))))
                {
                    pos[1]--;
                    Grid.setGridChar(pos[0],pos[1] + 1, prevChar);
                    prevChar = Grid.setGridChar(pos[0],pos[1],icon);
                }
            }
            if(dir.equals("right"))
            {
                if(!(forbiddenChars.contains(Grid.getGridChar(pos[0],pos[1] + 1))))
                {
                    pos[1]++;
                    Grid.setGridChar(pos[0],pos[1] - 1, prevChar);
                    prevChar = Grid.setGridChar(pos[0],pos[1],icon);
                }
            }
            if(dir.equals("up"))
            {
                if(!(forbiddenChars.contains(Grid.getGridChar(pos[0] - 1,pos[1]))))
                {
                    pos[0]--;
                    Grid.setGridChar(pos[0] + 1,pos[1], prevChar);
                    prevChar = Grid.setGridChar(pos[0],pos[1],icon);
                }
            }   
            if(dir.equals("down"))
            {
                if(!forbiddenChars.contains(Grid.getGridChar(pos[0] + 1,pos[1])))
                {
                    pos[0]++;
                    Grid.setGridChar(pos[0] - 1,pos[1], prevChar);
                    prevChar = Grid.setGridChar(pos[0],pos[1],icon);
                }
            }    
    }
    public abstract void attack();
}
