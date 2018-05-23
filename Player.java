
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player extends MoveableChar
{
    
    public Player()
    {
        super(new int[] {0,0},10,10);
    }
    
    public void move(String dir)
    {
       
            if(dir.equals("left"))
            {
                pos[1]--;
                System.out.println("After left:" + pos[0]);
            }
            if(dir.equals("right"))
            {
                pos[1]++;
                            System.out.println("After right:" + pos[0]);
            }
            if(dir.equals("up"))
            {
                pos[0]--;
            }   
            if(dir.equals("down"))
            {
                pos[0]++;
            }
            for(int i = 0; i < pos.length; i++)
            {
                System.out.println(pos[i]);
            }
        

    }
    
    public void attack()
    {
        //TODO
    }
}
