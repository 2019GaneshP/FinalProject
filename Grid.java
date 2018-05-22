
/**
 * Write a description of class Grid here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Grid
{
    char[][] grid;
    
    public Grid()
    {
        grid = GridGeneration.getFullGrid();
    }
    
    
    public char[][] getGrid()
    {
        return grid;
    }
    
    
}
