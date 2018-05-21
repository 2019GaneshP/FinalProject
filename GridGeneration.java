
/**
 * Write a description of class TileGeneration here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GridGeneration
{
    private static final int SIDE_LENGTH = 10;
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
    public static char[][] getFullGrid()
    {
        char[][] fullGrid = new char[topLeft.length + botLeft.length][topLeft[0].length + topCenter[0].length + topRight[0].length];
       //return topLeft;
        
        for(int i = 0; i < topLeft.length; i++)
        {
            for(int j = 0; j < topLeft[0].length; j++)
                fullGrid[i][j] = topLeft[i][j];
        }
        
        for(int i = 0; i < topCenter.length; i++)
        {
            for(int j = topLeft[0].length; j < topCenter[0].length + topLeft[0].length; j++)
                fullGrid[i][j] = topCenter[i][j]; //ADD SUBTRACTION
        }
        
        for(int i = 0; i < topRight.length; i++)
        {
            for(int j = topLeft[0].length + topCenter[0].length; j < topRight[0].length + j = topLeft[0].length + topCenter[0].length; j++)
                fullGrid[i][j] = topRight[i][j];
        }
        
        for(int i = 0; i < botLeft.length; i++)
        {
            for(int j = 0; j < botLeft[0].length; j++)
                fullGrid[i][j] = botLeft[i][j];
        }
        
        for(int i = 0; i < botCenter.length; i++)
        {
            for(int j = 0; j < botCenter[0].length; j++)
                fullGrid[i][j] = botCenter[i][j];
        }
        
        for(int i = 0; i < botRight.length; i++)
        {
            for(int j = 0; j < botRight[0].length; j++)
                fullGrid[i][j] = botRight[i][j];
        }
        
        Player p = new Player();
        int[] playerPos = p.getPos();
        
        
        fullGrid[playerPos[0]][playerPos[1]] = "@";
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
