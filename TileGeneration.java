
/**
 * Write a description of class TileGeneration here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TileGeneration
{
    private static final int SIDE_LENGTH = 10;
    private static String[][] topLeft = {{"XXXXXXXXXX"},
                          {"X--------X"},
                          {"X--------X"},
                          {"X--------X"},
                          {"X--------X"},
                          {"X--------#"},
                          {"X--------X"},
                          {"X--------X"},
                          {"X--------X"},
                          {"XXXXX#XXXX"},};
    String[][] topCenter ={{"XXXXXXXXXX"},
                          {"X--------X"},
                          {"X--------X"},
                          {"X--------X"},
                          {"X--------X"},
                          {"#--------#"},
                          {"X--------X"},
                          {"X--------X"},
                          {"X--------X"},
                          {"XXXXX#XXXX"},};
    String[][] topRight = {{"XXXXXXXXXX"},
                          {"X--------X"},
                          {"X--------X"},
                          {"X--------X"},
                          {"X--------X"},
                          {"#--------X"},
                          {"X--------X"},
                          {"X--------X"},
                          {"X--------X"},
                          {"XXXXX#XXXX"},};
    String[][] botLeft = {{"XXXXX#XXXX"},
                          {"X--------X"},
                          {"X--------X"},
                          {"X--------X"},
                          {"X--------X"},
                          {"X--------#"},
                          {"X--------X"},
                          {"X--------X"},
                          {"X--------X"},
                          {"XXXXXXXXXX"},};
    String[][] botCenter ={{"XXXXX#XXXX"},
                          {"X--------X"},
                          {"X--------X"},
                          {"X--------X"},
                          {"X--------X"},
                          {"#--------#"},
                          {"X--------X"},
                          {"X--------X"},
                          {"X--------X"},
                          {"XXXXXXXXXX"},};
    String[][] botRight = {{"XXXXX#XXXX"},
                          {"X--------X"},
                          {"X--------X"},
                          {"X--------X"},
                          {"X--------X"},
                          {"#--------X"},
                          {"X--------X"},
                          {"X--------X"},
                          {"X--------X"},
                          {"XXXXXXXXXX"},};
    
    
    
    
    public static String[][] getFullGrid()
    {
        String[][] fullGrid = new String[SIDE_LENGTH * 2][SIDE_LENGTH * 3];
       return topLeft;
/*        
        for(int i = 0; i < topLeft.length; i++)
        {
            for(int j = 0; j < topLeft.length; j++)
                fullGrid[i][j] = topLeft[i][j];
        }
        
        return fullGrid; */
    }
    
    
}
