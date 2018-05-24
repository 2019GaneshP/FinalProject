
/**
 * Write a description of class Monster here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Monster extends MoveableChar
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Monster
     */
    public Monster()
    {
        super(new int[] {3,3},10,10,'M');
        x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
    public void attack()
    {
        //Todo
    }
}
