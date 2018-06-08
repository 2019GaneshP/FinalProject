
/**
 * Write a description of class Armor here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Armor extends Item
{
    public Armor()
    {
        super(']');
    }
    
    public void effect()
    {
        Window.getGrid().characterAt(this.getPos()[0], this.getPos()[1]).changeArmor(2);
    }
}
