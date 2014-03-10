import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Paddle extends Block implements movingObject {

	boolean movingRight;
	boolean movingLeft;
	int initialX = 246;
	int collideImageDisplayTime;
	BufferedImage paddleImage;
	BufferedImage collideImage;
	Game myGame;
	Paddle(Game currentGame)
	{
		super();
		myGame = currentGame;
		collideImageDisplayTime = 0;
		blockWidth = 80;
		boundingWidth = 80;
		blockHeight = 10;
		boundingHeight = 10;
		movingRight = false;
		movingLeft = false;
		try {
			paddleImage = ImageIO.read(new File("assets/paddle.png"));
			collideImage = ImageIO.read(new File("assets/paddle_bumped.png"));			
		} catch (IOException e) {
		}	
	}
	@Override
	public void draw(Graphics2D g2)
	{
		if(collideImageDisplayTime == 0)
			g2.drawImage(paddleImage, x - (blockWidth/2),(int)y - (blockHeight/2), null);
		else
			g2.drawImage(collideImage, x - (blockWidth/2),(int)y - (blockHeight/2), null);
	}

	public void setColliding()
	{
		collideImageDisplayTime = 10;		
	}
	public void reset()
	{
		x = initialX;		
	}
	@Override
	public void update() {		
		if(movingRight)
			xVelocity = 5;
		else if(movingLeft)
			xVelocity = -5;
		else
			xVelocity = 0;
		if(collideImageDisplayTime > 0)
			collideImageDisplayTime--;
	}

	@Override
	public void move() {	
		if((x + xVelocity) <= (myGame.width - (blockWidth / 2)))
		{
			x += xVelocity;		
		}
		else
		{
			x = myGame.width - blockWidth / 2;
		}
		if(!((x + xVelocity) >= (0 + (blockWidth / 2))))
			x = 0 + blockWidth / 2;
	
	}	
	
}
