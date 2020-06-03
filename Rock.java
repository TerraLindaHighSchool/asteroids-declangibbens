import greenfoot.*;

/**
 * A rock in space.
 * 
 * @author Poul Henriksen
 * @author Michael Kölling
 */
public class Rock extends SmoothMover
{
    /** Size of this asteroid */
    private int size;

    /** When the stability reaches 0 the asteroid will explode */
    private int stability;
    public int x;
    
    /**
     * Create an asteroid with default size and random direction of movement.
     */
    public Rock()
    {
        this(50);
       
    }
    
    /**
     * Create an asteroid with a given size and random direction of movement.
     */
    public Rock(int size)
    {
        super(new Vector(Greenfoot.getRandomNumber(360), 2));
        setSize(size);
    }
    
    /**
     * Create an asteroid with a given size and direction of movement.
     */
    public Rock(int size, Vector velocity)
    {
        super(velocity);
        setSize(size);
    }
    
    public void act()
    {         
        int speed = ((UnderGround)getWorld()).speed;
        setLocation(getX(), getY()+speed);
        
        if(isAtEdge()  || getOneIntersectingObject(Platform.class) != null )
        {
            addNewRock();
            getWorld().removeObject(this);
        }
        
    }
    
    private void addNewRock()
    {
        int x = Greenfoot.getRandomNumber(600);
        
        getWorld().addObject(new Rock(), x, 0);
    }
    /**
     * Set the size of this asteroid. Note that stability is directly
     * related to size. Smaller asteroids are less stable.
     */
    public void setSize(int size) 
    {
        stability = size;
        this.size = size;
        GreenfootImage image = getImage();
        image.scale(size, size);
    }
}
