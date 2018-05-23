
/**
 * Write a description of class Grid here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Grid
{
    static char[][] grid;
    Player player;
    
    
    public Grid()
    {
        grid = GridGeneration.getFullGrid();
        player = new Player();
    }
    
    
    public static char[][] getGrid()
    {
        return grid;
    }
    
    public char setGridChar(int rowVal, int colVal) // Returns char that was there before.
    {
        
    }
    
    
    
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
            
        grid[player.getPos()[0]][player.getPos()[1]] = '@';    
            
    }
}
