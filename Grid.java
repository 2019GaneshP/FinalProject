import java.util.*;
/**
 * Write a description of class Grid here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Grid
{
    private char[][] grid;
    private Player player;
    private ArrayList<Monster> monsters;
    private final int NUM_MONSTERS;
    
    public Grid(int numMonstersIn)
    {
        NUM_MONSTERS = numMonstersIn;
        grid = GridGeneration.getFullGrid();
        monsters = new ArrayList<Monster>();
        for(int i = 0; i < NUM_MONSTERS; i++)
            this.addMonster(Monster.createMonster());
        player = new Player();
    }
    
    
    /**
     * returns the whole grid. 
     */
    public char[][] getGrid()
    {
        return grid;
    }
    
    public void addMonster(Monster m)
    {
        monsters.add(m);
    }
    
    /**
     * Sets a certain position in the grid to a character. 
     * return: char that was there previously. 
     */
    public char setGridChar(int rowVal, int colVal, char charIn) 
    {
        char tempChar = grid[rowVal][colVal];
        grid[rowVal][colVal] = charIn;
        return tempChar;
    }
    
    public MoveableChar characterAt(int x, int y)
    {
        for(Monster m : monsters)
            if(m.getPos()[0] == x && m.getPos()[1] == y)
                return m;
        if(player.getPos()[0] == x && player.getPos()[1] == y)
            return player;
        return null;        
    }
    
    /**
     * returns the char at a certain position in the grid.
     */
    public char getGridChar(int rowVal, int colVal)
    {
        return grid[rowVal][colVal];
    }
    
    public void removeMonster(Monster m)
    {
        monsters.remove(m);
    }
    
    /**
     * processes inputs by user to move player char. 
     * will add to this later.
     */
    public void processKeyPress(int keyCode)
    {
        if(keyCode == 37)
            player.move("left");
        else if(keyCode == 38)
            player.move("up");
        else if(keyCode == 39)
            player.move("right");
        else if(keyCode == 40)
            player.move("down");
            
        for(Monster m : monsters)
        {
            m.moveMonster();
        }
    }
}
