
/**
 * Write a description of interface MoveableChar here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class MoveableChar
{
    int[] pos = new int[2];
    private static int health;
    private static int attackDamage;
    
    public MoveableChar(int[] posIn, int healthIn, int dmgIn)
    {
        pos = posIn;
        health = healthIn;
        attackDamage = dmgIn;
    }
    
    public int[] getPos()
    {
        return pos;
    }
    
    public abstract void move();
    public abstract void attack();
}
