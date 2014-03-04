
public class Paddle extends Block implements movingObject {

	boolean movingRight;
	boolean movingLeft;
	Paddle()
	{
		super();
		this.blockWidth = 80;
		this.boundingWidth = 80;
		this.blockHeight = 10;
		this.boundingHeight = 10;
		movingRight = false;
		movingLeft = false;
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
