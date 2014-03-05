import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Paddle extends Block implements movingObject {

	boolean movingRight;
	boolean movingLeft;
	int initialX = 246;
	BufferedImage paddleImage;
	Paddle()
	{
		super();
		this.blockWidth = 80;
		this.boundingWidth = 80;
		this.blockHeight = 10;
		this.boundingHeight = 10;
		movingRight = false;
		movingLeft = false;
		try {
			paddleImage = ImageIO.read(new File("src/paddle.png"));
			
		} catch (IOException e) {
		}	
	}
	@Override
	public void draw(Graphics2D g2)
	{
		g2.drawImage(paddleImage, x - (blockWidth/2),(int)y - (blockHeight/2), null);
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
	}

	@Override
	public void move() {	
		if((x + xVelocity) <= (500 - (blockWidth / 2)))
		{
			x += xVelocity;		
		}
		else
		{
			x = 500 - blockWidth / 2;
		}
		if(!((x + xVelocity) >= (0 + (blockWidth / 2))))
			x = 0 + blockWidth / 2;
	
	}	
	
}
