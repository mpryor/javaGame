import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


//Test 
//Comment
public class Ball extends collisionObject implements drawableObject, movingObject {

	int ballWidth;
	int ballHeight;
	boolean isJumping = false;
	boolean moveLeft = false;
	boolean moveRight = false;
	final int INITIALX = 246;
	final int INITIALY = 200;
	final int INITIALYVELOCITY = 5;
	final int INITIALXVELOCITY = 0;
	BufferedImage ballImage;
	Game myGame;
	
	Ball(Game currentGame)
	{
		x = INITIALX;
		y = INITIALY;
		yVelocity = INITIALYVELOCITY;
		xVelocity = INITIALXVELOCITY;
		xAcceleration = 0;
		yAcceleration = 0;
		myGame = currentGame;	
		try {
			ballImage = ImageIO.read(new File("assets/ball.png"));			
		} catch (IOException e) {
		}	
		ballWidth = ballImage.getWidth();
		ballHeight = ballImage.getHeight();
		boundingWidth = ballWidth;
		boundingHeight = ballHeight;
	}
	
	public void reset()
	{
		x = INITIALX;
		y = INITIALY;
		yVelocity = INITIALYVELOCITY;
		xVelocity = INITIALXVELOCITY;
	}

	public void draw(Graphics2D g2)
	{
		g2.drawImage(ballImage, x - (ballWidth/2),(int)y - (ballHeight/2), null);
	}
	
	@Override
	public void update()
	{
		if(myGame.magnetism)
		{
			float magnetismFactor = (float)Math.abs(myGame.thePaddle.x - myGame.theBall.x) / (float)myGame.width;
			if((myGame.thePaddle.x - myGame.theBall.x) > 0)
			{
				xVelocity = 40 * magnetismFactor;
			}
			else if((myGame.thePaddle.x - myGame.theBall.x) < 0)
			{
				xVelocity = -40 * magnetismFactor;			
			}
			else
			{
				xVelocity = 0;
			}
		}
	}

	@Override
	
	public void move() {
		x += xVelocity;		
		y += yVelocity;
		int leftSide = x - boundingWidth/2;
		int rightSide = x + boundingWidth/2;
		float bottom = y + boundingHeight / 2;
		float top = y - boundingHeight / 2;
		if((rightSide >= myGame.width)||(leftSide <= 0))
		{
			if(leftSide <= 0)
				x = boundingWidth / 2;
			else
				x = myGame.width - boundingWidth / 2;
			xVelocity = -xVelocity;
		}
		if((bottom >= myGame.height)||(top <= 0))
		{
			if(top <= 0)
			{
				y = boundingHeight /2;
				yVelocity = -yVelocity;
			}
			else
				myGame.reset();		
		}
		
	}	
}
