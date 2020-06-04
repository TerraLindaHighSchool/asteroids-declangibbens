import greenfoot.*;

/**
 * A rocket that can be controlled by the arrowkeys: up, left, right.
 * The gun is fired by hitting the 'space' key. 'z' releases a proton wave.
 * 
 * @author Poul Henriksen
 * @author Michael Kölling
 * 
 * @version 1.1
 */
public class Vehicle extends SmoothMover
{
    private GreenfootImage left = new GreenfootImage("left.png");
    private GreenfootImage right = new GreenfootImage("right.png");
    public int i = 0;
    /**
     * Initialise this rocket.
     */
    public Vehicle()
    {
        
       
    }

    /**
     * Do what a rocket's gotta do. (Which is: mostly flying about, and turning,
     * accelerating and shooting when the right keys are pressed.)
     */
    public void act()
    {
        checkKeys();
        checkCollision();
        
    }
    
    /**
     * Check whether there are any key pressed and react to them.
     */
    private void checkKeys() 
    {
        if (Greenfoot.isKeyDown("d")) 
        {
            setLocation(getX()+3, getY());
            setImage(right);
        }
        if (Greenfoot.isKeyDown("a")) 
        {
            setLocation(getX()-3, getY());
            setImage(left);
        }
    }

    private void checkCollision()
    {
        if( getOneIntersectingObject(Rock.class) != null || getOneIntersectingObject(MegaRock.class) != null) 
        {
           UnderGround underGround = (UnderGround) getWorld();
           underGround.addObject(new Explosion(), getX(), getY());
           underGround.removeObject(this);
           underGround.gameOver();
        }
    }
}