
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
        super(10,1,'@');   
    }
    
    public Item pickUp()
    {
        Item i = Window.getGrid().itemAt(this.getPos()[0],this.getPos()[1]);
        if(i != null)
            i.pickUp();
        return i;
    }
    
    public String getName()
    {
        return "Player";
    }
}
