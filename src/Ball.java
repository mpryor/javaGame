import java.awt.Color;
import java.awt.Graphics;

public class Ball extends collisionObject implements drawableObject, movingObject {

	final int BALLWIDTH =  50;
	final int BALLHEIGHT = 50;
	boolean isJumping = false;
	boolean moveLeft = false;
	boolean moveRight = false;
	
	Ball()
	{
		x = 246;
		y = 200;
		yVelocity = 0;
		xAcceleration = -.5f;
		yAcceleration = .5f;
		boundingWidth = 50;
		boundingHeight = 50;
	}

	public void draw(Graphics g)
	{
	      g.setColor(Color.YELLOW);
	      g.fillOval(x - (BALLWIDTH/2),(int)y - (BALLHEIGHT/2),BALLWIDTH,BALLHEIGHT);
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
		
	}
	
}
