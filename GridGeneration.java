
/**
 * Generates the grid that the game will be played on
 * Work in progress
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GridGeneration
{
    private static final int SIDE_LENGTH = 10;
    private char[][] totalGrid = this.getFullGrid();
    private static char[][] topLeft = {{'X','X','X','X','X','X','X','X','X','X'},
                                       {'X','-','-','-','-','-','-','-','-','X'},      //ALL OF THIS IS TEMPORARY AND SIMPLY FOR
                                       {'X','-','-','-','-','-','-','-','-','X'},     //TESTING PURPOSES, UNTIL I FIGURE OUT HOW
                                       {'X','-','-','-','-','-','-','-','-','X'},     //TO DO A GENERATION ALGORITHM.
                                       {'X','-','-','-','-','-','-','-','-','X'},
                                       {'X','-','-','-','-','-','-','-','-','#'},
                                       {'X','-','-','-','-','-','-','-','-','X'},
                                       {'X','-','-','-','-','-','-','-','-','X'},
                                       {'X','-','-','-','-','-','-','-','-','X'},
                                       {'X','X','X','X','X','#','X','X','X','X'},};
                                         
    private static char[][] topCenter ={{'X','X','X','X','X','X','X','X','X','X'},
                                       {'X','-','-','-','-','-','-','-','-','X'},      //ALL OF THIS IS TEMPORARY AND SIMPLY FOR
                                       {'X','-','-','-','-','-','-','-','-','X'},     //TESTING PURPOSES, UNTIL I FIGURE OUT HOW
                                       {'X','-','-','-','-','-','-','-','-','X'},     //TO DO A GENERATION ALGORITHM.
                                       {'X','-','-','-','-','-','-','-','-','X'},
                                       {'#','-','-','-','-','-','-','-','-','#'},
                                       {'X','-','-','-','-','-','-','-','-','X'},
                                       {'X','-','-','-','-','-','-','-','-','X'},
                                       {'X','-','-','-','-','-','-','-','-','X'},
                                       {'X','X','X','X','X','#','X','X','X','X'},};
                                         
    private static char[][] topRight ={{'X','X','X','X','X','X','X','X','X','X'},
                                       {'X','-','-','-','-','-','-','-','-','X'},      //ALL OF THIS IS TEMPORARY AND SIMPLY FOR
                                       {'X','-','-','-','-','-','-','-','-','X'},     //TESTING PURPOSES, UNTIL I FIGURE OUT HOW
                                       {'X','-','-','-','-','-','-','-','-','X'},     //TO DO A GENERATION ALGORITHM.
                                       {'X','-','-','-','-','-','-','-','-','X'},
                                       {'#','-','-','-','-','-','-','-','-','X'},
                                       {'X','-','-','-','-','-','-','-','-','X'},
                                       {'X','-','-','-','-','-','-','-','-','X'},
                                       {'X','-','-','-','-','-','-','-','-','X'},
                                       {'X','X','X','X','X','#','X','X','X','X'},};
                                        
    private static char[][] botLeft = {{'X','X','X','X','X','#','X','X','X','X'},
                                       {'X','-','-','-','-','-','-','-','-','X'},      //ALL OF THIS IS TEMPORARY AND SIMPLY FOR
                                       {'X','-','-','-','-','-','-','-','-','X'},     //TESTING PURPOSES, UNTIL I FIGURE OUT HOW
                                       {'X','-','-','-','-','-','-','-','-','X'},     //TO DO A GENERATION ALGORITHM.
                                       {'X','-','-','-','-','-','-','-','-','X'},
                                       {'X','-','-','-','-','-','-','-','-','#'},
                                       {'X','-','-','-','-','-','-','-','-','X'},
                                       {'X','-','-','-','-','-','-','-','-','X'},
                                       {'X','-','-','-','-','-','-','-','-','X'},
                                       {'X','X','X','X','X','X','X','X','X','X'},};
                                         
    private static char[][] botCenter ={{'X','X','X','X','X','#','X','X','X','X'},
                                       {'X','-','-','-','-','-','-','-','-','X'},      //ALL OF THIS IS TEMPORARY AND SIMPLY FOR
                                       {'X','-','-','-','-','-','-','-','-','X'},     //TESTING PURPOSES, UNTIL I FIGURE OUT HOW
                                       {'X','-','-','-','-','-','-','-','-','X'},     //TO DO A GENERATION ALGORITHM.
                                       {'X','-','-','-','-','-','-','-','-','X'},
                                       {'#','-','-','-','-','-','-','-','-','#'},
                                       {'X','-','-','-','-','-','-','-','-','X'},
                                       {'X','-','-','-','-','-','-','-','-','X'},
                                       {'X','-','-','-','-','-','-','-','-','X'},
                                       {'X','X','X','X','X','X','X','X','X','X'},};
                                         
    private static char[][] botRight = {{'X','X','X','X','X','#','X','X','X','X'},
                                       {'X','-','-','-','-','-','-','-','-','X'},      //ALL OF THIS IS TEMPORARY AND SIMPLY FOR
                                       {'X','-','-','-','-','-','-','-','-','X'},     //TESTING PURPOSES, UNTIL I FIGURE OUT HOW
                                       {'X','-','-','-','-','-','-','-','-','X'},     //TO DO A GENERATION ALGORITHM.
                                       {'X','-','-','-','-','-','-','-','-','X'},
                                       {'#','-','-','-','-','-','-','-','-','X'},
                                       {'X','-','-','-','-','-','-','-','-','X'},
                                       {'X','-','-','-','-','-','-','-','-','X'},
                                       {'X','-','-','-','-','-','-','-','-','X'},
                                       {'X','X','X','X','X','X','X','X','X','X'},};
    
    
    /**
     * Returns the full grid that will be painted. This is the bulk of the work. 
     */
    public static char[][] getFullGrid() // For testing. Rename method to combineSegments or something 
    {                                    // once implement random generation of segments.
        char[][] fullGrid = new char[topLeft.length + botLeft.length][topLeft[0].length + topCenter[0].length + topRight[0].length];

        
        for(int i = 0; i < topLeft.length; i++)
        {
            for(int j = 0; j < topLeft[0].length; j++)
                fullGrid[i][j] = topLeft[i][j];
        }
        
        for(int i = 0; i < topCenter.length; i++)
        {
            for(int j = topLeft[0].length; j < topCenter[0].length + topLeft[0].length; j++)
                fullGrid[i][j] = topCenter[i][j - (topLeft[0].length)];
        }
        
        for(int i = 0; i < topRight.length; i++)
        {
            for(int j = topLeft[0].length + topCenter[0].length; j < topRight[0].length +  topLeft[0].length + topCenter[0].length; j++)
                fullGrid[i][j] = topRight[i][j - (topLeft[0].length + topCenter[0].length)];
        }
        
        for(int i = topLeft.length; i < botLeft.length + topLeft.length; i++)
        {
            for(int j = 0; j < botLeft[0].length; j++)
                fullGrid[i][j] = botLeft[i - topLeft.length][j];
        }
        
        for(int i = topCenter.length; i < botCenter.length + topCenter.length; i++)
        {
            for(int j = botRight[0].length; j < botCenter[0].length + botLeft[0].length; j++)
                fullGrid[i][j] = botCenter[i - topCenter.length][j - botLeft[0].length];
        }
        
        for(int i = topRight.length; i < botRight.length + topRight.length; i++)
        {
            for(int j = botLeft[0].length + botCenter[0].length; j < botRight[0].length + botLeft[0].length + botCenter[0].length; j++)
                fullGrid[i][j] = botRight[i - topRight.length][j - (botLeft[0].length + botCenter[0].length)];
        }
        
        return fullGrid; 
    }
    
}
