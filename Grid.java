
/**
 * Write a description of class Grid here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Grid
{
    private static char[][] grid;
    private MoveableChar player;
    
    
    public Grid()
    {
        grid = GridGeneration.getFullGrid();
        player = new Player();
    }
    
    
    /**
     * returns the whole grid. 
     */
    public static char[][] getGrid()
    {
        return grid;
    }
    
    
    
    /**
     * Sets a certain position in the grid to a character. 
     * return: char that was there previously. 
     */
    public static char setGridChar(int rowVal, int colVal, char charIn) 
    {
        char tempChar = grid[rowVal][colVal];
        grid[rowVal][colVal] = charIn;
        return tempChar;
    }
    
    
    /**
     * returns the char at a certain position in the grid.
     */
    public static char getGridChar(int rowVal, int colVal)
    {
        return grid[rowVal][colVal];
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
    }
}
