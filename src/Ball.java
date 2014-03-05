import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Ball extends collisionObject implements drawableObject, movingObject {

	final int BALLWIDTH =  50;
	final int BALLHEIGHT = 50;
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
		boundingWidth = 50;
		boundingHeight = 50;
		myGame = currentGame;	
		try {
			ballImage = ImageIO.read(new File("src/ball.png"));
			
		} catch (IOException e) {
		}	
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
		/*
	      g.setColor(Color.YELLOW);
	      g.fillOval(x - (BALLWIDTH/2),(int)y - (BALLHEIGHT/2),BALLWIDTH,BALLHEIGHT);
	      */
		g2.drawImage(ballImage, x - (BALLWIDTH/2),(int)y - (BALLHEIGHT/2), null);
	}
	@Override
	public void update()
	{
		yVelocity += yAcceleration;
		if(isJumping)
		{
			yVelocity -= 10;
			isJumping = false;
		}
		if(xVelocity > 0)
		{
			xVelocity += xAcceleration;
			if(xVelocity < 0)
				xVelocity = 0;
		}
		else if(xVelocity <  0)
		{
			xVelocity -= xAcceleration;
			if(xVelocity > 0)
				xVelocity = 0;
		}
		if(moveRight)
		{
			xVelocity = 5;
		}
		else if(moveLeft)
		{
			xVelocity = -5;
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
		if((rightSide >= 500)||(leftSide <= 0))
		{
			if(leftSide <= 0)
				x = boundingWidth / 2;
			else
				x = 500 - boundingWidth / 2;
			xVelocity = -xVelocity;
		}
		if((bottom >= 500)||(top <= 0))
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
