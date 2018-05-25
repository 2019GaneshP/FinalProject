
/**
 * Write a description of class Monster here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Monster extends MoveableChar
{

    /**
     * Constructor for objects of class Monster
     */
    public Monster()
    {
        super(new int[] {3,3},10,10,'M');
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
    
    
    public void attack()
    {
        //Todo
    }
}
