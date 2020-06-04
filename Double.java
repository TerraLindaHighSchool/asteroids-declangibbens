import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Points here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Double extends SmoothMover
{
    public int i;
    /**
     * Act - do whatever the Points wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if( getY() < 475)
        {
            setLocation(getX(), getY()+2);
        }
        if(isAtEdge() )
        {
            i++;
            if(i > 300)
            {
                getWorld().removeObject(this);
            }
        }
    }    
}
