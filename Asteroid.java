import greenfoot.*;

/**
 * A rock in space.
 * 
 * @author Poul Henriksen
 * @author Michael Kölling
 */
public class Asteroid extends SmoothMover
{
    /** Size of this asteroid */
    private int size;

    /** When the stability reaches 0 the asteroid will explode */
    private int stability;
    public int x;

    /**
     * Create an asteroid with default size and random direction of movement.
     */
    public Asteroid()
    {
        this(50);
       
    }
    
    /**
     * Create an asteroid with a given size and random direction of movement.
     */
    public Asteroid(int size)
    {
        super(new Vector(Greenfoot.getRandomNumber(360), 2));
        setSize(size);
    }
    
    /**
     * Create an asteroid with a given size and direction of movement.
     */
    public Asteroid(int size, Vector velocity)
    {
        super(velocity);
        setSize(size);
    }
    
    public void act()
    {         
        setLocation(getX(), getY()+3);
        if(isAtEdge())
        {
            addNewAsteroid();
            getWorld().removeObject(this);
        }
        
    }
    
    private void addNewAsteroid()
    {
        int x = Greenfoot.getRandomNumber(600);
        
        getWorld().addObject(new Asteroid(), x, 0);
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
