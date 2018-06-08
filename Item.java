
/**
 * Abstract class Item - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Item
{
    int[] pos = new int[2];
    private char icon;
    
    private static final int NUM_ITEM_TYPES = 3; // Change when adding items.
    
    public Item(char iconIn)
    {
        icon = iconIn;
        pos = generatePos(); 
        Window.getGrid().setGridChar(pos[0],pos[1],icon);
    }
    
    private int[] generatePos()
    {
        int r1 = (int)(Math.random() * Window.getGrid().getGridLength()); // row
        int r2 = (int)(Math.random() * Window.getGrid().getGridWidth()); //col
        while(Window.getGrid().getGrid()[r1][r2] != '-')
        {
            r1 = (int)(Math.random() * Window.getGrid().getGrid().length); // row
            r2 = (int)(Math.random() * Window.getGrid().getGrid()[0].length); //col
        }
        
        return new int[] {r1,r2};
    }
    
    public abstract void effect();
    
    public void pickUp()
    {
        this.effect();
        Window.getGrid().characterAt(pos[0],pos[1]).setPrevChar('-');
        
    }
    
    public int[] getPos()
    {
        return pos;
    }
    
    public static Item createStrawberry()
    {
        return new Strawberry();
    }
    
    public static Item createItem()
    {
        int r = (int) (Math.random() * NUM_ITEM_TYPES);
        
        if(r == 0)
        {
            return new Sword();
        }
        else if(r == 1)
        {
            return new Armor();
        }
        else if(r == 2)
        {
            return new Potion();
        }
        return null;
    }
}
