import java.util.*;
/**
 * Write a description of class Grid here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Grid
{
    private char[][] grid;
    private static Player player;
    private ArrayList<Monster> monsters;
    private ArrayList<Item> items;
    private final int NUM_MONSTERS;
    private final int NUM_ITEMS;
    
    public Grid(int numMonstersIn, int numItemsIn)
    {
        NUM_MONSTERS = numMonstersIn;
        NUM_ITEMS = numItemsIn;
        grid = GridGeneration.getFullGrid();
        monsters = new ArrayList<Monster>();
        items = new ArrayList<Item>();
    }
    
    public void populate() //If in constructor, causes null pointer. Gets called by Window.
    {
        populateMonsters();
        populateItems();
    }
    
    public void createPlayer()
    {
        player = new Player();
    }
    
    private void populateMonsters()
    {
        for(int i = 0; i < NUM_MONSTERS; i++)
            this.addMonster(Monster.createMonster());
    }
    
    private void populateItems()
    {
         for(int i = 0; i < NUM_MONSTERS; i++)
            this.addItem(Item.createItem());
    }
    
    public void spawnStrawberry()
    {
        this.addItem(Item.createStrawberry());
    }
    
    /**
     * returns the whole grid. 
     */
    public char[][] getGrid()
    {
        return grid;
    }
    
    public int numMonsters()
    {
        return monsters.size();
    }
    
    public int numItems()
    {
        return items.size();
    }
    
    public int getGridLength()
    {
        return grid.length; //20 is placeholder 
    }
    
    public int getGridWidth()
    {
        return grid[0].length; //30 is placeholder
    }
    
    private void addMonster(Monster m)
    {
        monsters.add(m);
    }
    
    private void addItem(Item i)
    {
        items.add(i);
    }
    
    /**
     * Sets a certain position in the grid to a character. 
     * return: char that was there previously. 
     */
    public char setGridChar(int rowVal, int colVal, char charIn) 
    {
        char tempChar = grid[rowVal][colVal];
        grid[rowVal][colVal] = charIn;
        return tempChar;
    }
    
    public MoveableChar characterAt(int x, int y)
    {
        for(Monster m : monsters)
            if(m.getPos()[0] == x && m.getPos()[1] == y)
                return m;
        if(player.getPos()[0] == x && player.getPos()[1] == y)
            return player;
        return null;        
    }
    
    public Item itemAt(int x, int y)
    {
        for(Item i : items)
            if(i.getPos()[0] == x && i.getPos()[1] == y)
                return i;
        return null;
    }
    
    /**
     * returns the char at a certain position in the grid.
     */
    public char getGridChar(int rowVal, int colVal)
    {
        return grid[rowVal][colVal];
    }
    
    public void removeMonster(Monster m)
    {
        monsters.remove(m);
    }
    
    public void kill()
    {
        Window.setGrid(null);
    }
    
    private void refreshOutput()
    {
        System.out.print("\f");
        System.out.println("Your health is: " + player.getHealth() + ", your damage is: " + player.getDamage() +
        ", and your armor is: " + player.getArmor());
    }
    
    /**
     * processes inputs by user to move player char. 
     * will add to this later.
     */
    public void processKeyPress(int keyCode)
    {
        
        if(keyCode == 37)
        {
            refreshOutput();
            player.move("left");
        }
        else if(keyCode == 38)
        {
            refreshOutput();
            player.move("up");
        }   
        else if(keyCode == 39)
        {
            refreshOutput();
            player.move("right");
        }
        else if(keyCode == 40)
        {
            refreshOutput();
            player.move("down");
        }
        else if(keyCode == 71)
        {
            Item it = player.pickUp();
            if(it != null)
                items.remove(it);
            refreshOutput();
        }
        else if(keyCode == 46)
        {
            refreshOutput();
            if(Window.getGrid().numMonsters() == 0 && Window.getGrid().numItems() == 0)
                Window.changeGridDown();
            else
                System.out.println("Kill all monsters and pick up all items first!");
        }
        else if(keyCode == 44)
        {
            refreshOutput();
            if(!Player.getStrawberryStatus())
                System.out.println("You can't leave the dungeon!");
            else
                System.out.println("YOU WIN!");
            
        }
        try
        {    
            for(Monster m : monsters)
            {
                m.moveMonster();
            }
        }
        catch(ConcurrentModificationException e)
        {
            //Do nothing
        }
    }
}
