import java.awt.Color;
import java.awt.Graphics;

public class Ball extends collisionObject implements drawableObject, gravityObject {

	final int BALLWIDTH =  50;
	final int BALLHEIGHT = 50;
	boolean isJumping = false;
	
	Ball()
	{
		x = 246;
		y = 200;
		yVelocity = 0;
		yAcceleration = .5f;
		boundingWidth = 50;
		boundingHeight = 50;
	}

	public void draw(Graphics g)
	{
	      g.setColor(Color.YELLOW);
	      g.fillOval(x - (BALLWIDTH/2),(int)y - (BALLHEIGHT/2),BALLWIDTH,BALLHEIGHT);
	}
	
	public void applyGravity()
	{
		yVelocity += yAcceleration;
		if(isJumping)
		{
			yVelocity -= 10;
			isJumping = false;
		}
		y += yVelocity;
	}
	
}
