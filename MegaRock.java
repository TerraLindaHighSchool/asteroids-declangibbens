import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MegaRock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MegaRock extends SmoothMover
{
    /**
     * Act - do whatever the MegaRock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        int speed = ((UnderGround)getWorld()).speed;
        setLocation(getX(), getY()+speed);
        if(isAtEdge() )
        {
            getWorld().removeObject(this);
            return;
        }
        if(isTouching(Platform.class))
        {
            removeTouching(Platform.class);
            return;
        }
    }    
}
