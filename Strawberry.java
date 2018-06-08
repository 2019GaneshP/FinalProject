
/**
 * Write a description of class Strawberry here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Strawberry extends Item
{
    public Strawberry()
    {
        super('*');
    }
    
    public void effect()
    {
        Player.setStrawberryStatus(true);
    }
    
}
