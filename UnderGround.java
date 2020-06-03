import greenfoot.*;

/**
 * Space. Something for rockets to fly in.
 * 
 * @author Michael Kölling
 * @version 1.1
 */
public class UnderGround extends World
{
    private Counter scoreCounter;
    private int startAsteroids = 3;
    public int random;
    public boolean end = false;
    public int e = 0;
    public int i = 0;
    public int platform = 0;
    public int k = 0;
    public int life = 0;
    public int score;
    /**
     * Create the space and all objects within it.
     */
    public UnderGround() 
    {
        super(600, 500, 1);
        GreenfootImage background = getBackground();
        background.setColor(new Color(102, 51, 0));
        background.fill();

        Vehicle vehicle = new Vehicle();
        addObject(vehicle, getWidth()/2, getHeight()-20);
        addDetail();
        addRocks(startAsteroids);
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
    private void addRocks(int count) 
    {
        for(int i = 0; i < count; i++) 
        {
            int x = Greenfoot.getRandomNumber(600);
            addObject(new Rock(), x, 0);
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
        score = score + scoreCounter.getValue();
        if(end != false)
        {
            e++;
        }
        if(e > 25)
        {
            Greenfoot.stop();
            removeObjects(getObjects(Rock.class));
        }
        i++;
        if( i % 60 == 0)
        {
            updateScore(1);
        }
        if(scoreCounter.getValue() % 10 == 0 && platform == 0)
        {
            int x = Greenfoot.getRandomNumber(600);
            addObject(new Platform(), x, 440);
            platform++;
        }
        k++;
        if(k % 60 == 0 && platform == 1)
        {
            life++;
            int p = Greenfoot.getRandomNumber(10);
            p = p + 10;
            if(life > p)
            {
                removeObjects(getObjects(Platform.class));
                platform--;
                life = 0;
            }
        }
    }
}