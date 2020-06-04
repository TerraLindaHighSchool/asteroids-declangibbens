import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FastRock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FastRock extends SmoothMover
{
    /**
       * Act - do whatever the FastRock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        int speed = ((UnderGround)getWorld()).speed;
        speed = speed * 2;
        setLocation(getX(), getY()+speed);
        if(isAtEdge()  || getOneIntersectingObject(Platform.class) != null )
        {
            getWorld().removeObject(this);
        }
    }    
}
