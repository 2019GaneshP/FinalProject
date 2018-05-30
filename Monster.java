
/**
 * Write a description of class Monster here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Monster extends MoveableChar
{
    private static final int NUM_MONSTER_TYPES = 2;
    
    
    /**
     * Constructor for objects of class Monster
     */
    public Monster(char icon)
    {
        super(new int[] {3,3},10,10,icon); //location is placeholder
    }
    
    public void moveMonster()
    {
        int r = (int) (Math.random() * 4);
        
        if(r == 0)
        {
            this.move("up");
        }
        if(r == 1)
        {
            this.move("down");
        }
        if(r == 2)
        {
            this.move("left");
        }
        if(r == 3)
        {
            this.move("right");
        }
    }
    
    public static Monster createMonster()
    {
        int r = (int) ( Math.random() * NUM_MONSTER_TYPES);
        
        if(r == 0)
            {
                return new Zombie();
            }
        else if(r == 1)
        {
            return new Mummy();
        }
        return null;
    }
    
}
