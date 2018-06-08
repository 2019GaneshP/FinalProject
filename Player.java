
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player extends MoveableChar
{
    private static boolean hasStrawberry;
    public Player()
    {
        super(10,1,'@');   
        hasStrawberry = false;
    }
    
    public Item pickUp()
    {
        Item i = Window.getGrid().itemAt(this.getPos()[0],this.getPos()[1]);
        if(i != null)
            i.pickUp();
        return i;
    }
    
    public static void setStrawberryStatus(boolean in)
    {
        hasStrawberry = true;
    }
    
    public static boolean getStrawberryStatus()
    {
        return hasStrawberry;
    }
    
    public String getName()
    {
        return "Player";
    }
}
