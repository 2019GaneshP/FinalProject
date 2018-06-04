
/**
 * Write a description of class Sword here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Sword extends Item
{
    public Sword()
    {
        super('/');
    }
    
    public void effect()
    {
        Window.getGrid().characterAt(this.getPos()[0], this.getPos()[1]).changeDamage(2);
    }
    
}
