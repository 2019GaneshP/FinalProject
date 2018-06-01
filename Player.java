
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
    
    public void pickUp()
    {
        Window.getGrid().itemAt(this.getPos()[0],this.getPos()[1]).pickUp();
    }
    
    public String getName()
    {
        return "Player";
    }
}
