import greenfoot.*;

/**
 * Space. Something for rockets to fly in.
 * 
 * @author Michael Kölling
 * @version 1.1
 */
public class Space extends World
{
    private Counter scoreCounter;
    private int startAsteroids = 3;
    public int random;
    public boolean end = false;
    public int e = 0;
    /**
     * Create the space and all objects within it.
     */
    public Space() 
    {
        super(600, 500, 1);
        GreenfootImage background = getBackground();
        background.setColor(new Color(102, 51, 0));
        background.fill();

        Rocket rocket = new Rocket();
        addObject(rocket, getWidth()/2, getHeight()-20);
        addDetail();
        addAsteroids(startAsteroids);
        paintRocks(150);

        scoreCounter = new Counter("Score: ");
        addObject(scoreCounter, 60, 480);
        
        
        

        Explosion.initializeImages();
        ProtonWave.initializeImages();
        prepare();
    }

    /**
     * Add a given number of asteroids to our world. Asteroids are only added into
     * the left half of the world.
     */
    private void addAsteroids(int count) 
    {
        for(int i = 0; i < count; i++) 
        {
            int x = Greenfoot.getRandomNumber(600);
            addObject(new Asteroid(), x, 0);
        }
    }

    private void paintRocks(int count)
    {
        for(int i = 0; i < count; i++)
        {
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            int d = Greenfoot.getRandomNumber(80);
            Color random = new Color(d+48, d+48, d+48);
            GreenfootImage background = getBackground();
            background.setColor(random);
            background.fillOval(x, y, 4, 4);
        }
    }
    private void addDetail()
    {
        int x = Greenfoot.getRandomNumber(getWidth());
        int y = Greenfoot.getRandomNumber(getHeight()/2);
        
        addObject(new Skull(),x , y);
        int h = Greenfoot.getRandomNumber(getWidth());
        int j = Greenfoot.getRandomNumber(getHeight()-80);
        
        addObject(new Skeleton(),h, j);
    }

    /**
     * This method is called when the game is over to display the final score.
     */
    public void gameOver() 
    {
        int x = getWidth() / 2;
        int y = getHeight() / 2;
        int currentScore = scoreCounter.getValue();
        addObject(new ScoreBoard(currentScore),x ,y);
        end = true;
    }

    public void updateScore(int addToScore)
    {
        scoreCounter.add(addToScore);
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        
        
    }
    public void act()
    {
        if(end != false)
        {
            e++;
        }
        if(e > 25)
        {
            Greenfoot.stop();
            removeObjects(getObjects(Asteroid.class));
        }
    }
}