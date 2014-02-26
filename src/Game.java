public class Game {
	
	int x = 221;
	float y = 50;
	float yVelocity = 0;
	float yAcceleration = 0.5f;
	boolean isJumping = false;
	
	public void update()
	{
		yVelocity += yAcceleration;
		if(isJumping)
		{
			yVelocity -= 20;
			isJumping = false;
		}
		y += yVelocity;
	}

}
