import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Platform here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Platform extends Actor
{
    private GreenfootImage platform1 = new GreenfootImage("platform1.jpg");
    private GreenfootImage platform2 = new GreenfootImage("platform2.jpg");
    private GreenfootImage platform3 = new GreenfootImage("platform3.jpg");
    /**
     * Act - do whatever the Platform wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        int life = ((UnderGround)getWorld()).life;
        if(life < 5)
        {
            setImage(platform1);
        }
        if(life > 5)
        {
            setImage(platform2);
        }
        if(life > 8)
        {
            setImage(platform3);
        }
    }
}