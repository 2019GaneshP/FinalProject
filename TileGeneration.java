
/**
 * Write a description of class TileGeneration here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TileGeneration
{
    private static final int SIDE_LENGTH = 10;
    private static String[] topLeft = {"XXXXXXXXXX",
                                         "X--------X",
                                         "X--------X",
                                         "X--------X",
                                         "X--------X",
                                         "X--------#",
                                         "X--------X",
                                         "X--------X",
                                         "X--------X",
                                         "XXXXX#XXXX",};
                                         
    private static String[] topCenter ={"XXXXXXXXXX",
                                         "X--------X",
                                         "X--------X",
                                         "X--------X",
                                         "X--------X",
                                         "#--------#",
                                         "X--------X",
                                         "X--------X",
                                         "X--------X",
                                         "XXXXX#XXXX",};
                                         
    private static String[] topRight = {"XXXXXXXXXX",
                                         "X--------X",
                                         "X--------X",
                                         "X--------X",
                                         "X--------X",
                                         "#--------X",
                                         "X--------X",
                                         "X--------X",
                                         "X--------X",
                                         "XXXXX#XXXX",};
                                        
    private static String[] botLeft = {"XXXXX#XXXX",
                                         "X--------X",
                                         "X--------X",
                                         "X--------X",
                                         "X--------X",
                                         "X--------#",
                                         "X--------X",
                                         "X--------X",
                                         "X--------X",
                                         "XXXXXXXXXX",};
                                         
    private static String[] botCenter ={"XXXXX#XXXX",
                                         "X--------X",
                                         "X--------X",
                                         "X--------X",
                                         "X--------X",
                                         "#--------#",
                                         "X--------X",
                                         "X--------X",
                                         "X--------X",
                                         "XXXXXXXXXX",};
                                         
    private static String[] botRight = {"XXXXX#XXXX",
                                         "X--------X",
                                         "X--------X",
                                         "X--------X",
                                         "X--------X",
                                         "#--------X",
                                         "X--------X",
                                         "X--------X",
                                         "X--------X",
                                         "XXXXXXXXXX",};
    
    
    /**
     * ADJUST BELOW ALGORITHM AND ABOVE DECLARATIONS TO DEAL WITH SINGLE ARRAY TILES, CONVERT TO 
     * 2D ARRAY FOR PURPOSES OF RENDERING!!!
     */
    public static String[][] getFullGrid()
    {
        String[][] fullGrid = new String[topLeft.length + botLeft.length][3];
       //return topLeft;
        
        for(int i = 0; i < topLeft.length; i++)
        {
            
                fullGrid[i][0] = topLeft[i];
        }
        
        for(int i = 0; i < topCenter.length; i++)
        {
            
                fullGrid[i][1] = topCenter[i];
        }
        
        for(int i = 0; i < topRight.length; i++)
        {
            
                fullGrid[i][2] = topRight[i];
        }
        
        for(int i = botLeft.length; i < fullGrid.length; i++)
        {
            
                fullGrid[i][0] = botLeft[i - botLeft.length];
        }
        
        for(int i = botCenter.length; i < fullGrid.length; i++)
        {
            
                fullGrid[i][1] = botCenter[i - botCenter.length];
        }
        
        for(int i = botRight.length; i < fullGrid.length; i++)
        {
            
                fullGrid[i][2] = botRight[i - botRight.length];
        }
        
        
        for(String[] row : fullGrid)
        {
            for(String c : row)
            {
                System.out.print(c);
            }
            System.out.println();
        }
        
        return fullGrid; 
    }
    
    
}
