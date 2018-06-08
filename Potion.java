
/**
 * Write a description of class Potion here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Potion extends Item
{
    public Potion()
    {
        super('!');
    }
    
    public void effect()
    {
        Window.getGrid().characterAt(this.getPos()[0], this.getPos()[1]).changeHealth(2);
    }
}
